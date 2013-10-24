package servlet;


import hibernateAccesObject.Factory;
import hibernateMappingClass.Author;
import hibernateMappingClass.Book;
import hibernateMappingClass.Genre;
import hibernateMappingClass.News;
import hibernateMappingClass.Tag;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminClass {
	
	public static void showListGenres(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Writer wr=response.getWriter();
		String str="";
		List<Genre> genres = Factory.getInstance().getGenreHAO().getAllGenres();
		for (ListIterator<Genre> i=genres.listIterator(); i.hasNext();){
		str+=i.next().getValue()+" ";
		}
		str=str.substring(0, str.length()-1);
		wr.write(str);
		wr.close();
		return;
	}
	
	public static void editListGenre(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Genre modify=Factory.getInstance().getGenreHAO().getGenreByName(request.getParameter("oldname"));
		modify.setValue(request.getParameter("newname"));
		Factory.getInstance().getGenreHAO().updateGenre(modify);
		return;
	}
	
	public static void deleteGenre(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Genre delete=Factory.getInstance().getGenreHAO().getGenreByName(request.getParameter("name"));
		Factory.getInstance().getGenreHAO().deleteGenre(delete);
		return;
	}
	
	public static void addGenre(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Genre genre = new Genre();
		genre.setValue(request.getParameter("name"));
		Factory.getInstance().getGenreHAO().addGenre(genre);
		return;
	}
	
	public static void showListTags(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Writer wr=response.getWriter();
		String str="";
		List<Tag> tags = Factory.getInstance().getTagHAO().getAllTags();
		for (ListIterator<Tag> i=tags.listIterator(); i.hasNext();){
		str+=i.next().getValue()+" ";
		}
		str=str.substring(0, str.length()-1);
		wr.write(str);
		wr.close();
		return;
	}
	
	public static void addTag(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Tag tag = new Tag();
		tag.setValue(request.getParameter("name"));
		Factory.getInstance().getTagHAO().addTag(tag);
		return;
	}

	public static void deleteTag(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Tag delete=Factory.getInstance().getTagHAO().getTagByName(request.getParameter("name"));
		Factory.getInstance().getTagHAO().deleteTag(delete);
		return;
	}
	
	public static void editListTags(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Tag modify=Factory.getInstance().getTagHAO().getTagByName(request.getParameter("oldname"));
		modify.setValue(request.getParameter("newname"));
		Factory.getInstance().getTagHAO().updateTag(modify);
		return;
	}
	
	public static void showListAuthors(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Writer wr=response.getWriter();
		String str="";
		List<Author> authors = Factory.getInstance().getAuthorHAO().getAllAuthors();
		for (ListIterator<Author> i=authors.listIterator(); i.hasNext();){
		str+=i.next().getFullName()+" ";
		}
		str=str.substring(0, str.length()-1);
		wr.write(str);
		wr.close();
		return;
	}
	
	public static void addAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Author author = new Author();
		String[] str = request.getParameter("name").split(" ");
		author.setFirstName(str[0]);
		author.setLastName(str[1]);
		Factory.getInstance().getAuthorHAO().addAuthors(author);
		return;
	}
	
	public static void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Author delete=Factory.getInstance().getAuthorHAO().getAuthorByName(request.getParameter("name"));
		Factory.getInstance().getAuthorHAO().deleteAuthor(delete);
		return;
	}
	
	public static void editListAuthors(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Author modify=Factory.getInstance().getAuthorHAO().getAuthorByName(request.getParameter("oldname"));	
		String[] names=request.getParameter("newname").split("_");
		modify.setFirstName(names[0]);
		modify.setLastName(names[1]);
		Factory.getInstance().getAuthorHAO().updateAuthor(modify);
		return;
	}
	
	public static void showListNews(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Writer wr=response.getWriter();
		String str="";
		News temp;
		List<News> news = Factory.getInstance().getNewsHAO().getAllNews();
		for (ListIterator<News> i=news.listIterator(); i.hasNext();){
			temp=i.next();
			str+=temp.getId()+"_-_";
			str+=temp.getNews()+"_-_";
		}
		str=str.substring(0, str.length()-3);
		wr.write(str);
		wr.close();
		return;
	}
	
	public static void addNews(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		News news = new News();
		news.setNews(request.getParameter("name"));
		Factory.getInstance().getNewsHAO().addNews(news);
		return;
	}
	
	public static void deleteNews(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		News delete=Factory.getInstance().getNewsHAO().getNewsByName(request.getParameter("name"));
		Factory.getInstance().getNewsHAO().deleteNews(delete);
		return;
	}
	
	public static void editListNews(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		News modify=Factory.getInstance().getNewsHAO().getNewsByName(request.getParameter("oldname"));	
		modify.setNews(request.getParameter("newname"));
		Factory.getInstance().getNewsHAO().updateNews(modify);
		return;
	}
	
	public static void showListBooks(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Writer wr=response.getWriter();
		String str="";
		Book temp;
		List<Book> books = Factory.getInstance().getBookHAO().getAllBooks();
		for (ListIterator<Book> i=books.listIterator(); i.hasNext();){
			temp=i.next();
			str+=temp.getId()+"_-_";
			str+=temp.getName()+"_-_";
		}
		str=str.substring(0, str.length()-3);
		wr.write(str);
		wr.close();
		return;
	}
	
	public static void listAttrsofBook(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Book book = Factory.getInstance().getBookHAO().getBooktById(Integer.parseInt(request.getParameter("id")));

		StringBuffer s = new StringBuffer();
		Iterator i = book.getGenres().iterator();
		while (i.hasNext()) {
			Genre g = (Genre) i.next();
			s.append(g.getValue() + "_-_");
		}
		s.append("!#!");
		
		i = book.getTags().iterator();
		while (i.hasNext()) {
			Tag t = (Tag) i.next();
			s.append(t.getValue() + "_-_");
		}
		s.append("!#!");
		
		i = book.getAuthors().iterator();
		while (i.hasNext()) {
			Author a = (Author) i.next();
			s.append(a.getFullName() + "_-_");
		}
		
		Writer wr=response.getWriter();
		wr.write(s.toString());
		System.out.println(s);
		return;
	}
	
	public static void editDetailBook(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String[] genres=request.getParameter("genres").split(" ");
		String[] tags=request.getParameter("tags").split(" ");
		String[] authors=request.getParameter("authors").split(" ");
		Set<Genre> setGenre = new HashSet<Genre>();
		Set<Tag> setTag = new HashSet<Tag>();
		Set<Author> setAuthor = new HashSet<Author>();
		int i;
		Genre tempGenre;
		Tag tempTag;
		Author tempAuthor;
		for (i=0;i<genres.length;i++){
			tempGenre=Factory.getInstance().getGenreHAO().getGenreByName(genres[i]);
			setGenre.add(tempGenre);
		}
		for (i=0;i<tags.length;i++){
			tempTag=Factory.getInstance().getTagHAO().getTagByName(tags[i]);
			setTag.add(tempTag);
		}
		for (i=0;i<authors.length;i++){
			tempAuthor=Factory.getInstance().getAuthorHAO().getAuthorByName(authors[i]);
			setAuthor.add(tempAuthor);
		}
		Book modBook=Factory.getInstance().getBookHAO().getBooktById(Integer.parseInt(request.getParameter("bookId")));
		modBook.setAuthors(setAuthor);
		modBook.setGenres(setGenre);
		modBook.setTags(setTag);
		Factory.getInstance().getBookHAO().updateBook(modBook);
		return;
	}
}
