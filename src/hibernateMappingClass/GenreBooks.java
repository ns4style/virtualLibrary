package hibernateMappingClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "genre_books")
public class GenreBooks {
	int id;
	int id_book;
	int id_genre;
	
	//@ManyToOne
	//@JoinTable(name = "genre", joinColumns = @JoinColumn(name = "id"))
	public GenreBooks() { }
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "id_book")
	public int getId_book() {
		return id_book;
	}
	
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	@Column(name = "id_genre")
	public int getId_genre() {
		return id_genre;
	}
	
	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}
	
	
}
