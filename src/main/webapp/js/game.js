let audio = new Audio(currentAudioUrl);
document.getElementById("playBtn").addEventListener("click", playSound);

function playSound() {
    audio.pause();
    audio.currentTime = 0;
    audio.play();
}

function answer(selectedNote) {
    fetch("/game/check", {method: "POST", headers: {"Content-Type":"application/json"},
            body: JSON.stringify({soundId:currentSoundId, sessionId:sessionId, selectedNote:selectedNote})
    })
    .then(response => response.json())
    .then(data => {
        showResult(data);
        loadNextRound();
    })
    .catch(error => {
        console.error(error);
    });
}

function showResult(data) {
    const result = document.getElementById("result");
    const score = document.getElementById("score");

    if(data.correct) {
        result.innerText = "Правильно!";
    } else {
        result.innerText = "Неправильно";
    }

    score.innerText = data.score;
}

function loadNextRound() {
    fetch("/game/next-round?instrumentId=" + instrumentId)
    .then(response => response.json())
    .then(data => {
        currentSoundId = data.soundId;
        currentAudioUrl = data.previewURL;
        audio = new Audio(currentAudioUrl);
        updateNoteName(data);
    })
    .catch(error => {
        console.error(error);
    });
}

function updateNoteName(data) {
    if(modeName !== "LEARN") {
        return;
    }

    const noteElement = document.getElementById("noteName");

    if(noteElement) {
        noteElement.innerText = data.noteName;
    }
}