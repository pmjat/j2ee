<%@page contentType="text/html" pageEncoding="UTF-8" 
		import="pmj.mvcdemo.model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration Success!</title>
    </head>
    <body>
    <%
    	User user = (User) request.getAttribute("user");
    %>
    <h2>Registration Successful</h2>
    <table>
        <tr><td>User ID</td><td><%= user.getUserId() %></td></tr>
        <tr><td>Full Name</td><td width="300"><%= user.getName() %></td></tr>
        <tr><td>Email</td><td><%= user.getEmail() %></td></tr>
        <tr><td>Phone No.</td><td><%= user.getPhone() %></td></tr>
    </table>
    </body>
</html>
