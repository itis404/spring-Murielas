<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>MusicForm</title>
    <link rel="stylesheet" href="<c:url value='/css/index.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
</head>
<body>
<main>
    <%@ include file="header.jsp"%>

    <div class="instrument-block">
        <div class="instrument-image">
            <img src="<c:url value='/images/piano.jpg'/>">
        </div>

        <div class="instrument-info">
            <h2> ${piano.name} </h2>

            <p> ${piano.description} </p>

            <div class="modes">
                <div class="mode-card">
                    <p> ${mode1.description} </p>
                    <a class="play-button" href="<c:url value='/game?instrumentId=${piano.id}&modeId=${mode1.id}'/>">  ${mode1.modeName} </a>
                </div>

                <div class="mode-card">
                    <p> ${mode2.description} </p>
                    <a class="play-button" href="<c:url value='/game?instrumentId=${piano.id}&modeId=${mode2.id}'/>">  ${mode2.modeName} </a>
                </div>
            </div>
        </div>
    </div>

    <div class="instrument-block">
        <div class="instrument-image">
            <img src="<c:url value='/images/guitar.jpg'/>">
        </div>

        <div class="instrument-info">
            <h2> ${guitar.name} </h2>

            <p> ${guitar.description} </p>

            <div class="modes">
                <div class="mode-card">
                    <p> ${mode1.description} </p>
                    <a class="play-button" href="<c:url value='/game?instrumentId=${guitar.id}&modeId=${mode1.id}'/>">  ${mode1.modeName} </a>
                </div>

                <div class="mode-card">
                    <p> ${mode2.description} </p>
                    <a class="play-button" href="<c:url value='/game?instrumentId=${guitar.id}&modeId=${mode2.id}'/>">  ${mode2.modeName} </a>
                </div>
            </div>
        </div>
    </div>
</main>
    <%@ include file="footer.jsp"%>
</body>
</html>