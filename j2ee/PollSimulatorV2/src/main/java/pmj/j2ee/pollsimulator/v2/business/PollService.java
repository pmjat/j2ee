package pmj.j2ee.pollsimulator.v2.business;

import java.util.HashMap;

public class PollService {
	
	private PollBO poll = new PollBO();
    private HashMap<Integer, Integer> voted = new HashMap<>();

	public void setCandidates(String[] candNames ) {
		poll.setCandidates( candNames );
	}
    
    public void vote(int sid, int candidate_id) throws VoteAlreadyCasted {
    	if (voted.get(sid) != null)
    		throw new VoteAlreadyCasted();
    	poll.vote(candidate_id);
        voted.put(sid, 0);
    }
    
    public CandidateTO[] getCandidates() {
    	Candidate[] cands = poll.getCandidates();
        CandidateTO[] cto = new CandidateTO[cands.length];
        int i = 0;
        for (Candidate c : cands) 
            cto[i++] = new CandidateTO(c);
        return cto;
    }   

    public String getWinner() {  //returns the candidate name
        
        Candidate[] cands = poll.getCandidates();
        String winner = null;
        int max_vote = -1;
        for(Candidate c : cands ) {
            if ( c.getVoteCount() > max_vote )
                winner = c.getName();
        }
        return winner;
    }        

    public int invalidVotes() {
        return poll.invalidVotes();
    }   
    
}