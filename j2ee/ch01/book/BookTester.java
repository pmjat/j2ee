package pjava.ch03.book;

public class BookTester {

    public static void main(String[] args) {
	Book bk = new Book("101", "Database Systems", 525);
	bk.setPrice(500); 
	System.out.println( bk );        
    }

}
