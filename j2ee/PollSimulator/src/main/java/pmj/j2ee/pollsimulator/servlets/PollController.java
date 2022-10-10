package pmj.j2ee.pollsimulator.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pmj.j2ee.pollsimulator.model.Poll;

@WebServlet("/Controller")
public class PollController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public PollController() {
        String[] candNames = new String[5];
        candNames[0] = "Deep Goyal";
        candNames[1] = "Sneha Mohan";
        candNames[2] = "Praveen Shah";
        candNames[3] = "Akshay Singh";
        candNames[4] = "Somin Majumdar";        
        poll = new Poll();        
        poll.setCandidates( candNames );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        
        String view = "";
        if ( action.equalsIgnoreCase("report")) {
            view = "report.jsp";
            request.setAttribute("candidates", poll.getCandidates());
        }
        else if ( action.equalsIgnoreCase("vote")) {
            view = "vote_resp.jsp";
            int cid = Integer.parseInt(request.getParameter("candidate"));
            poll.vote(cid);
            request.setAttribute("vote_resp", true);
        }
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);    
    }
    private Poll poll;
}