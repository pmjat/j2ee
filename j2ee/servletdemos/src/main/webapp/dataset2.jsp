<%@page contentType="text/html" pageEncoding="UTF-8" import="pmj.j2ee.dataset.model.DataSet" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP based DataSet</title>
    </head>
    <body>
        <%
	        //code below reads saved dataset object from session object
	        DataSet data = (DataSet) session.getAttribute("data");
	        if (data == null) {
	            data = new DataSet();
	            session.setAttribute("data", data);
	        }
	        
	        //actions are code below
	        String theAction = request.getParameter("action");
	        
	        if (theAction == null)
	            theAction = "index";
	        if (theAction.equalsIgnoreCase("index")) { 
        %>
        <h1>JSP based Data Set</h1>
        <p>You can do following thing here</p>
        <p>Add data to Data Set: 
        	<a href="dataset2.jsp?action=add&x=10">http://localhost:8080/JSPDemos/dataset2.jsp?action=add&x=10</a></p>
        <p>Likewise can add more data</p>
        <p />            
        <p>Get Average of the data with Data Set: 
        	<a href="dataset2.jsp?action=average">http://localhost:8080/JSPDemos/dataset2.jsp?action=average</a></p>
        <p>Get Max from the data with Data Set 
        	<a href="dataset2.jsp?action=max">http://localhost:8080/JSPDemos/dataset2.jsp?action=max</a></p>
        <p>Reset Data Set (Clear all data): 
        	<a href="dataset2.jsp?action=reset">http://localhost:8080/JSPDemos/dataset2.jsp?action=reset</a></p>            
        <%
        	}
	        else if (theAction.equalsIgnoreCase("reset")) {
    	        data.reset();
        %>
        <h1>Reset Done!!</h1>
        <%
        	}
        	else if (theAction.equalsIgnoreCase("add")) {
            	double x = Double.parseDouble(request.getParameter("x"));
            	data.add(x);
        %>
        <h1>X: <%= x %> Added!</h1>
        <%
        	}
        	else if (theAction.equalsIgnoreCase("average")) {
            double avg = data.getAverage();
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
