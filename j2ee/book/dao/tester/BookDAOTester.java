package pmj.bookstore.dao.tester;

import java.util.ArrayList;

import pmj.bookstore.dao.BookDAO;
import pmj.bookstore.dao.DAOException;
import pmj.bookstore.dao.DAOFactory;
import pmj.bookstore.service.BookTO;

public class BookDAOTester {

    public static void main(String[] args) throws Exception {
        
        System.out.println("DAO Tester runs ...");
        
        try {
            
            BookDAO book_db = DAOFactory.getBookDAO();

            BookTO bk1 = book_db.find("1001");
            System.out.println( bk1.getIsbn() + "," + bk1.getTitle());
            
            
            ArrayList<BookTO> books = book_db.getAll();
            for(BookTO bk : books) {
                System.out.println( bk.getIsbn() + "," + bk.getTitle());
            }

            System.out.println("page: 2");
            books = book_db.getAllPaginated(1);
            for(BookTO bk : books) {
                System.out.println( bk.getIsbn() + "," + bk.getTitle());
            }
            
            BookTO bk2 = new BookTO();
            bk2.setIsbn("101");
            bk2.setTitle("Maven");
            book_db.insert(bk2);            
            //bk2.setTitle("Maven");
            //book_db.update(bk2);

            //book_db.delete("101");
            
        }
        catch(DAOException e) {
            System.out.println("Error: " + e.getMessage() );
            throw e;
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage() );
            throw e;
        }
    }
    
    
}
