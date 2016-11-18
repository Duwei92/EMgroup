package EMgroup.admin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import EMgroup.admin.adminInterface.AdminInterface;
import EMgroup.admin.dto.AdminMessage;

public class AdminMessageService implements AdminInterface {

	public static AdminMessage get(String mid) {
		String sql = "select mess from AdminMessage as mess where mess.usable='true' and mess.id='" + mid + "'";
		Session session = adminSessionFactory.openSession();
		Query query = session.createQuery(sql);
		return (AdminMessage) query.uniqueResult();
	}

	public static AdminMessage save(AdminMessage adminMessage) {
		Transaction tx = null;
		Session session = adminSessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			if (adminMessage.getId() != null) {
				session.update(adminMessage);
			} else {
				session.save(adminMessage);
			}
			tx.commit();
			return adminMessage;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<AdminMessage> list(AdminMessage adminMessage) {
		String sql = "select mess from AdminMessage as mess where mess.usable='true' ";
		sql += sqlWhere(adminMessage);
		Transaction tx = null;
		Session session = adminSessionFactory.openSession();
		Query query = session.createQuery(sql);
		return query.list();

	}

	private static String sqlWhere(AdminMessage adminMessage) {

		if (adminMessage == null) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer();
			if (adminMessage.getPublisher() != null && !adminMessage.getPublisher().equals("")) {
				sb.append(" and mess.publisher='").append(adminMessage.getPublisher()).append("'");
			}
			if (adminMessage.getValidDay() != null) {
				sb.append(" and mess.validDay>='").append(date2string(adminMessage.getValidDay())).append("'");
			}
			if (adminMessage.getInvalidDay() != null) {
				sb.append(" and mess.invalidDay>='").append(adminMessage.getInvalidDay()).append("'");
			}
			return sb.toString();
		}
	}

	private static String date2string(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(date);
	}

	public void adminLog() {
	}

}
