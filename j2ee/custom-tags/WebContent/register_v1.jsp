<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ae" uri="/WEB-INF/AEPrinter.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
    </head>
    <body>
    <h2>User Registration (EL-JSTL)</h2>

	<!-- Error Reporting -->    
	<c:if test="${not empty requestScope.aerror}">
		<c:set var="error" value="${requestScope.aerror}" />
		<h2 style="color:red">Errors!</h2>
		<p style="color:red">
	    <c:forEach var="err" items="${error.errors}" >
			<c:out value="${err.message}"></c:out> <br />
		</c:forEach>		
   		</p>
	</c:if>   

    <form method = "post" action="Controller">
    <input type="hidden" name="action" value="register" />
    <table>
        <tr>
        	<td>User ID</td>
        	<td><input type="text" name="user_id" value="${requestScope.user.userId}" /></td>
        </tr>
        <tr>
        	<td>Full Name</td>
        	<td><input type="text" name="name" value="${requestScope.user.name}" size="50"/></td>
        </tr>
        <tr>
        	<td>Email</td>
        	<td><input type="text" name="email" value="${requestScope.user.email}" size="30" /></td>
        </tr>
        <tr>
        	<td>Phone No.</td>
        	<td><input type="text" name="phone" value="${requestScope.user.phone}" /></td>
        </tr>
        <tr>
        	<td></td><td><input type="submit" value="Register" /></td>
        </tr>
    </table>
    </form>
    </body>
</html>
