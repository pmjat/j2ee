package client;

import java.util.Random;

import pmj.j2ee.pollsimulator.v2.business.CandidateTO;
import pmj.j2ee.pollsimulator.v2.business.PollService;

public class PollSimulatorV21Console {

    public static void main(String[] args) {
    	
    	//get handle to Poll Service
    	//here we are constructing, but should access its reference 
    	//from business layer
        PollService pollService = new PollService();
    	
        String[] candNames = new String[5];
        candNames[0] = "Deep Goyal";
        candNames[1] = "Sneha Mohan";
        candNames[2] = "Praveen Shah";
        candNames[3] = "Akshay Singh";
        candNames[4] = "Somin Majumdar";
        
        pollService.setCandidates( candNames );

        int nc = 5;
        Random rand = new Random(55);
        int sid = 202012000;
        for( int i = 1; i <= 50; i++ ) {
            int x = 1 + rand.nextInt(nc);
            try {
            	pollService.vote( ++sid, x );
            }
            catch(Exception e) {
            	System.out.println( "Voted already casted: " + sid);
            }
        } 

        //Report the election result
        CandidateTO[] cands = pollService.getCandidates();
        for(CandidateTO c : cands ) {
            System.out.println( c.getName() + " : " + c.getVoteCount());
        }
        System.out.println("Rejected: " + pollService.invalidVotes() );
        
        System.out.println("Winner: " + pollService.getWinner() );

    }

}