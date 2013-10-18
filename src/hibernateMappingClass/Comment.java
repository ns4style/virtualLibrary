package hibernateMappingClass;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id_comment")
	private int id;
	
	@Column(name = "id_book")
	private int idBook;
	
	@Column(name = "value")
	private String value;

	@Column(name = "time_stamp")
	private Date timeStamp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_user")
	private User user;

	public Comment() {
		 timeStamp = null;
		 value = null;
	}

	public int getId() {
		return id;
	}
	
	public int getIdBook() {
		return idBook;
	}

	public String getValue() {
		return value;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
