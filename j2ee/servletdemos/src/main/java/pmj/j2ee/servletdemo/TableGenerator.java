package pmj.j2ee.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TableGenerator
 */
@WebServlet("/TableGenerator")
public class TableGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Table</title>");            
        out.println("</head>");
        out.println("<body>");
        String sn = request.getParameter("number");
        if ( sn == null ) {
            out.println("<h1>Number unspecified</h1>");
            return;
        }
        int n = Integer.parseInt(sn);
        out.println("<h1>Table of - " + n + "</h1>");
        int i;
        for (i=1; i <= 10; i++) {
            out.println( "" + n + " x " + i + " = " + n*i + "<br/>");
        }
        
        out.println("</body>");
        out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
