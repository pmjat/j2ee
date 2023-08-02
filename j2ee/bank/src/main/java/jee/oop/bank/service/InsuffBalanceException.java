package jee.oop.bank.service;

public class InsuffBalanceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InsuffBalanceException(Object accno) {
        super( "Insufficient balance (Account No: " + accno.toString() + ")");		
	}
    
}
