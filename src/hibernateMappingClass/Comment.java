package hibernateMappingClass;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private int id;
	
	@Column(name = "id_book")
	private int idBook;
	
	@Column(name = "value")
	private String value;

	@Column(name = "time_stamp")
	private Date timeStamp;

	@Column(name = "id_user")
	private int idUser;

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
	
	public int getIdUser() {
		return idUser;
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
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
