package hibernateAccesObject;

public class Factory {

	private static AuthorHAO authorHAO = null;
	private static BookHAO bookHAO = null;
	private static CommentHAO commentHAO = null;
	private static ImageHAO imageHAO = null;
	private static LibraryHAO libraryHAO = null;
	private static UserHAO userHAO = null;
	
	private static Factory instance = null;

	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public AuthorHAO getAuthorHAO() {
		if (authorHAO == null) {
			authorHAO = new AuthorHAO();
		}
		return authorHAO;
	}

	public BookHAO getBookHAO() {
		if (bookHAO == null) {
			bookHAO = new BookHAO();
		}
		return bookHAO;
	}
	
	public CommentHAO getCommentHAO() {
		if (commentHAO == null) {
			commentHAO = new CommentHAO();
		}
		return commentHAO;
	}
	
	public ImageHAO getImageHAO() {
		if (imageHAO == null) {
			imageHAO = new ImageHAO();
		}
		return imageHAO;
	}
	
	public LibraryHAO getLibraryHAO() {
		if (libraryHAO == null) {
			libraryHAO = new LibraryHAO();
		}
		return libraryHAO;
	}
	
	public UserHAO getUserHAO() {
		if (userHAO == null) {
			userHAO = new UserHAO();
		}
		return userHAO;
	}
}