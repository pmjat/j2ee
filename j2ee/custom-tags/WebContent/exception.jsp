
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
	isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Errors!</title>
</head>
<body>
	<h2 style="color:red">Errors!</h2>
	<p style="color:red"><%= exception.getMessage() %></p>	    			
</body>
</html>