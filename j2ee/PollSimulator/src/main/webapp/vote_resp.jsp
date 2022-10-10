<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Vote Cast Response</title>
    </head>
    <body>
        <h1>Vote Cast Response</h1>
        <c:choose>
            <c:when test="${requestScope.vote_resp eq 'true'}">
                <p>Vote Cast Successfully Recorded</p>
            </c:when>
            <c:otherwise>
                <p>Vote Cast Failed</p>
            </c:otherwise>
        </c:choose>        
    </body>
</html>
