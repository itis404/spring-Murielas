<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>MusicForm</title>
    <link rel="stylesheet" href="<c:url value='/css/game.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
</head>
<body>
    <%@ include file="header.jsp"%>
<main>
    <div class="game-container">
        <div class="score-panel">
            <h2> Баллы </h2>

            <span id="score"> ${session.score} </span>
        </div>

        <div class="game-panel">
            <button id="playBtn" class="play-button">
                <img src="<c:url value='/images/note_icon.png'/>">
             </button>

            <c:if test="${mode.modeName == 'LEARN'}">
                <h2 id="noteName"> ${round.noteName} </h2>
            </c:if>
        </div>
    </div>

    <div class="notes-panel">
        <button onclick="answer('C')">C</button>

        <button onclick="answer('D')">D</button>

        <button onclick="answer('E')">E</button>

        <button onclick="answer('F')">F</button>

        <button onclick="answer('G')">G</button>

        <button onclick="answer('A')">A</button>

        <button onclick="answer('B')">B</button>
    </div>

    <div id="result"></div>

</main>

<script>
    let currentSoundId = ${round.id};
    const sessionId = ${session.id};
    const instrumentId = ${instrument.id};
    let currentAudioUrl = '${round.previewURL}';
    const modeName = '${mode.modeName}';
</script>

<script src="<c:url value='/js/game.js'/>"></script>
<%@ include file="footer.jsp"%>

</body>
</html>