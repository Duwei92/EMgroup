package EMgroup.admin.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import EMgroup.admin.adminInterface.AdminInterface;
import EMgroup.admin.dto.AdminInfo;

public class AdminService implements AdminInterface {

	public void adminLog() {
	}

	public static AdminInfo get(String str1, String str2) {
		String sql = "from AdminInfo as admin where admin." + str1 + "=?";
		Session session = adminSessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setParameter(0, str2);
		return (AdminInfo) query.uniqueResult();
	}

	public static AdminInfo update(AdminInfo adminInfo) {
		Transaction tx = null;
		Session session = adminSessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.update(adminInfo);
			tx.commit();
			return adminInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
