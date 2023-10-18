package pmj.j2ee.pollsimulator.v20.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pmj.j2ee.pollsimulator.v20.model.Poll;

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
        if ( action == null) {
            view = "index.html";
        }
        else if ( action.equalsIgnoreCase("votecast"))
            view = "votecast.html";
        else if ( action.equalsIgnoreCase("vote")) {
            view = "vote_resp.jsp";
            String message;
            int cid = Integer.parseInt(request.getParameter("cand"));
            int sid = Integer.parseInt(request.getParameter("sid"));
            try {
            	poll.vote( sid, cid );
            	message = "Vote Casted Succeffuly: " + sid;
            }
            catch(Exception e) {
            	message = "Voted already casted: " + sid;
            }
            request.setAttribute("message", message);
        }
        else if ( action.equalsIgnoreCase("report")) {
            view = "report.jsp";
            request.setAttribute("poll", poll);
        }
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);    
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request, response);
    }
    private Poll poll;
}