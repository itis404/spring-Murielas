document.addEventListener("DOMContentLoaded", () => {
    loadInstruments();
    loadSounds();

    document.getElementById("searchBtn").addEventListener("click", search);
    document.getElementById("instrumentForm").addEventListener("submit", createInstrument);
});

function loadInstruments() {
    fetch("/api/instruments")
        .then(r => r.json())
        .then(data => {
            console.log("INSTRUMENTS:", data);

            const select = document.getElementById("instrumentSelect");
            select.innerHTML = "";

            if (!data || data.length === 0) {
                const opt = document.createElement("option");
                opt.textContent = "Нет инструментов";
                opt.value = "";
                select.appendChild(opt);
                return;
            }

            data.forEach(i => {
                const opt = document.createElement("option");
                opt.value = i.id;
                opt.textContent = i.name;
                select.appendChild(opt);
            });

            select.selectedIndex = 0;
        })
        .catch(err => console.error("loadInstruments error:", err));
}

async function createInstrument(e) {
    e.preventDefault();

    const name = document.getElementById("instrumentName").value.trim();
    const description = document.getElementById("instrumentDescription").value.trim();

    if (!name) {
        alert("Название обязательно");
        return;
    }

    await fetch("/api/admin/instrument", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, description })
    });

    e.target.reset();
    loadInstruments();
}

async function loadSounds() {
    const res = await fetch("/api/sounds");
    const data = await res.json();

    const table = document.getElementById("soundTable");
    const header = table.querySelector("tr");

    table.innerHTML = "";
    table.appendChild(header);

    data.forEach(s => {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${s.id}</td>
            <td>${s.soundName}</td>
            <td>${s.noteName}</td>
            <td>${s.instrumentName}</td>
            <td>
                <button onclick="deleteSound(${s.id})">Удалить</button>
            </td>
        `;

        table.appendChild(row);
    });
}

function saveSound(id, name, audioUrl) {
    const instrumentSelect = document.getElementById("instrumentSelect");
    const noteSelect = document.getElementById("noteSelect");

    const instrumentId = instrumentSelect.value;
    const noteName = noteSelect.value;

    if (!instrumentId) {
        alert("Выбери инструмент");
        return;
    }

    fetch("/api/sounds", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            freesoundId: id,
            soundName: name,
            noteName: noteName,
            instrumentId: Number(instrumentId),
            audioUrl: audioUrl
        })
    })
    .then(r => {
        if (!r.ok) return r.text().then(t => { throw new Error(t); });
        return r.json();
    })
    .then(() => loadSounds())
    .catch(err => console.error("saveSound error:", err));
}

async function deleteSound(id) {
    await fetch(`/api/sounds/${id}`, { method: "DELETE" });
    loadSounds();
}

async function search() {
    const q = document.getElementById("searchQuery").value;
    if (!q) return;

    const res = await fetch(`/api/admin/search?query=${encodeURIComponent(q)}`);
    const data = await res.json();

    const div = document.getElementById("searchResults");
    div.innerHTML = "";

    data.forEach(s => {
        const audioUrl = s.previews?.["preview-hq-mp3"] ||
                        s.previews?.["preview-lq-mp3"] ||
                        "";

        div.innerHTML += `
            <div style="margin-bottom:10px; padding:10px; border:1px solid #ccc;">
                <strong>${s.name}</strong><br>
                <small>by ${s.username || 'Unknown'}</small><br>
                <button onclick="saveSound('${s.id}', '${s.name}', '${audioUrl}')">
                    Сохранить
                </button>
            </div>
        `;
    });
}
