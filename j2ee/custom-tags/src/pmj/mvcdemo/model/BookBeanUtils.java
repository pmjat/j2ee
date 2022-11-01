package pmj.mvcdemo.model;

import javax.servlet.http.HttpServletRequest;

import pmj.mvcdemo.controller.ActionError;

public class BookBeanUtils {	

	public static boolean populateBean(HttpServletRequest request, BookBean book) {

		boolean validated = true;
		
        String isbn = request.getParameter("isbn");
        if (!isbn.isEmpty())
            book.setIsbn(isbn);
        else {
        	addError(request, new Exception("isbn required"));
        	validated = false;
        }        	        	
        String title = request.getParameter("title");
        if (!title.isEmpty()) 
            book.setTitle(title);
        else {
        	addError(request, new Exception("Title required"));
        	validated = false;
        }
        String sprice = request.getParameter("price");
        if (sprice.isEmpty() || sprice.startsWith("0")) {
        	addError(request, new Exception("Price required"));
        	validated = false;
        }
        else {
	        double price = 0;
	        try {
	        	price = Double.parseDouble(request.getParameter("price"));
	            book.setPrice(price);
	        }
	        catch(Exception e) {
	        	addError(request, new Exception("Invalid Entry for Price"));        	
	        	validated = false;
	        }
        }
        String sqty = request.getParameter("stock");
        if (sqty.isEmpty() || sqty.startsWith("0") ) {
        	addError(request, new Exception("Stock required"));
        	validated = false;
        }
        else {
		    int qty = 0;
		    try {
		    	qty = Integer.parseInt(request.getParameter("stock"));
	            book.setStock(qty);
		    }
		    catch(Exception e) {
		    	addError(request, new Exception("Invalid Entry for Stock"));        	
		    	validated = false;
		    }
        }
        
        return validated;
        
	}	
	private static void addError(HttpServletRequest request, Exception e) {
		ActionError err = (ActionError) request.getAttribute("aerror");
		if (err == null) {
			err = new ActionError();
			request.setAttribute("aerror", err);
		}
		err.addError(e);				
	}
}
