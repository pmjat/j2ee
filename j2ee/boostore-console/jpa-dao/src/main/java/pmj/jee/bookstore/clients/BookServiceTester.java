package pmj.jee.bookstore.clients;

import java.util.ArrayList;

import pmj.jee.bookstore.service.BookTO;
import pmj.jee.bookstore.service.BookService;
import pmj.jee.bookstore.service.BookServiceFactory;

public class BookServiceTester {

    public static void main(String[] args) throws Exception {
        
        System.out.println("Book Service Tester runs ...");
        
        try {
            
            BookService service = BookServiceFactory.getService();

            //BookTO bk1 = dao.find("1001");
            //System.out.println( bk1.getIsbn() + "," + bk1.getTitle());
            
            
            ArrayList<BookTO> books = service.getStock();
            for(BookTO bk : books) {
                System.out.println( bk.getIsbn() + "," + bk.getTitle());
            }

        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage() );
            throw e;
        }
    }       
}