package servlet;


import hibernateAccesObject.Factory;
import hibernateMappingClass.Author;
import hibernateMappingClass.Book;
import hibernateMappingClass.Genre;
import hibernateMappingClass.Image;
import hibernateMappingClass.News;
import hibernateMappingClass.Tag;
import hibernateMappingClass.TakedBook;
import hibernateMappingClass.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import JstlHelper.Functions;


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
		if (str.length()!=0)
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
		s.append("!#!");
		i=book.getImages().iterator();
		while (i.hasNext()){
			Image im= (Image) i.next();
			s.append(im.getPath()+"_-_");
		}
		
		Writer wr=response.getWriter();
		wr.write(s.toString());
		return;
	}
	
	public static void editDetailBook(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String[] genres=request.getParameter("genres").split(" ");
		String[] tags=request.getParameter("tags").split(" ");
		String[] authors=request.getParameter("authors").split(" ");
		String[] images=request.getParameter("images").split(" ");
		Set<Genre> setGenre = new HashSet<Genre>();
		Set<Tag> setTag = new HashSet<Tag>();
		Set<Author> setAuthor = new HashSet<Author>();
		Set<Image> setImage =new HashSet<Image>();
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
		
		for (i=0;i<images.length;i++){
			File img = new File("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\images\\tempphoto"+(i+1)+".jpg");
			if (img.exists()){
				File back = new File("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\"+images[i]);
				back.delete();
				img.renameTo(back);
			}
		}
		Book modBook=Factory.getInstance().getBookHAO().getBooktById(Integer.parseInt(request.getParameter("bookId")));
		modBook.setAuthors(setAuthor);
		modBook.setGenres(setGenre);
		modBook.setTags(setTag);
		modBook.setName(request.getParameter("name"));
		Factory.getInstance().getBookHAO().updateBook(modBook);
		return;
	}
	
	public static void addDetailBook(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
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
		Book newBook= new Book();
		newBook.setAuthors(setAuthor);
		newBook.setGenres(setGenre);
		newBook.setTags(setTag);
		newBook.setName(request.getParameter("name"));
		Factory.getInstance().getBookHAO().addBook(newBook);
		Random rnd = new Random(System.currentTimeMillis());
		for (i=1;i<4;i++){
			File f = new File ("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\images\\"+rnd.nextInt(100000000)+".jpg");
			if (f.exists()){
				i--;
				continue;
			}
			File f2 = new File ("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\images\\tempphoto"+i+".jpg");
			f2.renameTo(f);
			Image image = new Image();
			image.setPath("../images/"+f.getName());
			System.out.println(newBook.getId());
			image.setIdBook(newBook.getId());

			Factory.getInstance().getImageHAO().addImage(image);
		}
		return;
	}
	
	public static void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Book book=Factory.getInstance().getBookHAO().getBooktById(Integer.parseInt(request.getParameter("id")));
		Iterator it=book.getImages().iterator();
		while (it.hasNext()) {
			Image a = (Image) it.next();
			File f = new File ("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\images\\"+a.getPath().split("/")[2]);
			f.delete();
		}
		Factory.getInstance().getBookHAO().deleteBook(book);
	}
	
	public static void getPhoto(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String answer="";
		try {
			Part upFile=request.getPart("photo1");
			if (upFile != null){
				answer="<div id='photo1'></div>";
				InputStream content = upFile.getInputStream();
				FileOutputStream wrt = new FileOutputStream(new File("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\images\\temp"+upFile.getName()+".jpg"));
				byte[] c = new byte [100];
				while ((content.read(c))>=0) {
					wrt.write(c);
				}
				wrt.close();
			}
			
			Part upFile2=request.getPart("photo2");
			if (upFile2 != null){
				answer="<div id='photo2'></div>";
				InputStream content = upFile2.getInputStream();
				FileOutputStream wrt = new FileOutputStream(new File("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\images\\temp"+upFile2.getName()+".jpg"));
				byte[] c = new byte [100];
				while ((content.read(c))>=0) {
					wrt.write(c);
				}
				wrt.close();
			}
			
			Part upFile3=request.getPart("photo3");
			if (upFile3 != null){
				answer="<div id='photo3'></div>";
				InputStream content = upFile3.getInputStream();
				FileOutputStream wrt = new FileOutputStream(new File("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\images\\temp"+upFile3.getName()+".jpg"));
				byte[] c = new byte [100];
				while ((content.read(c))>=0) {
					wrt.write(c);
				}
				wrt.close();
			}
			
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write(answer);
			return;
	}
	
	public static void pleaseDeleteAllTrash(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		File f = new File ("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\images\\tempphoto1.jpg");
		if (f.exists())
			f.delete();
		f = new File ("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\images\\tempphoto2.jpg");
		if (f.exists())
			f.delete();
		f = new File ("C:\\Users\\Artem\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp6\\wtpwebapps\\Library\\images\\tempphoto3.jpg");
		if (f.exists())
			f.delete();
	}
	
	public static void showListUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		List<User> users = Factory.getInstance().getUserHAO().getAllUsers();
		Iterator it = users.iterator();
		String line="";
		while (it.hasNext()){
			User u = (User) it.next();
			line+=u.getId()+" "+u.getMail()+" "+u.getFname()+"_"+u.getLname()+"_-_";
		}
		line=line.substring(0, line.length()-3);
		response.getWriter().write(line);
		return;
	}
	
	public static void showDetailUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		User user = Factory.getInstance().getUserHAO().getUserById(Integer.parseInt(request.getParameter("id")));
		String str= "";
		str+=user.getId()+" "+user.getMail()+" "+user.getPrivileged();
		response.getWriter().write(str);
		return;
	}
	
	public static void changePrivilegion(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		User user = Factory.getInstance().getUserHAO().getUserById(Integer.parseInt(request.getParameter("id")));
		user.setPrivileged(Integer.parseInt(request.getParameter("level")));
		Factory.getInstance().getUserHAO().updateUser(user);
		return;
	}
	
	public static void showBooksUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		List<TakedBook> book= Factory.getInstance().getTakedBookHAO().getTakedBooksByIserId(Integer.parseInt(request.getParameter("id")));
		Iterator it=book.iterator();
		String str="";
		while (it.hasNext()){
			TakedBook meow = (TakedBook) it.next();
			Book name = Factory.getInstance().getBookHAO().getBooktById(meow.getIdBook());		
			str+=name.getName()+"   "+meow.getTimeStamp().toGMTString()+"   "+ Functions.daysUntilToday(meow.getTimeStamp())+"_-_";
		}
		if (str.length()!=0)
			str=str.substring(0, str.length()-3);
		response.getWriter().write(str);
		return;
	}
}
	

