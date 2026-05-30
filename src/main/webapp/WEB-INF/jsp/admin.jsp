<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title> Админка </title>

    <link rel="stylesheet" href="<c:url value='/css/admin.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
</head>
<body>

    <%@ include file="header.jsp"%>

<main>
    <h1> Панель админа </h1>

    <section class="block">
        <h2> Добавить инструмент </h2>

        <form id="instrumentForm">
            <input type="text" id="instrumentName" placeholder="Name">
            <input type="text" id="instrumentDescription" placeholder="Description">

            <button type="submit"> Добавить </button>
        </form>
    </section>

    <section class="block">
        <h2> Freesound поиск </h2>

        <input type="text" id="searchQuery" placeholder="piano C">

        <button id="searchBtn"> Поиск </button>

        <div style="margin-top:10px;">
                    <label>Инструмент:</label>
                    <select id="instrumentSelect"></select>

                    <label>Нота:</label>
                    <select id="noteSelect">
                        <option value="C">C</option>
                        <option value="D">D</option>
                        <option value="E">E</option>
                        <option value="F">F</option>
                        <option value="G">G</option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                    </select>
                </div>

        <div id="searchResults"></div>

    </section>

    <section class="block">
        <h2> Звуки в базе данных </h2>

        <table id="soundTable">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Note</th>
                <th>Instrument</th>
                <th>Actions</th>
            </tr>

            <c:forEach items="${sounds}" var="sound">
                <tr>
                    <td> ${sound.id} </td>
                    <td> ${sound.soundName} </td>
                    <td> ${sound.noteName} </td>
                    <td> ${sound.instrument.name}</td>
                    <td>
                        <button onclick="deleteSound(${sound.id})"> Удалить </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </section>
</main>

<script src="<c:url value='/js/admin.js'/>"></script>

<%@ include file="footer.jsp"%>

</body>
</html>