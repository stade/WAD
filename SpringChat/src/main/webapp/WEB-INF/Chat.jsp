<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>
    <body>
        <strong>Chat</strong></br>
        <form action="addMessage" method="POST">
            <input type="text" name="content" />
            <input type="submit" value="Lähetä" />
        </form>
        <strong>Viestit</strong></br>
        <c:forEach var="msg" items="${messages}">
            ${msg.content}</br>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/handleLogout">kirjaudu ulos</a>
    </body>
</html>
