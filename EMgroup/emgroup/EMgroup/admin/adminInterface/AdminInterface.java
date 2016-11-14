package EMgroup.admin.adminInterface;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import EMgroup.util.HibernateUtil;
import EMgroup.util.MD5Encryption;

public interface AdminInterface {
	
	public static Log log = LogFactory.getLog(AdminInterface.class);
	public static SessionFactory adminSessionFactory = HibernateUtil.getsessionFactory();
	public static MD5Encryption md5 = MD5Encryption.getInstance();
	
	public void adminLog();

}
