<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Olutvarasto!</title>
    </head>
    <body>
        <h1>Hello Olutvarasto!</h1>
        <h2>Lisää olut</h2>
        <form action="olut" method="POST">
            Oluen name: <input type="text" name="name"><br/>
            Oluen id: <input type="text" name="id"><br/>
            <input type="submit" value="Lisää">            
        </form>
        <h2>Hae oluet</h2>
        <form action="olut" method="GET"> 
            <input type="submit" value="Hae">            
        </form>
        <h2>Hae olut idllä</h2>
        <form action="olut" method="GET">
            Oluen id: <input type="text" name="id"><br/>
            <input type="submit" value="Hae">            
        </form>
</html>