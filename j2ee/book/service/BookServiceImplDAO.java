package pmj.bookstore.service;

import java.util.ArrayList;

import pmj.bookstore.dao.BookDAO;
import pmj.bookstore.dao.DAOFactory;

class BookServiceImplDAO implements BookService {
       
    @Override
    public ArrayList<BookTO> getStock() {
        ArrayList<BookTO> book_list = null;        
        try {        	
        	BookDAO bookdb = DAOFactory.getBookDAO();        	
        	book_list = bookdb.getAll();        	
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }        
        return book_list;    	    	
    }

    @Override
    public BookTO getBook(String isbn) {
        BookTO bk = null;
        try {
        	BookDAO bookdb = DAOFactory.getBookDAO();        	
        	bk = bookdb.find(isbn);
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return bk;
    }
    
    @Override
    public void addBook(BookTO bk) {
        try {
        	BookDAO bookdb = DAOFactory.getBookDAO(); 
        	bookdb.insert(bk);
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void updateBook(BookTO bk) {
        try {
        	BookDAO bookdb = DAOFactory.getBookDAO(); 
        	bookdb.update(bk);
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @Override
    public void removeBook(String isbn) {
        try {
        	BookDAO bookdb = DAOFactory.getBookDAO(); 
        	bookdb.delete(isbn);
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
   }    

}
