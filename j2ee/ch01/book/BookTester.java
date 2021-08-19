package pjava.ch03.book;

public class BookTester {

    public static void main(String[] args) {
	Book bk = new Book("101", "Database Systems", 525);
	//bk.price = 500; //price is inaccessible
	bk.setPrice(500); //is accessible
        
    }

    
}
