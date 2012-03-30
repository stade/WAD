<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Henkilöitä huoneessa</title>
    </head>
    <body>
        <h1>Henkilöitä huoneessa</h1>

        <ul>
            <c:forEach var="henkilo" items="${henkilotHuoneessa}">
                 <li>Nimi: ${henkilo.nimi}, Osoite: ${henkilo.osoite}, Puhnro: ${henkilo.puhnro}></li>
            </c:forEach>
        </ul>
    </body>
</html>