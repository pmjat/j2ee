package pmj.mvcdemo.controller.action;

import pmj.mvcdemo.controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pmj.mvcdemo.model.User;

public class ActionRegForm  implements Action {

    @Override
    public String perform(HttpServletRequest request,
            HttpServletResponse response) {
    	User user = new User();
        request.setAttribute("user", user);
        return "register.jsp";
    }
}
