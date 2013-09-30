package hibernateAccesObject;

public class Factory {

	private static AuthorHAO authorHAO = null;
	private static BookHAO bookHAO = null;
	private static CommentHAO commentHAO = null;
	
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
}