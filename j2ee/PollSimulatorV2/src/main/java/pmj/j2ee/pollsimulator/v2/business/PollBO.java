package pmj.j2ee.pollsimulator.v2.business;

import java.util.HashMap;

public class PollBO {

    public void vote(int candidate_id) {
        Candidate c = candidates.get( candidate_id );
		if ( c == null ) //invalid candidate id
			invalid++;
		else {
			c.voteTo();
			candidates.put(candidate_id, c);
		}
    }

    public int invalidVotes() {
        return invalid;
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
 
    public Candidate[] getCandidates() {
        Candidate[] cands = new Candidate[candidates.size()];
        int i = 0;
        for (HashMap.Entry<Integer,Candidate> c : candidates.entrySet()) 
            cands[i++] = c.getValue();
        return cands;
    }   
    
    private final HashMap<Integer, Candidate> candidates = new HashMap<>();
    private int invalid = 0;
	
}