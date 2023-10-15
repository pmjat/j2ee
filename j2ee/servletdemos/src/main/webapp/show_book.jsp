<%@page contentType="text/html" pageEncoding="UTF-8" import="pmj.j2ee.bookstore.Book" %>
<%
	//This book object is place holder for data
	Book book = new Book("1003", "Core J2EE™ Patterns", 2250, 2);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Book-Show</title>
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>
    <h2>Book-Details</h2>
    <table class="gridtable">
        <tr><td>ISBN</td><td><%= book.getIsbn() %></td></tr>
        <tr><td>Title</td><td width="300"><%= book.getTitle() %></td></tr>
        <tr><td>Price</td><td><%= book.getPrice() %></td></tr>
        <tr><td>Stock</td><td><%= book.getStock()%></td></tr>
    </table>
    </body>
</html>
