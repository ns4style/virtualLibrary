package sql_mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.omg.CORBA.PUBLIC_MEMBER;

@Entity
@Table(name="authors")
public class Authors {
	private int id;
	private String fname;
	private String lname;
	
	public Authors() {
		fname = lname = null;
	}
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	public int getId() {
        return id;
    }
	
	@Column(name="fname")
    public String get_fname(){
        return fname;
    }
	
	@Column(name="lname")
    public String get_lname(){
        return lname;
    }
	
	public void set_id(int id) {
		this.id = id;
	}
	
	public void set_fname(String fname) {
		this.fname = fname;
	}
	
	public void set_lname(String lname) {
		this.lname = lname;
	}
}
