package hibernateMappingClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "genre")
public class Genre {
	private int id;
	private String value;
	
	Genre() {
		value = null;
	}
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	@Column(name = "value")
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
