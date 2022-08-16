package jee.oop.bank.service;

public class BankAccountTester {

	public static void main(String[] args) {

		BankAccount b1 = new BankAccount("Pankaj", 5000);
		BankAccount b2 = new BankAccount();
		
		b2.deposit(2000);

		try {
			b1.withdraw(2000);
			b2.withdraw(5000);
		}
		catch( InsuffBalanceException e ) {
			System.out.println( "Insufficient balance " );
			System.out.println( e.getMessage() );
		}
		catch( DailyLimitException e ) {
			System.out.println( "Daily Limits Exceeded " );
			System.out.println( e.getMessage() );
		}
		catch( Exception e ) {
			System.out.println( "Something else went wrong " );
			System.out.println( e.getMessage() );
		}

		System.out.println(b1.getBalance());
		System.out.println(b2.getBalance());

	}

}
