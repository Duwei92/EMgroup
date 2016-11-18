package EMgroup.admin.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminMessage {

	private Integer id;
	private String publisher;
	private String content;
	private Timestamp pubTime;
	private Date validDay;
	private Date invalidDay;
	private String usable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPubTime() {
		return pubTime;
	}

	public void setPubTime(Timestamp pubTime) {
		this.pubTime = pubTime;
	}

	public Date getValidDay() {
		return validDay;
	}

	public void setValidDay(Date validDay) {
		this.validDay = validDay;
	}

	public Date getInvalidDay() {
		return invalidDay;
	}

	public void setInvalidDay(Date invalidDay) {
		this.invalidDay = invalidDay;
	}

	public String getUsable() {
		return usable;
	}

	public void setUsable(String usable) {
		this.usable = usable;
	}

	public String get(String name) {
		AdminMessage am = this;
		if ("validDay".equals(name)) {
			return date2string(am.getValidDay());
		} else if ("invalidDay".equals(name)) {
			return date2string(am.getInvalidDay());
		} else if ("content".equals(name)) {
			if (am.getContent().length() > 20) {
				return am.getContent().substring(0, 19) + "...";
			} else {
				return am.getContent();
			}
		}
		return "";
	}

	private String date2string(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(date);
	}

}
