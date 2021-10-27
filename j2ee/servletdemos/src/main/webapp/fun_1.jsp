<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% this.doFun(); %>
        <h1>Some Fun! X: <%= x %></h1>
        <h2>Factorial:  <%= application.getRealPath("fun_1.jsp") %> </h2>               
    </body>
    <%!
        private int x=10;
        public void doFun() {
            this.x++;
        }
    %>
</html>
