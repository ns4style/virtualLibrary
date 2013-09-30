package hibernateMappingClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "genre_books")
public class GenreBook {	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	int id;	
	
	@Column(name = "id_book")
	int idBook;
	
	@Column(name = "id_genre")
	int idGenre;
	
	public GenreBook() { }

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdBook() {
		return idBook;
	}
	
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public int getIdGenre() {
		return idGenre;
	}
	
	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}
}
