<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title> MusicForm </title>

    <link rel="stylesheet" href="<c:url value='/css/leaderboard.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
</head>
<body>
    <%@ include file="header.jsp"%>
<main>
    <h1> Таблица лидеров </h1>

    <div class="my-score">
        <h2> Твои баллы за неделю </h2>
        <span> ${myScore} </span>
    </div>

    <div class="leaderboard-container">
        <div class="leaderboard-block">
            <h2> Топ игроков </h2>

            <table>
                <tr>
                    <th> Место </th>
                    <th> Имя </th>
                    <th> Баллы </th>
                </tr>

                <c:forEach items="${topPlayers}" var="player" varStatus="status">
                    <tr>
                        <td> ${status.index + 1} </td>
                        <td> ${player.username} </td>
                        <td> ${player.totalScore} </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="leaderboard-block">
            <h2> Топ команд </h2>

            <table>
                <tr>
                    <th> Место </th>
                    <th> Команда </th>
                    <th> Баллы </th>
                </tr>

                <c:forEach items="${topTeams}" var="team" varStatus="status">
                    <tr>
                        <td> ${status.index + 1} </td>
                        <td> ${team.teamName} </td>
                        <td> ${team.totalScore} </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</main>

<%@ include file="footer.jsp"%>

</body>
</html>