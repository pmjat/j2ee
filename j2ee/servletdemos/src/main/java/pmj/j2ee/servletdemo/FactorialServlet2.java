package pmj.j2ee.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FactorialServlet
 */
@WebServlet("/FactorialServlet2")
public class FactorialServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String val = request.getParameter("num");
        double n = Double.parseDouble(val);  
        double fact = 1;
        
        for(int i = 2; i < n; i++)
            fact *= i;
    
        PrintWriter out = response.getWriter();
        out.println("Factorial for " + n + " =  " + fact);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
