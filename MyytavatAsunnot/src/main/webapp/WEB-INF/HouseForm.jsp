<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Myytävät asunnot</title>
    </head>
    <body>
        <strong>Myytävät Asunnot</strong></br>
        <form:form commandName="HouseForm" action="${pageContext.request.contextPath}/HouseForm" method="POST">
            Myyjän nimi:<form:input path="sellerName"/><form:errors path="sellerName"/><br>
            Myyjän puhnum:<form:input path="sellerPhoneNum"/><form:errors path="sellerPhoneNum"/><br>
            Myyjän sähköposti:<form:input path="sellerEmail"/><form:errors path="sellerEmail"/><br>
            Asunnon koko (m^2):<form:input path="houseSize"/><form:errors path="houseSize"/><br>
            Asunnon osoite:<form:input path="houseAddress"/><form:errors path="houseAddress"/><br>
            Asunnon rakennusvuosi:<form:input path="buildyear"/><form:errors path="buildyear"/><br>
            Asunnon kunto:<form:input path="houseCondition"/><form:errors path="houseCondition"/><br>
            <input type="submit" value="Lähetä"/>
        </form:form>
    </body>
</html>