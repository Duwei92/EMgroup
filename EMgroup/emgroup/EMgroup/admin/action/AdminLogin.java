package EMgroup.admin.action;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import EMgroup.admin.adminInterface.AdminInterface;
import EMgroup.admin.form.AdminForm;

@SuppressWarnings({ "serial", "deprecation" })
public class AdminLogin extends ActionSupport implements AdminInterface {

	private AdminForm adminForm;

	@Override
	public String execute() {
		adminLog();
		// 判空
		if (adminForm == null || adminForm.getName().equals("") || adminForm.getPassword().equals("")) {
			return ERROR;
		} else {
			String name = adminForm.getName();
			String password = adminForm.getPassword();
			// 预防sql注入
			String sql = "select distinct password from AdminInfo as admin where admin.username=?";
			Session session = adminSessionFactory.openSession();
			Query query = session.createQuery(sql);
			query.setParameter(0, name);
			String pw = (String) query.uniqueResult();

			//MD5 encrption
			if (md5.encryption(password).equals(pw)) {
				//set session,后面添加
				return SUCCESS;
			} else {
				return ERROR;
			}

		}

	}

	public AdminForm getAdminForm() {
		return adminForm;
	}

	public void setAdminForm(AdminForm adminForm) {
		this.adminForm = adminForm;
	}

	public void adminLog() {
		log.info(adminForm);
	}

}
