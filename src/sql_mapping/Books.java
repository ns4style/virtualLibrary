package sql_mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="books")
public class Books {
	private int id;
	private String name;
	private int count;
	
	public Books() {
		name = null;
	}
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	public int getId() {
        return id;
    }
	
	@Column(name="name")
    public String get_name(){
        return name;
    }
	
	@Column(name="count")
    public int get_fname(){
        return count;
    }
	
	public void set_id(int id) {
		this.id = id;
	}
	
	public void set_name(String fname) {
		this.name = name;
	}
	
	public void set_count(String lname) {
		this.count = count;
	}
}
