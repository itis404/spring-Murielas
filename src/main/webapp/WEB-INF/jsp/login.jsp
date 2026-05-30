<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title> Login </title>

    <link rel="stylesheet" href="<c:url value='/css/auth.css'/>">
</head>
<body>

<main>

    <div class="auth-card">
        <h1> Вход в аккаунт </h1>

        <form action="<c:url value='/login'/>" method="post">
            <input type="text" name="username" placeholder="Username">
            <input type="password" name="password" placeholder="Password">

            <button type="submit"> Войти </button>
        </form>

        <p> Нет аккаунта?
                <a href="<c:url value='/registration'/>"> Зарегистрируйся </a>
        </p>

        <c:if test="${param.error != null}">
            <div class="error"> Неправильное имя или пароль </div>
        </c:if>
    </div>

</main>

</body>
</html>