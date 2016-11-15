package EMgroup.admin.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

//◊¢Ω‚≈‰÷√action
@Namespace(value="/admin")
@Action(value="logout")
@Results({
	@Result(name="success",location="/WEB-INF/page/admin/login/adminlogin.html")
})

@SuppressWarnings("serial")
public class AdminLogout extends ActionSupport implements ServletResponseAware {
	private HttpServletResponse response;

	@Override
	public String execute() {
		//nouse,the domain path is different
		Cookie temp = new Cookie("username", "");
		temp.setMaxAge(0);
		response.addCookie(temp);
		return SUCCESS;

	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

}
