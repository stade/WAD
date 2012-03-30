<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>huoneet</title>
    </head>
    <body>
        <h1>huoneet</h1>

        <h2>Lisää henkilöitä huoneisiin</h2>

        <c:forEach var="huone" items="${huoneet}">
        <li>Tunnus: ${huone.tunnus}, Kerros: ${huone.kerros}, Kapasiteetti: ${huone.kapasiteetti},  <a href="/henkilotHuoneessa${huone.id}">Näytä henkilöt tässä huoneessa</a></li>
            <c:forEach var="henkilo" items="${henkilot}">
                <li>Nimi: ${henkilo.nimi}, Osoite: ${henkilo.osoite}, Puhnro: ${henkilo.puhnro}, <a href="lisaaHenkilo/huone/${huone.id}/henkilo/${henkilo.id}">Lisää henkilö: ${henkilo.nimi} huoneeseen ${huone.tunnus}</a></li>
             </c:forEach>    
    </c:forEach>
</body>
</html>
