package hibernateMappingClass;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name="books_tags",
	joinColumns={@JoinColumn(name="id_book", referencedColumnName="id")},  
    inverseJoinColumns={@JoinColumn(name="id_tag", referencedColumnName="id")}) 
	private Set<Tag> tags;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="library",
	joinColumns={@JoinColumn(name="id_book", referencedColumnName="id")},  
	inverseJoinColumns={@JoinColumn(name="id_author", referencedColumnName="id")})
	private Set<Author> authors;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="genre_books",
	joinColumns={@JoinColumn(name="id_book", referencedColumnName="id")},  
	inverseJoinColumns={@JoinColumn(name="id_genre", referencedColumnName="id")})
	private Set<Genre> genres;
	
	public Book() {
		name = null;
		images = new HashSet<Image>(0);
		tags = new HashSet<Tag>(0);
		authors = new HashSet<Author>(0);
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
		this.images.clear();
		this.images.addAll(images);
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags.clear();
		this.tags.addAll(tags);
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors.clear();
		this.authors.addAll(authors);
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres.clear();
		this.genres.addAll(genres);
	}
}
