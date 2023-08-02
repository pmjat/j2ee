package jee.oop.bank.service;

public class AccountNotFound extends Exception{
	private static final long serialVersionUID = 1L;
	
	public AccountNotFound(Object accno) {
        super( "Account Not Found (Account No: " + accno.toString() + ")");		
	}
    
}
