package lab01.pollsimulator.clients;

import java.util.Random;

import lab01.pollsimulator.business.Candidate;
import lab01.pollsimulator.business.Poll;
import lab01.pollsimulator.business.AlreadyCasted;
import lab01.pollsimulator.business.InvalidVote;

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
            int x = 1 + rand.nextInt(nc+1);
            try {
            	poll.vote( ++sid, x );
            	//System.out.println( "Vote Casted: " + sid);
            }
            catch(InvalidVote e) { //when candidate id is invalid
            	System.out.println("Your vote goes to invalid votes:" );
            }
            catch(AlreadyCasted e) {
            	System.out.println( "Voted already casted: " + sid);
            }
        } 

        //Report the election result
        Candidate[] cands = poll.getCandidates();
        for(Candidate c : cands ) {
            System.out.println( c.getName() + " : " + c.getVoteCount());
        }
        System.out.println("Invalid votes ##:" + poll.getInvalidVotes() );
        System.out.println("Winner: " + poll.getWinner());
    }

}