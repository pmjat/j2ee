<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>JSP based table generator</title>
	<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
        <h1>JSP based Table Generation</h1>
        <%
            String num = request.getParameter("number");
            if ( num == null ) {
                //out.println("<h1>Number unspecified</h1>");
                %><h1>Number unspecified</h1><%
                return;
            }
            int n = Integer.parseInt(num);
        %>
        <h1>Table of : <%= n %> </h1>
        <table class="gridtable">
        <% 
	        int i;
        	for (i=1; i <= 10; i++) {
        %>
        	<tr>
        		<td width="150px" align="center"><%= n %> x <%= i %></td>
        		<td width="100px" align="center"><%= n*i %></td>
        	</tr>
		<%	} %>       
        </table>
</body>
</html>