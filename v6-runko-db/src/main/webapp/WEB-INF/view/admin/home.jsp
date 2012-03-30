<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add students</title>
    </head>
    <body>
        <h1>Add students</h1>
        <form action="<c:url value="/admin" />"  method="POST">
            Name of student: <input type="text" name="name" /><br>
            Username:<input type="text" name="username" /><br>
            Password:<input type="text" name="password" />
            <input type="submit" value="Send" />
         </form>
        
        <p><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></p>
    </body>
</html>
