package EMgroup.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * database
 * @author HAHA
 * ����ģʽ
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			System.out.println("hibernate cfg error");
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getsessionFactory(){
		return sessionFactory;
	}
}
