package hibernateMappingClass;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comments")
public class Comment {
	private int id;
	private int idBook;
	private String value;
	private Date timeStamp;
	private int idUser;

	public Comment() {
		 timeStamp = null;
		 value = null;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	@Column(name = "id_book")
	public int getIdBook() {
		return idBook;
	}

	@Column(name = "value")
	public String getValue() {
		return value;
	}
	
	@Column(name = "time_stamp")
	public Date getTimeStamp() {
		return timeStamp;
	}
	
	@Column(name = "id_user")	
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
