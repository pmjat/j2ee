<%@page contentType="text/html" pageEncoding="UTF-8" 
		import="pmj.mvcdemo.model.User,pmj.mvcdemo.controller.ActionError"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
    </head>
    <body>
    <h2>User Registration</h2>

	<!-- Error Reporting -->    
    <%
		ActionError errors = (ActionError) request.getAttribute("aerror");
    	if ( errors != null ) {%>
    		<h2 style="color:red">Errors!</h2>
    		<p style="color:red">
    		<%
    		for (Exception err : errors.getErrors()) { %>
    			<%= err.getMessage() %> <br /> <%	    			
    		}
    		%></p><%
    	}
    %>
    <%
    	User user = (User) request.getAttribute("user");
    %>
    <form method = "post" action="Controller">
    <input type="hidden" name="action" value="register" />
    <table>
        <tr>
        	<td>User ID</td>
        	<td><input type="text" name="user_id" value="<%= user.getUserId() %>" /></td>
        </tr>
        <tr>
        	<td>Full Name</td>
        	<td><input type="text" name="name" value="<%= user.getName() %>" size="50"/></td>
        </tr>
        <tr>
        	<td>Email</td>
        	<td><input type="text" name="email" value="<%= user.getEmail() %>" size="30" /></td>
        </tr>
        <tr>
        	<td>Phone No.</td>
        	<td><input type="text" name="phone" value="<%= user.getPhone() %>" /></td>
        </tr>
        <tr>
        	<td></td><td><input type="submit" value="Register" /></td>
        </tr>
    </table>
    </form>
    </body>
    <%! int x=10; %>
</html>
