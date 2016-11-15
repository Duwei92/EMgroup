package EMgroup.admin.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

//◊¢Ω‚≈‰÷√action
@Namespace(value = "/admin")
@Action(value = "adminfucntion")
@Results({ 
	@Result(name = "message", location = "/WEB-INF/page/admin/function/message.jsp"),
	@Result(name = "user", location = "/WEB-INF/page/admin/function/user.jsp"),
	@Result(name = "logger", location = "/WEB-INF/page/admin/function/logger.jsp"),
	@Result(name = "error", location = "/") 
})

@SuppressWarnings("serial")
public class AdminFunction extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;

	@Override
	public String execute() {
		String func = request.getParameter("func");
		if (func.equals("message")) {
			return "message";
		} else if (func.equals("user")) {
			return "user";
		} else if (func.equals("logger")) {
			return "logger";
		}

		return "error";

	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;

	}

}
