package pmj.mvcdemo.model;

import javax.servlet.http.HttpServletRequest;

import pmj.mvcdemo.controller.ActionError;

public class UserBeanUtils {	

	public static boolean populateBean(HttpServletRequest request, 
			User user) {

		boolean validated = true;
		
        String user_id = request.getParameter("user_id");
        if (!user_id.isEmpty())
            user.setUserId(user_id);
        else {
        	addError(request, new Exception("User ID is Required"));
        	validated = false;
        }        	        	
        String name = request.getParameter("name");
        if (!name.isEmpty()) 
            user.setName(name);
        else {
        	addError(request, new Exception("User full name is Required"));
        	validated = false;
        }
        String email = request.getParameter("email");
        if (!email.isEmpty()) 
        	user.setEmail(email);
        else {
        	addError(request, new Exception("Email is required"));
        	validated = false;
        }
        String phone = request.getParameter("phone");
        if (!phone.isEmpty() ) 
        	user.setPhone(phone);
        else {
        	addError(request, new Exception("Phone number is required"));
        	validated = false;
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
