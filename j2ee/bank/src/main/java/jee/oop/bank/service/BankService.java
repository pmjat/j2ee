package jee.oop.bank.service;

import java.util.HashMap;
import java.util.Collection;

public class BankService {
	
	public BankService() {
		accounts = new HashMap<Long,BankAccount>();
	}

	//Open a new Account
	public long open( String cname, double balance) {
		BankAccount acc = new BankAccount( cname, balance );
		accounts.put( acc.getAccno(), acc);
		return acc.getAccno();
	}
	
	//Deposit Money in an Account
	public void deposit(long accno, double amount) 
			throws AccountNotFound {
		BankAccount acc = accounts.get(accno);
		if ( acc == null )
			throw new AccountNotFound( acc );
		acc.deposit(amount);		
	}

	//Withdraw Money from an account
	public void withdraw(long accno, double amount) 
			throws AccountNotFound, DailyLimitException, InsuffBalanceException {
		BankAccount acc = accounts.get(accno);
		if ( acc == null )
			throw new AccountNotFound( acc );
		acc.withdraw(amount);
	}

	//Get Balance for a given account number
	public double getBalance( long accno )
			throws AccountNotFound {
		BankAccount acc = accounts.get(accno);
		if ( acc == null )
			throw new AccountNotFound( acc );
		return acc.getBalance();
	}
	
	//Close an Account
	public double close( long acc_no ) {
		BankAccount acc = accounts.remove( acc_no );
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
