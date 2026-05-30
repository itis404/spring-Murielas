<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>MusicForm</title>

    <link rel="stylesheet" href="<c:url value='/css/account.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
</head>
<body>
    <%@ include file="header.jsp"%>
<main>
    <div class="profile-container">
        <h1> Профиль </h1>

        <div class="user-info">
            <h2> ${user.username} </h2>

            <p> ${user.email} </p>
        </div>

        <div class="levels">
            <c:forEach items="${levels}" var="level">
                <div class="level-card">
                    <h3> ${level.instrument.name} </h3>

                    <p> Уровень: ${level.level} </p>

                    <p> Опыт: ${level.experience} / 100 </p>
                </div>
            </c:forEach>
         </div>

        <c:if test="${user.role == 'ADMIN'}">
            <div class="admin-panel">
                <a href="<c:url value='/admin'/>"> Панель админа </a>
            </div>
        </c:if>
    </div>

</main>

<%@ include file="footer.jsp"%>

</body>
</html>