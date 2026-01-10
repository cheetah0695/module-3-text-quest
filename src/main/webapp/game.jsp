<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Saw quest</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <div class="quest-main">
            <h1>Saw quest</h1>
            <img src="./images/${step.image}">

            <c:choose>
                <c:when test="${not empty step.option1}">
                    <h2 class="question">${step.text}</h2>

                    <form action="game" method="post">
                        <input type="hidden" name="currentStep" value="${step.id}">

                        <p>
                            <input type="radio" name="answer" value="${step.option1}" required>
                                ${step.option1}
                        </p>

                        <p>
                            <input type="radio" name="answer" value="${step.option2}" required>
                                ${step.option2}
                        </p>

                        <button type="submit" class="answer-button">Answer</button>
                    </form>
                </c:when>

                <c:otherwise>
                    <h3>${step.text}</h3>
                    <button class="play-again-button">
                        <a href="game?step=start">Play again</a>
                    </button>
                    <button class="restart-button">
                        <a href="start">Restart the game</a>
                    </button>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="stats-container">
            <br>
            <p>Player: ${sessionScope.playerName}</p>
            <p>Games played: ${sessionScope.gamesPlayed != null ? sessionScope.gamesPlayed : 0}</p>
            <p>Session id: ${pageContext.session.id}</p>
            <p>Current step: ${step.id}</p>
        </div>
    </div>
</body>
</html>