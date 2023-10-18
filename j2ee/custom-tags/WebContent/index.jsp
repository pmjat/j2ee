<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controller Demo</title>
    </head>
    <c:redirect url="http://localhost:8080${pageContext.request.contextPath}/Controller?action=regform" />
</html>
