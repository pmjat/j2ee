<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList,pmj.j2ee.bookstore.Book" %>
<%
	//This arraylist of books is place holder for data
	ArrayList<Book> stock = new ArrayList<>();
	stock.add( new Book("1001", "Database Systems", 450, 10 ));
	stock.add( new Book("1002", "Object Oriented Design and Patterns", 339,8));
	stock.add( new Book("1003", "Core J2EE™ Patterns", 2250,2));
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="main.css">
    <title>Books in Stock</title>
</head>
<body>
    <h2>Books in Stock</h2>
    <a href="#">Add New Book</a>
    <table class="gridtable">
        <tr><th>ISBN</th><th width="300">Title</th><th>Price</th><th>Stock</th><th></th><th></th></tr>
<%
   	for(Book b : stock) {
       	String isbn = b.getIsbn();
%>
		<tr>
		    <td><a href="#"><%= isbn %></a></td>
		    <td><%= b.getTitle() %></td>
		    <td><%= b.getPrice() %></td>
		    <td><%= b.getStock() %></td>
		    <td><a href="#">Edit</a></td>
		    <td><a href="#">Remove</a></td>
		</tr>                
	<%}%>
	</table>
</body>
</html>