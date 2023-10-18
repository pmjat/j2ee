<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  %@page contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voting Report</title>
       	<Style>
		body {
			font-family: verdana,arial,sans-serif;
			font-size:18px;
		}
       	</Style>        
    </head>
    <body>
        <h1>Voting Report</h1>
        <c:forEach var="cand" items="${requestScope.poll.candidates}" >
            <p><c:out value="${cand.name}" />: 
                <c:out value="${cand.voteCount}" /></p>
        </c:forEach>
        <p>Winner: <c:out value="${requestScope.poll.winner}" /></p>
        
    </body>
</html>

