package pmj.jee.bookstore.service;

public class BookServiceFactory {

	public static BookService getService() 
		throws Exception {

		switch (PERSISTENC_TYPE) {
		case DAO:
			return new BookServiceImplDAO(); //DAO DB
		case INMEMORY:
			return new BookServiceImplMem(); //Hash Map store
		default:
			return new BookServiceImplDAO(); 
		}

	}

	private final static int INMEMORY = 1;
	private final static int DAO = 2;	
	private final static int PERSISTENC_TYPE = 2;

}
