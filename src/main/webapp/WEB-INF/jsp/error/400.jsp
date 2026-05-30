<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title> Error 400 </title>

    <link rel="stylesheet" href="/css/error.css">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
</head>
<body>
    <%@ include file="../header.jsp"%>
<main>
    <div class="error-container">
        <h1> 400 </h1>

        <h2> Неправильный запрос </h2>

        <p> ${message} </p>

        <a href="/index"> Вернуться на главную </a>
    </div>
</main>

<%@ include file="../footer.jsp"%>

</body>
</html>