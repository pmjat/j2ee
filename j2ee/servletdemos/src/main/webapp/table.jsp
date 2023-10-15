<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, td{
  border: 1px solid black;
}
table {
  border-collapse: collapse;
  width: 250px;
}
td {
  width: 100px;
  text-align: center;
}
</style>
<title>JSP based table generator</title>
</head>
<body>
	<h1>JSP based Table Generation</h1>
	<c:if test="${empty param.number}">
		<h1>Number unspecified</h1>
	</c:if>
	<c:if test="${not empty param.number}">
		<h1>Table of : ${param.number}</h1>
		<table>
		<c:forEach var="i" begin="1" end="10">
	  		<tr>
	  		<td>${param.number} x ${i}</td>
	    	<td>${param.number * i}</td>
	  		</tr>
		</c:forEach>        
	 </table>
	</c:if>
</body>
</html>