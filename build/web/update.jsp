<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Update Customer</title>
    </head>
    <body>
        <h1>UPDATE</h1>

        <form method="POST" action="update">
            code:
            <input type="text"   value="${cus.code}" disabled />
            <br>
            <input type="hidden" name="code" value="${cus.code}"   />
            name:
            <input type="text" name="name" value="${cus.name}" /><br>

            address:
            <input type="text" name="address" value="${cus.address}" /><br>

            phone:
            <input type="text" name="phone" value="${cus.phone}" /><br>

            <input type="submit" value="UPDATE" />
        </form>
    </body>
</html>
