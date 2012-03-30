<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>henkilöt</title>
    </head>
    <body>
        <h1>henkilöt</h1>

        <h2>Lisää henkilö</h2>
        <form action="hlisaa" method="POST">
            Henkilön nimi: <input type="text" name="nimi"><br/>
            Henkilön osoite: <input type="text" name="osoite"><br/>
            Henkilön puhelinnumero: <input type="text" name="puhnro"><br/>
            <input type="submit" value="Lisää">            
        </form>

        <h2>Henkilöt</h2>
        <ul>
            <c:forEach var="henkilo" items="${henkilot}">
                <li>Nimi: ${henkilo.nimi}, Osoite: ${henkilo.osoite}, Puhnro: ${henkilo.puhnro} <a href="hpoista/${henkilo.id}">poista</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
