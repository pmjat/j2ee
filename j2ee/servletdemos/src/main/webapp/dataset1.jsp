<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="pmj.j2ee.dataset.model.DataSet" %>
<!-
    Request are made to this JSP as following
    http://localhost:8080/JSPDemos/dataset1.jsp?action=add&x=10
    http://localhost:8080/JSPDemos/dataset1.jsp?action=add&x=20
    http://localhost:8080/JSPDemos/dataset1.jsp?action=add&x=16
    http://localhost:8080/JSPDemos/dataset1.jsp?action=add&x=22

    Get Average: 
    http://localhost:8080/JSPDemos/dataset1.jsp?action=average

    Get Max: 
    http://localhost:8080/JSPDemos/dataset1.jsp?action=max

    Reset: 
    http://localhost:8080/JSPDemos/dataset1.jsp?action=reset
-->
<!DOCTYPE html>
<html>
    <head>
        <title>JSP based DataSet 1.0</title>
    </head>
    <body>
        <%!
            private DataSet data;
            public void jspInit() {
                data = new DataSet();
            }
        %>
        <%
        String theAction = request.getParameter("action");       
        if (theAction == null)
            theAction = "index";
        if (theAction.equalsIgnoreCase("index")) { %>
            <h1>JSP based Data Set</h1>
            <p>You can do following thing here</p>
            <p>Add data to DataSet: <a href="dataset1.jsp?action=add&x=10">http://localhost:8080/JSPDemos/dataset1.jsp?action=add&x=10</a></p>
            <p>Likewise can add more data</p>
            <p />
            <p>Get Average of the data with DataSet: <a href="dataset1.jsp?action=average">http://localhost:8080/JSPDemos/dataset1.jsp?action=average</a></p>
            <p>Get Max from the data with DataSet <a href="dataset1.jsp?action=max">http://localhost:8080/JSPDemos/dataset1.jsp?action=max</a></p>
            <p>Reset DataSet object: <a href="dataset1.jsp?action=reset">http://localhost:8080/JSPDemos/dataset1.jsp?action=reset</a></p>            
        <%
        }
        else if (theAction.equalsIgnoreCase("reset")) {
            this.data.reset();
        %>
            <h1>Reset Done!!</h1>
        <%
        }
        else if (theAction.equalsIgnoreCase("add")) {
            double x = Double.parseDouble(request.getParameter("x"));
            this.data.add(x);
        %>
            <h1>X: <% out.println(x); %> Added!</h1>
        <%
        }
        else if (theAction.equalsIgnoreCase("average")) {
            double avg = this.data.getAverage();
        %>
            <h1>Average: <%= avg %></h1>
        <%
        }
        else if (theAction.equalsIgnoreCase("max")) {
            double max = data.getMaximum();
        %>
            <h1>Maximum: <%= max %></h1>
        <%
        }
        %>
    </body>
</html>
