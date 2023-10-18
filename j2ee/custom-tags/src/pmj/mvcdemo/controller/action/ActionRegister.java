package pmj.mvcdemo.controller.action;

import pmj.mvcdemo.controller.Action;
import pmj.mvcdemo.model.User;
import pmj.mvcdemo.model.UserBeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionRegister  implements Action {

    @Override
    public String perform(HttpServletRequest request,
            HttpServletResponse response) {    	
    	User user = new User();
    	boolean validated = UserBeanUtils.populateBean(request, user);
		request.setAttribute("user", user);
    	if (validated)
    		return "reg_success.jsp";
    	else
    		return "register.jsp"; 
    }        
}
