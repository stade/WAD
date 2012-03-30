<%-- 
    Document   : login
    Created on : 20.2.2012, 14:18:25
    Author     : tatutahv
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login!</h1>
        
        ${SPRING_SECURITY_LAST_EXCEPTION.message}
        ${SPRING_SECURITY_LAST_USERNAME}
        
        <form action=" <c:url value="/j_spring_security_check" />"  method="POST">
            Username:<input type="text" name="j_username" /><br>
            Password:<input type="text" name="j_password" />
            <input type="submit" value="Send" />
        </form>
    </body>
</html>



