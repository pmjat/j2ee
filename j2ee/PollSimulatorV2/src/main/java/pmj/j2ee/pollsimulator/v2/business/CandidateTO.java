package pmj.j2ee.pollsimulator.v2.business;

public class CandidateTO {

	public CandidateTO() {}

	CandidateTO(Candidate c) {
		ID = c.getID();
		name = c.getName();
		vote_count = c.getVoteCount();
	}
	
    public CandidateTO(int id, String name) {
        this.ID = id;
        this.name = name;
    }   

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getVoteCount() {
        return vote_count;
    }
   
    private int ID;
    private String name;
    private int vote_count;
}