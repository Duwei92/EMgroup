package EMgroup.admin.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import EMgroup.admin.adminInterface.AdminInterface;
import EMgroup.admin.dto.AdminInfo;
import EMgroup.admin.service.AdminService;

@SuppressWarnings({ "serial" })
public class AdminLogin extends ActionSupport implements AdminInterface, ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String username;
	private String password;
	private AdminInfo adminInfo;

	@Override
	public String execute() {
		adminLog();
		// ÅÐ¿Õ
		if (username == null || username.equals("") || password == null || password.equals("")) {
			return ERROR;
		} else {
			// Ô¤·Àsql×¢Èë
			adminInfo = AdminService.get("username", username);
			// MD5 encrption
			if (adminInfo != null && md5.encryption(password).equals(adminInfo.getPassword())) {
				// ÐÞ¸Ä×´Ì¬
				adminInfo.setIp(request.getRemoteAddr());
				adminInfo.setLastlogtime(new Timestamp(new Date().getTime()));
				AdminService.update(adminInfo);
				
				//add cookie
				response.addCookie(new Cookie("username",username));
				// set session,ºóÃæÌí¼Ó
				return SUCCESS;
			} else {
				return ERROR;
			}
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void adminLog() {
		log.info("username:" + username + "  password:" + password);
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;

	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

}
