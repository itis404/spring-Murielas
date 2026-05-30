<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
    <nav class="nav">
        <ul class="menu">
            <li> <a href="<c:url value='/index'/>"> <img id="nav_icon" src="<c:url value='/images/icon-musicform.png'/>"/> </a> </li>
            <li> <a href="<c:url value='/index'/>"> Главная </a> </li>
            <li> <a href="<c:url value='/leaderboard'/>"> Лидеры </a> </li>
            <li> <a href="<c:url value='/teams'/>"> Команда </a> </li>
            <li> <a href="<c:url value='/account'/>"> Профиль </a> </li>
        </ul>
    </nav>
</header>