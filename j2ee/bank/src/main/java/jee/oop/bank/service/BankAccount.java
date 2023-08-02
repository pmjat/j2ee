package jee.oop.bank.service;

class BankAccount{
    
	public BankAccount()   {
		accno = ++BankAccount.next_accno;
		cust_name = "";
		balance = 0;
	}

	public BankAccount(String cname, double initialBalance)   {
		accno = ++BankAccount.next_accno;
		cust_name = cname;
		balance = initialBalance;
	}

	public long getAccno() {
		return accno;
	}  

	public String getCustName() {
		return cust_name;
	}

	public void setCustName(String cname) {
		cust_name = cname;
	}

	public void withdraw(double amount)
			throws DailyLimitException, InsuffBalanceException {
		if ( amount > 25000 )
			throw new DailyLimitException( accno );
		else if ( amount > balance )
			throw new InsuffBalanceException( accno );
		balance = balance - amount;
	}

	public void deposit(double amount)   {
		double newBalance = balance + amount;
		balance = newBalance;
	}

	public double getBalance() {
		return balance;
	}

	public static long getNextAccountNo() {
		return BankAccount.next_accno;
	}

	//EOD process
	public void EOD() {
		//
	}
	
	//EOM Process
	public void EOM() {
		//
	}
	
	
    @Override
    public String toString() {
        return "BankAccount{" + "accno: " + accno 
        		+ ", cust name: " + cust_name
        		+ ", balance: " + balance + '}';
    }

    private final long accno;
    private String cust_name;
    private double balance;
    private static long next_accno=10000;
   
}