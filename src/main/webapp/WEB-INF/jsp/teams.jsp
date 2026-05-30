<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>MusicForm</title>

    <link rel="stylesheet" href="<c:url value='/css/teams.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
</head>
<body>

    <%@ include file="header.jsp"%>

<main>

    <h1> Команды </h1>

    <div class="create-team">
        <form action="<c:url value='/teams/create'/>" method="post">
            <input type="text" name="teamName" placeholder="Team name">

            <button type="submit">
                Создать команду
            </button>
        </form>
    </div>

    <c:if test="${userTeam == null}">
        <p> У тебя нет команды </p>
    </c:if>

    <c:if test="${userTeam != null}">
        <div class="my-team">
            <h2> Моя команда </h2>

            <p> ${userTeam.team.teamName} </p>

            <form action="<c:url value='/teams/leave'/>" method="post">
                <button type="submit"> Уйти из команды </button>
            </form>
        </div>
    </c:if>

    <hr>

    <div class="teams-list">
        <c:forEach items="${teams}" var="team">
            <div class="team-card">
                <h2> ${team.teamName} </h2>

                <h4> Участники: </h4>
                <ul>
                    <c:forEach items="${team.members}" var="member">
                        <li> ${member.user.username} (${member.role}) </li>
                    </c:forEach>
                </ul>

                <form action="<c:url value='/teams/join'/>" method="post">
                    <input type="hidden" name="teamId" value="${team.id}">

                    <button type="submit"> Присоединиться </button>
                </form>
            </div>
        </c:forEach>
    </div>
</main>

<%@ include file="footer.jsp"%>

</body>
</html>