package pmj.j2ee.pollsimulator.v20.model;

import java.util.HashMap;

public class Poll {

    public void vote(int sid, int candidate_id) throws VoteAlreadyCasted {
    	if (voted.get(sid) != null)
    		throw new VoteAlreadyCasted();
        Candidate c = candidates.get( candidate_id );
		if ( c == null ) //invalid candidate id
			invalid++;
		else {
			c.voteTo();
			candidates.put(candidate_id, c);
		}
        voted.put(sid, 0);
    }

    public void setCandidates( String [] names ) {

        Candidate c;
        for (String cname : names ) {
            c = new Candidate( cname );
            candidates.put(c.getID(), c);
        }
        
    }
    
    public int getNumberOfCandidates() {
        return candidates.size();
    }
    
    public String getWinner() {  //returns the candidate name
        
        String winner_candidate;

        Candidate[] cands = this.getCandidates();
        int wc = -1, max_vote = -1;
        for(Candidate c : cands ) {
            if ( c.getVoteCount() > max_vote ) {
                wc = c.getID();
                max_vote = c.getVoteCount();
            }
        }
        winner_candidate = candidates.get(wc).getName();           
        return winner_candidate;

    }        
    
    public Candidate[] getCandidates() {
        Candidate[] cands = new Candidate[candidates.size()];
        int i = 0;
        for (HashMap.Entry<Integer,Candidate> c : candidates.entrySet()) 
            cands[i++] = c.getValue();
        return cands;
    }   
	
    public int getInvalidVotes() {
        return invalid;
    }   
	
    private final HashMap<Integer, Candidate> candidates = new HashMap<>();
    private final HashMap<Integer, Integer> voted = new HashMap<>();
    private int invalid = 0;
	
}