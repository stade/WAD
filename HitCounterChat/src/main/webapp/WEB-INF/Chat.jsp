<%-- 
    Document   : Chat
    Created on : 18.1.2012, 16:16:41
    Author     : stade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>
    <body>
        <strong>Chat</strong></br>
        <form method="POST">
            <input type="text" name="viesti" /><input type="submit" value="Lähetä" />
        </form>
        <strong>Viestit</strong></br>
        <c:forEach var="viesti" items="${viestit}">
            ${viesti}</br>
        </c:forEach>
        <a href="${osoite}">kirjaudu ulos</a>
    </body>
</html>
