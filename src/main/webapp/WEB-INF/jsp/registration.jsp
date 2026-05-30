<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title> Регистрация </title>

    <link rel="stylesheet" href="<c:url value='/css/auth.css'/>">
</head>
<body>
<main>
    <div class="auth-card">
        <h1> Регистрация </h1>

        <form:form method="post" action="/registration" modelAttribute="registrationDto">
            <form:input path="username" placeholder="Username"/>
            <form:errors path="username" cssClass="error"/>

            <form:input path="email" placeholder="Email"/>
            <form:errors path="email" cssClass="error"/>

            <form:password path="password" placeholder="Password"/>
            <form:errors path="password" cssClass="error"/>

            <button type="submit"> Зарегистрироваться </button>
        </form:form>

        <p>
            Уже есть аккаунт?

            <a href="<c:url value='/login'/>"> Войди </a>
        </p>
    </div>

</main>

</body>
</html>