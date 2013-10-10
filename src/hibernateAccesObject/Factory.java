package hibernateAccesObject;

public class Factory {

	private static AuthorHAO authorHAO = null;
	private static BookHAO bookHAO = null;
	private static CommentHAO commentHAO = null;
	private static ImageHAO imageHAO = null;
	private static LibraryHAO libraryHAO = null;
	private static UserHAO userHAO = null;
	private static GenreHAO genreHAO = null;
	private static GenreBookHAO genreBookHAO = null;
	private static MarkHAO markHAO = null;
	private static TagHAO tagHAO = null;
	private static TakedBookHAO takedBookHAO = null;
	private static NewsHAO newsHAO = null;
	
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
	
	public TagHAO getTagHAO() {
		if (tagHAO == null) {
			tagHAO = new TagHAO();
		}
		return tagHAO;
	}
	
	public TakedBookHAO getTakedBookHAO() {
		if (takedBookHAO == null) {
			takedBookHAO = new TakedBookHAO();
		}
		return takedBookHAO;
	}
		public GenreHAO getGenreHAO() {
		if (genreHAO == null) {
			genreHAO = new GenreHAO();
		}
		return genreHAO;
	}
	
	public GenreBookHAO getGenreBookHAO() {
		if (genreBookHAO == null) {
			genreBookHAO = new GenreBookHAO();
		}
		return genreBookHAO;
	}
	
	public MarkHAO getMarkHAO() {
		if (markHAO == null) {
			markHAO = new MarkHAO();
		}
		return markHAO;
	}
	
	public NewsHAO getNewsHAO() {
		if (newsHAO == null) {
			newsHAO = new NewsHAO();
		}
		return newsHAO;
	}
}