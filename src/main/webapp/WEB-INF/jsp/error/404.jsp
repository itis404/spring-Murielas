<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title> Error 404 </title>

    <link rel="stylesheet" href="<c:url value='/css/error.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
</head>
<body>

    <%@ include file="../header.jsp"%>

<main>

    <div class="error-container">
        <h1> 404 </h1>

        <h2> Страница не найдена </h2>

        <p> ${message} </p>

        <a href="<c:url value='/index'/>"> Вернуться на главную </a>
    </div>

</main>

<%@ include file="../footer.jsp"%>

</body>
</html>