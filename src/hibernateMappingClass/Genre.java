package hibernateMappingClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "genre")
public class Genre {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private int id;
	
	@Column(name = "value")
	private String value;
	
	public Genre() {
		value = null;
	}
	
	public int getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
