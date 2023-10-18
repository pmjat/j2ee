<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration Success</title>
    </head>
    <body>
    <h2>Registration Successful!</h2>
    <table>
        <tr><td>User ID</td><td>${user.userId}</td></tr>
        <tr><td>Full Name</td><td width="300">${user.name}</td></tr>
        <tr><td>Email</td><td>${user.email}</td></tr>
        <tr><td>Phone No.</td><td>${user.phone}</td></tr>
    </table>
    </body>
</html>
