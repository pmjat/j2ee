package pmj.bookstore.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import pmj.util.jdbc.ConnManager;

class BookServiceImplSQL implements BookService {
       
    @Override
    public ArrayList<BookTO> getStock() {

        ArrayList<BookTO> book_list = new ArrayList<>();
        BookTO b;
        try {
        	Connection conn = ConnManager.getInstance()
        			.getConnection("books");
            Statement stmt = conn.createStatement();        
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS");
            while ( rs.next() ) {
                b = new BookTO();
                b.setIsbn( rs.getString("isbn") );
                b.setTitle( rs.getString("title") );
                b.setPrice( rs.getDouble("price") );
                b.setStock( rs.getInt("stock") );            
                book_list.add( b );
            }        
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
        	Connection conn = ConnManager.getInstance()
        			.getConnection("books");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books WHERE isbn ='" + isbn + "'");
            if ( rs.next() ) {
                bk = new BookTO();
                bk.setIsbn( isbn );
                bk.setTitle(rs.getString("title"));
                bk.setPrice(rs.getDouble("price"));
                bk.setStock(rs.getInt("stock"));            
            }
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return bk;
    }
    
    @Override
    public void addBook(BookTO bk) {
        int n=0;
        try {
        	Connection conn = ConnManager.getInstance()
        			.getConnection("books");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO books (isbn, title, price, stock) VALUES(" +
                "'" + bk.getIsbn() + "', " +
                "'" + bk.getTitle() + "', " +
                bk.getPrice() + ", " +
                bk.getStock() + "); ";
            n = stmt.executeUpdate( sql );
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        if ( n <=0 )
        	throw new RuntimeException ("Error: Book Could not be inserted!");
    }

    @Override
    public void updateBook(BookTO bk) {
        //pre-condition: isbn exists
        int n=0;
        try {
        	Connection conn = ConnManager.getInstance()
        			.getConnection("books");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "UPDATE books set " +
                "title = '" +  bk.getTitle() + "', " +
                "price = " + bk.getPrice() + ", " +
                "stock = " + bk.getStock() + 
                " WHERE isbn = '" + bk.getIsbn() + "'; ";
            n = stmt.executeUpdate( sql );
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        if ( n <=0 )
        	throw new RuntimeException ("Error: Book Could not be updated!");
    }
    
    @Override
    public void removeBook(String isbn) {
        //pre-condition: isbn exists
        String sql = "DELETE FROM books WHERE isbn = '" + isbn + "'; ";
        int n=0;
        try {
        	Connection conn = ConnManager.getInstance()
        			.getConnection("books");
            Statement stmt = conn.createStatement();
            n = stmt.executeUpdate( sql );
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        if ( n != 1 )
        	throw new RuntimeException ("Error: Book Could not be deleted!");
    }    

}
