package EMgroup.admin.action;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import EMgroup.admin.adminInterface.AdminInterface;

@SuppressWarnings({ "serial", "deprecation" })
public class AdminLogin extends ActionSupport implements AdminInterface {

	private String username;
	private String password;

	@Override
	public String execute() {
		adminLog();
		// 判空
		if (username == null || username.equals("") || password.equals("")) {
			return ERROR;
		} else {
			// 预防sql注入
			String sql = "select distinct password from AdminInfo as admin where admin.username=?";
			Session session = adminSessionFactory.openSession();
			Query query = session.createQuery(sql);
			query.setParameter(0, username);
			String pw = (String) query.uniqueResult();

			// MD5 encrption
			if (md5.encryption(password).equals(pw)) {
				// set session,后面添加
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

}
