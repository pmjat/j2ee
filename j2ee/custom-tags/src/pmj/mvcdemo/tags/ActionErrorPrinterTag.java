package pmj.mvcdemo.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import pmj.mvcdemo.controller.ActionError;

public class ActionErrorPrinterTag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		
		javax.servlet.jsp.JspWriter out = getJspContext().getOut();

		ActionError error = (ActionError) getJspContext()
				.getAttribute("aerror", PageContext.REQUEST_SCOPE);
		//getJspContext() returns a reference to pageContext
		//of jsp in which tag is executing
    	if ( error != null ) {
    		out.write("<h2 style=\"color:red\">Errors!</h2>");
    		out.write("<p style=\"color:red\">");
    		for (Exception err : error.getErrors()) {
    			out.write(err.getMessage() + "<br />");
    		}
    		out.write("</p>");
    	}
	}
}