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
@Action(value = "message")
@Results({ 
	@Result(name = "new", location = "/WEB-INF/page/admin/funcpage/messageNewPage.jsp"),
	@Result(name = "error", location = "/") 
})

@SuppressWarnings("serial")
public class AdminMessage extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest request;

	@Override
	public String execute() {
		String method = request.getParameter("method");
		if (method.equals("new")) {
			return "new";
		}

		return "error";

	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;

	}

}
