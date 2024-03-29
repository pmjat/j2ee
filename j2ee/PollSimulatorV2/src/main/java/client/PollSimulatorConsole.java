package client;

import java.util.Random;

import pmj.j2ee.pollsimulator.v20.model.Candidate;
import pmj.j2ee.pollsimulator.v20.model.Poll;

public class PollSimulatorConsole {

    public static void main(String[] args) {
        
        String[] candNames = new String[5];
        candNames[0] = "Deep Goyal";
        candNames[1] = "Sneha Mohan";
        candNames[2] = "Praveen Shah";
        candNames[3] = "Akshay Singh";
        candNames[4] = "Somin Majumdar";
        
        Poll poll = new Poll();
        
        poll.setCandidates( candNames );

        int nc = poll.getNumberOfCandidates();
        Random rand = new Random(55);
        int sid = 202012000;
        for( int i = 1; i <=50; i++ ) {
            int x = 1 + rand.nextInt(nc);
            try {
            	poll.vote( ++sid, x );
            	//System.out.println( "Vote Casted: " + sid);
            }
            catch(Exception e) {
            	System.out.println( "Voted already casted: " + sid);
            }
        } 

        //Report the election result
        Candidate[] cands = poll.getCandidates();
        for(Candidate c : cands ) {
            System.out.println( c.getName() + " : " + c.getVoteCount());
        }
        System.out.println("Winner: " + poll.getWinner());
    }

}