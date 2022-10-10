package pmj.j2ee.pollsimulator.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pmj.j2ee.pollsimulator.model.Poll;
import pmj.j2ee.pollsimulator.model.Candidate;

@WebServlet("/PollServle")
public class PollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Web based Poll Simulator</title>");  
        out.println("</head>");
        out.println("<body>");        
        if ( action.equalsIgnoreCase("report")) {
            Candidate[] candidates = (Candidate[]) poll.getCandidates();
            for(Candidate cand : candidates) {
                out.println("<p>" + cand.getName() + ": " + cand.getVoteCount() + "</p>");
            }
        }
        else if ( action.equalsIgnoreCase("vote")) {
            int cid = Integer.parseInt(request.getParameter("candidate"));
            poll.vote(cid);
            out.println("<p>Vote Successfully Recorded</p>");
        }
        else { /* Show Voting UI */ }
        out.println("</body>");
        out.println("</html>");     
    }
    private Poll poll = new Poll();
}