<%-- 
    Document   : index
    Created on : Jan 3, 2026, 2:31:12 PM
    Author     : ASUS
--%>

<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="create.jsp"">Create new customer</a>
        <table  border="1">
            <thead>
                <tr>
                    <th>CODE</th>
                    <th>NAME</th>
                    <th>ADDRESS</th>
                    <th>PHONE</th>
                    <th>ACTION</th>
                </tr>
            </thead>
            <tbody>
                <h:forEach var="i" items="${requestScope.list}">
                    <tr>
                        <td>${i.code}</td>
                        <td>${i.name}</td>
                        <td>${i.address}</td>
                        <td>${i.phone}</td>
                        <td><a  href="remove?code=${i.code}">remove</a> <a href="update?code=${i.code}">update</a></td>
                    </tr>
                </h:forEach>
            </tbody>
        </table>






    </body>
</html>
