<%-- 
    Document   : create
    Created on : Jan 6, 2026, 5:44:05 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CREATE NEW CUSTOMER</h1>
        <form method="POST" action="CustomerController">
            code: <input type="text" name="code" value="" /><br>
            name: <input type="text" name="name" value="" /><br>
            address: <input type="text" name="address" value="" /><br>
            phone: <input type="number" name="phone" value="" /><br>
            <input type="submit" value="CREATE" />
        </form>
    </body>
</html>
