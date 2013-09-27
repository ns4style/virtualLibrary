package hibernateMappingClass;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	private int id_book;
	private String value;
	private Date time_stamp;
	private int id_user;

	public Comment() {
		/*
		 * Date dNow = new Date(); SimpleDateFormat ft = new SimpleDateFormat(
		 * "yyyy.MM.dd hh:mm:ss");
		 */
	}

	@Column(name = "id_book")
	public int get_id_book() {
		return id_book;
	}

	@Column(name = "value")
	public String get_value() {
		return value;
	}

	@Column(name = "id_book")
	public Date get_time_stamp() {
		return time_stamp;
	}
}
