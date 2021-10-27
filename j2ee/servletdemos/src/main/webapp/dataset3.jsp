<%@page contentType="text/html" pageEncoding="UTF-8" import="pmj.j2ee.dataset.model.DataSet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP-EL/JSTL based DataSet</title>
    </head>
    <body>
        
        <jsp:useBean id="data" class="pmj.j2ee.dataset.model.DataBean" scope="session" />
        
        <c:if test="${empty param.action}" var="noaction">
            <c:set var="action" value="index" scope="request" />
        </c:if>
        <c:if test="${not noaction }">
            <c:set var="action" value="${fn:toLowerCase(param.action)}" scope="request" />
        </c:if>

        <c:choose>
            <c:when test="${action == 'index'}">
                <h1>JSP-EL/JSTL based Data Set</h1>
                <p>You can do following thing here</p>
                <p>Add Data: <a href="index_el_jstl.jsp?action=add&x=10">http://localhost:8080/DataSet/index_el_jstl.jsp?action=add&x=10</a></p>
                <p>Likewise can add more data</p>
                <p>Get Average: <a href="index_el_jstl.jsp?action=average">http://localhost:8080/DataSet/index_el_jstl.jsp?action=average</a></p>
                <p>Get Max: <a href="index_el_jstl.jsp?action=max">http://localhost:8080/DataSet/index_el_jstl.jsp?action=max</a></p>                
            </c:when>
            <c:when test="${action == 'average'}">
                <h1>Average: <c:out value="${sessionScope.data.average}" /></h1>
            </c:when>
            <c:when test="${action == 'max'}">
                <h1>Maximum: <c:out value="${sessionScope.data.maximum}" /></h1>
            </c:when>
            <c:when test="${action == 'reset'}">
                <jsp:setProperty name="data" property="reset" value="true" />
                <h1>Reset Done!!</h1>
            </c:when>
            <c:when test="${action == 'add'}">
                <jsp:setProperty name="data" property="add" value="${param.x}" />
                <h1>X: <c:out value="${param.x}" /> Added!</h1>
            </c:when>
            <c:otherwise>
                <p>Invalid action!!! <a href="index_el_jstl.jsp">http://localhost:8080/DataSet/index_el_jstl.jsp</a></p>
            </c:otherwise>
        </c:choose>
        
    </body>

</html>
