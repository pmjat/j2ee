<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP based table generator</title>
</head>
<body>
        <h1>JSP based Table Generation</h1>
        <%
            String num = request.getParameter("number");
            if ( num == null ) {
                out.println("<h1>Number unspecified</h1>");
                return;
            }
            int n = Integer.parseInt(num);
            out.println("<h1>Table of - " + n + "</h1>");
            int i;
            for (i=1; i <= 10; i++) {
                out.println( "" + n + " x " + i + " = " + n*i + "<br/>");
            }
        %>
</body>
</html>