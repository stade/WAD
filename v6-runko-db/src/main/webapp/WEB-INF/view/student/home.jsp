<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change your account credentials</title>
    </head>
    <body>
        <h1>Change your account credentials</h1>
         <form action="<c:url value="/student" />"  method="POST">
            Your name: <input type="text" value="${name}" name="name" /><br>
                       <input type="hidden" value="${username}" name="username" /><br>
            Password:<input type="text" value="vaihda" name="password" />
            <input type="submit" value="Send" />
         </form>
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
    </body>
</html>
