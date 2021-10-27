package pmj.j2ee.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PollServlet
 */
@SuppressWarnings("serial")
@WebServlet("/PollServlet")
public class PollServlet extends HttpServlet {

	private int[] votes;
    public PollServlet() {
        votes = new int[6];
        for(int i = 0; i < 6; i++)
            votes[i]=0;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if ( action.equalsIgnoreCase("vote")) {
            int cid = Integer.parseInt(request.getParameter("id"));
            if (cid > 0 && cid <= 5)
                votes[cid]++;
            else
                votes[0]++;
            out.println("<h1>Vote Successfully recorded!</h1>");
        }
        else if ( action.equalsIgnoreCase("report")) {
            out.println("<h1>Poll Summary</h1>");
            for(int i = 1; i < 6; i++)
                out.println("<p>Candidate-" + i + ": " + votes[i] + "</p>");
            out.println("<p>Votes Rejected: " + votes[0] + "</p>");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
