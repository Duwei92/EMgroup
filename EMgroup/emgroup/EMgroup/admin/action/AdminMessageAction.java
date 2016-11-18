package EMgroup.admin.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import EMgroup.admin.dto.AdminMessage;
import EMgroup.admin.service.AdminMessageService;

//注解配置action
@Namespace(value = "/admin")
@Action(value = "message")
@Results({ @Result(name = "new", location = "/WEB-INF/page/admin/funcpage/messageNewPage.jsp"),
		@Result(name = "list", location = "/WEB-INF/page/admin/function/message.jsp"),
		@Result(name = "view", location = "/WEB-INF/page/admin/funcpage/messageViewPage.jsp"),
		@Result(name = "update", location = "/WEB-INF/page/admin/funcpage/messageUpdatePage.jsp"),
		@Result(name = "error", location = "/") })

@SuppressWarnings("serial")
public class AdminMessageAction extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest request;
	private AdminMessage adminMessage;
	private String validDay;
	private String invalidDay;
	private String publisher;
	private List<AdminMessage> pageContent;
	private String midList;

	private int size;
	private int pageSize;

	public AdminMessageAction() {
		adminMessage = new AdminMessage();
		pageContent = new ArrayList<AdminMessage>();
	}

	@Override
	public String execute() {
		String method = request.getParameter("method");
		if (method.equals("new")) {
			return "new";
		} else if (method.equals("add")) {
			adminMessage.setPublisher(getUserName());
			adminMessage.setPubTime(new Timestamp(new Date().getTime()));
			if (validDay != null && validDay.contains("-")) {
				adminMessage.setValidDay(dateParse2(validDay));
			} else {
				adminMessage.setValidDay(dateParse(validDay));
			}
			if (invalidDay != null && invalidDay.contains("-")) {
				adminMessage.setInvalidDay(dateParse2(invalidDay));
			} else {
				adminMessage.setInvalidDay(dateParse(invalidDay));
			}

			adminMessage.setUsable("true");
			// check
			// ...
			// save
			AdminMessageService.save(adminMessage);
			// list
			pageContent = AdminMessageService.list(null);
			return "list";

		} else if (method.equals("query")) {
			adminMessage.setPublisher(publisher);
			adminMessage.setValidDay(dateParse2(validDay));
			adminMessage.setInvalidDay(dateParse2(invalidDay));
			pageContent = AdminMessageService.list(adminMessage);
			return "list";
		} else if (method.equals("view")) {
			String mid = request.getParameter("mid");
			adminMessage = AdminMessageService.get(mid);
			return "view";
		} else if (method.equals("update")) {
			String mid = request.getParameter("mid");
			adminMessage = AdminMessageService.get(mid);
			return "update";
		} else if (method.equals("delete")) {
			String[] delList = { adminMessage.getId().toString() };
			AdminMessageService.delete(delList);
			// list
			pageContent = AdminMessageService.list(null);
			return "list";
		} else if (method.equals("deleteList")) {
			String[] delList = midList.split(";");
			AdminMessageService.delete(delList);
			// list
			pageContent = AdminMessageService.list(null);
			return "list";
		}

		return "error";

	}

	private String getUserName() {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
				return cookie.getValue();
			}
		}
		return null;
	}

	private Date dateParse(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		String[] allMonth = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] date = str.split(" ");
		int month = ArrayUtils.indexOf(allMonth, date[1]) + 1;
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return sf.parse(date[0] + "-" + month + "-" + date[2]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("日期解析出错");
			return null;
		}
	}

	private Date dateParse2(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("日期解析出错");
			return null;
		}
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;

	}

	public AdminMessage getAdminMessage() {
		return adminMessage;
	}

	public void setAdminMessage(AdminMessage adminMessage) {
		this.adminMessage = adminMessage;
	}

	public String getValidDay() {
		return validDay;
	}

	public void setValidDay(String validDay) {
		this.validDay = validDay;
	}

	public String getInvalidDay() {
		return invalidDay;
	}

	public void setInvalidDay(String invalidDay) {
		this.invalidDay = invalidDay;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public List<AdminMessage> getPageContent() {
		return pageContent;
	}

	public void setPageContent(List<AdminMessage> pageContent) {
		this.pageContent = pageContent;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getMidList() {
		return midList;
	}

	public void setMidList(String midList) {
		this.midList = midList;
	}

}
