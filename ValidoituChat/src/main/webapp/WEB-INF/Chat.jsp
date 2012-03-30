<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>
    <body>
        <strong>Chat</strong></br>
        <form:form commandName="ChatMessage" action="${pageContext.request.contextPath}/ChatMessage" method="POST">
            <form:input path="content"/><form:errors path="content"/><br>
            <input type="submit" value="Lähetä" />
        </form:form>
        <strong>Viestit</strong></br>
        <c:forEach var="msg" items="${messages}">
            ${msg.content}</br>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/handleLogout">kirjaudu ulos</a>
    </body>
</html>
