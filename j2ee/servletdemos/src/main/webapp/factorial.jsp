
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP based Factorial Computation</title>
    </head>
    <body>
        <h1>JSP based Factorial Computation</h1>
        <%
            String num = request.getParameter("number");
            int n = Integer.parseInt(num);
            double fact = 1;
            for(int i = 2; i <= n; i++)
                fact *= i;
        %>
        <h2>Your Input: <%= n %> </h2>
        <h2>Factorial:  <%= fact %> </h2>               
    </body>
</html>
