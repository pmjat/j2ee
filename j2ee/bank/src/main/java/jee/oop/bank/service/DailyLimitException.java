package jee.oop.bank.service;

public class DailyLimitException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DailyLimitException( Object accno ) {
        super( "Daily Limits Exceeded (Account No: " + accno.toString() + ")");		
	}
    
}
