package jee.oop.bank.service;

import java.util.HashMap;

public class BankService {
	
	public BankService() {
		accounts = new HashMap<Long,BankAccount>();
	}

	//Open a new Account
	public long open( String cname, double balance) {
		BankAccount acc = new BankAccount( cname, balance );
		accounts.put( acc.getAccno(), acc);
		//return account number of newly opened account
		//Note that Account numbers are auto-generated and 
		//starts from 10001
		return acc.getAccno();
	}
	
	//Deposit Money in an Account
	public double deposit(long accno, double amount) 
			throws AccountNotFound {
		BankAccount acc = accounts.get(accno);
		if ( acc == null )
			throw new AccountNotFound( acc );
		acc.deposit(amount);
		//return the final balance of the account
		return acc.getBalance();
	}

	//Withdraw Money from an account
	public double withdraw(long accno, double amount) 
			throws AccountNotFound, DailyLimitException, InsuffBalanceException {
		BankAccount acc = accounts.get(accno);
		if ( acc == null )
			throw new AccountNotFound( acc );
		acc.withdraw(amount);
		//return the final balance of the account
		return acc.getBalance();
	}

	//Get Balance for a given account number
	public double getBalance( long accno )
			throws AccountNotFound {
		BankAccount acc = accounts.get(accno);
		if ( acc == null )
			throw new AccountNotFound( acc );
		return acc.getBalance();
	}

	//Get Account Details
	public String getAccountInfo( long accno )
			throws AccountNotFound {
		BankAccount acc = accounts.get(accno);
		if ( acc == null )
			throw new AccountNotFound( acc );
		return acc.toString();
	}	
	
	//Close an Account
	//public double close( long acc_no ) {
	public double close( long accno )
				throws AccountNotFound {
		BankAccount acc = accounts.remove( accno );
		if ( acc == null )
			throw new AccountNotFound( acc );
		//Otherwise return balance of the account being closed
		//so that settlement can be done
		return acc.getBalance();
	}
	
	//EOD process
	public void EOD() {
		for (BankAccount acc : accounts.values())
			acc.EOD();
	}

	//EOM Process
	public void EOM() {
		for (BankAccount acc : accounts.values())
			acc.EOM();
	}

	private HashMap<Long, BankAccount> accounts;
	
}
