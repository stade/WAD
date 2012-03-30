<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSON_OlutVarasto - listaus</title>
    </head>
    <body>


        
        <h1>Olutlistaus</h1>    
        <ul>
            <c:forEach var="oluet" items="${oluet}">
                <li>${oluet.name}, id: ${oluet.id}
            </c:forEach>
        </ul>
    </body>
</html>