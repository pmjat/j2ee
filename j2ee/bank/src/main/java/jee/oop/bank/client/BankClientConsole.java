package jee.oop.bank.client;
import jee.oop.bank.service.BankService;

public class BankClientConsole {

    public static void main(String[] args) {

        BankService service = new BankService();
        service.open("Amit", 1000); //10001
        service.open("Som", 10000); //10002
        service.open("Sonal", 5000); //10003
        service.open("Lalit", 3000); //10004
        
        try {
        
	        //Now suppose you want to depsoit 3000 to accno 10003.
	        service.deposit( 10003, 3000 );
	
	        //Show new balance of the account
	        System.out.println( service.getBalance( 10003 ) );
	        	        
	        service.withdraw(10002, 5000);
	
	        //Close the acc no 1002
	        double bal_10002 = service.close( 10002 );
	        //display the details to closed account
	        System.out.println( bal_10002 );
	        
	        service.withdraw(10001, 2000);	        
	        
        }
        catch( Exception e) {
	        System.out.println( e.getMessage() );        	
        }

    }

}
