package pmj.jee.bookstore.service;

import java.util.ArrayList;
import pmj.jee.bookstore.dao.BookDAO;
import pmj.jee.bookstore.dao.sql.BookDAOImplSQL;


public class BookServiceImplDAO implements BookService {

	BookDAO bookdb;
	public BookServiceImplDAO() 
			throws Exception {
		bookdb = new BookDAOImplSQL();
	}

	@Override
	public ArrayList<BookTO> getStock() {
		ArrayList<BookTO> book_list = null;        
		try {        	
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
			bookdb.insert(bk);
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void updateBook(BookTO bk) {
		try {
			bookdb.update(bk);
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void removeBook(String isbn) {
		try {
			bookdb.delete(isbn);
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}    

}
