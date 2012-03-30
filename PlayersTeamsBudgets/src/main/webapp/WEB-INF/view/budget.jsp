
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Annual Budget!</title>
    </head>
    <body>
        <h1>Add a new budget!</h1>
        <form:form commandName="budget" action="${pageContext.request.contextPath}/budget" method="POST">
            Budgetyear:<form:input path="budgetYear" /><form:errors path="budgetYear" /><br/>
            Amount:<form:input path="amount" /><form:errors path="amount" /><br/>

            <select name="teamId">
                <c:forEach var="team" items="${teams}">
                    <option value="${team.id}">${team.name}</option>
                </c:forEach>
            </select>
            <input type="submit">
        </form:form>
    </body>
</html>
