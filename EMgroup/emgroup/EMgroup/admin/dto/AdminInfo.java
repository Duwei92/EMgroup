package EMgroup.admin.dto;

import java.sql.Timestamp;

public class AdminInfo {
	private String id;
	private String username;
	private String password;
	// �ϴε�¼��Ϣ�˶�
	private Timestamp lastlogtime;// ��¼ʱ��
	private String ip;// ��¼IP

	public AdminInfo() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Timestamp getLastlogtime() {
		return lastlogtime;
	}

	public void setLastlogtime(Timestamp lastlogtime) {
		this.lastlogtime = lastlogtime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
