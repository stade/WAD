<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Player list</title>
    </head>
    <body>
        <h1>PlayersTeamsBudgets</h1>

        <h2>Players</h2>
        <div>
            <c:forEach var="player" items="${players}">
                <p>Player: ${player.name}, Team: ${player.team.name}</p> 
            </c:forEach>
        </div>
         <h2>Budgets</h2>
        <div>
            <c:forEach var="budget" items="${budgets}">
                <p>Budget: ${budget.budgetYear}, ${budget.amount} Team: ${budget.team.name}</p> 
            </c:forEach>
        </div>

        <h2>Teams</h2>
        <div>
            <c:forEach var="team" items="${teams}">
                <p>Team: ${team.name}, <br/>Budgets:
                    
                    <c:forEach var="b" items="${team.budgets}">
                        <span>${b.budgetYear}: ${b.amount}, </span>
                    </c:forEach>
                    <br/>Players:
                        
                    <c:forEach var="p" items="${team.players}">
                        <span>${p.name},</span>
                    </c:forEach>
                </p>
            </c:forEach>
        </div>

        <p><a href="${pageContext.request.contextPath}/player">Add a new player!</a></p>
           <p><a href="${pageContext.request.contextPath}/budget">Add a new annual budget!</a></p>

        <h2>Add a new Team</h2>
        <div>
            <form method="POST" action="team">
                Name: <input name="name" type="text"/><input type="submit"/>
            </form>
        </div>

    </body>
</html>
