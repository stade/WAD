<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asunnot</title>
    </head>
    <body>
        </form:form>
        <strong>Asunnot</strong></br>
        <c:forEach var="house" items="${houses}">
            ${house.id},${house.housesize},${house.address},${house.buildyear}</br>
        </c:forEach>
    </body>
</html>
