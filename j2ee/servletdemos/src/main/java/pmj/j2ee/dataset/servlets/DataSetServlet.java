package pmj.j2ee.dataset.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pmj.j2ee.dataset.model.DataSet;

@WebServlet(name = "DataSetServlet", urlPatterns = {"/DataSetServlet1"})
public class DataSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void processRequest(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String theAction = request.getParameter("action");
        
        if (theAction == null)
            theAction = "index";
        
        String resp_body = "";
        
        if (theAction.equalsIgnoreCase("index")) {
            resp_body += "Welcome DataSet Servlet"; 
        }
        else if (theAction.equalsIgnoreCase("reset")) {
            this.data.reset();
            resp_body += "Reset Done!!"; 
        }
        else if (theAction.equalsIgnoreCase("add")) {
            double x = Double.parseDouble(request.getParameter("x"));
            this.data.add(x);
            resp_body += "X: " + x + " Added!"; 
        }
        else if (theAction.equalsIgnoreCase("average")) {
            double avg = data.getAverage();
            resp_body += "Average: " + avg; 
        }
        else if (theAction.equalsIgnoreCase("max")) {
            double max = data.getMaximum();
            resp_body += "Maximum: " + max; 
        }        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet based DataSet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + resp_body + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private final DataSet data = new DataSet();
}
