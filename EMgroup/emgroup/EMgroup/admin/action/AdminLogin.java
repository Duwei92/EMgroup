package EMgroup.admin.action;

import com.opensymphony.xwork2.ActionSupport;

import EMgroup.admin.form.AdminForm;

public class AdminLogin extends ActionSupport {

	private AdminForm adminForm;

	@Override
	public String execute() {
		if (adminForm != null) {
			System.out.println(adminForm.getName());
		}

		return SUCCESS;
	}

	public AdminForm getAdminForm() {
		return adminForm;
	}

	public void setAdminForm(AdminForm adminForm) {
		this.adminForm = adminForm;
	}

}
