package pmj.bookstore.service;

public class BookServiceFactory {
	
	public static BookService getService() {
		
		switch (PERSISTENC_TYPE) {
			case DAO:
				return new BookServiceImplDAO(); //Relational Table
			case SQL:
				return new BookServiceImplSQL(); //Relational Table
			case INMEMORY:
				return new BookServiceImpl(); //Hash Map store
			default:
				return new BookServiceImplDAO(); 
		}
		
	}
	
    private final static int INMEMORY = 1;
    private final static int SQL = 2;	
    private final static int DAO = 3;	
    private final static int PERSISTENC_TYPE = 3;
	
}
