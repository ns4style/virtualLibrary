package hibernateMappingClass;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "count")
	private int count;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="id_book")
	private Set<Image> images;

	public Book() {
		name = null;
		images = new HashSet<Image>(0);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public Set<Image> getImages() {
		return images;
	}
	
	public void setImages(Set<Image> authors) {
		this.images.addAll(images);
	}
}
