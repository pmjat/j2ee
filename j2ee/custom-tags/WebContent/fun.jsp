
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Some Error Fun</title>
</head>
<body>
<%
	int x = 0;
	int y = 100/x;
%>
Fun Number: <%= y %>
</body>
</html>