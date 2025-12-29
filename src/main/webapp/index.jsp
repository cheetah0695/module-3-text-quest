<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Text Quest</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Do you want to play a game?</h1>
        <form action="start" method="post">
            <label for="playerName">What is your name?</label><br>
            <div class="input-submit">
                <input type="text" id="playerName" name="playerName"
                       placeholder="Enter your name" required
                       value="${sessionScope.playerName != null ? sessionScope.playerName : ''}"
                       autocomplete="off">
                <button type="submit">Start</button>
            </div>
        </form>
    </div>
</body>
</html>
