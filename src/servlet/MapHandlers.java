package servlet;

import hibernateAccesObject.Factory;
import hibernateMappingClass.Author;
import hibernateMappingClass.Book;
import hibernateMappingClass.Comment;
import hibernateMappingClass.Image;
import hibernateMappingClass.Tag;
import hibernateMappingClass.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Реализация обработчиков запросов, имена методов соответствуют запрашиваемой странице.
 * вызов метода происходит из класса RountingMap при обращении к объекту типа Map
 * из Map выбирается нужный обработчик в зависимости от параметра request.getServletPath()
 */

public class MapHandlers {

	public static void admin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		Map parameters = request.getParameterMap();
		//GENRES
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("showListGenres")) {
				AdminClass.showListGenres(request, response);
				return;
			}
		}
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("editGenre")) {
				AdminClass.editListGenre(request, response);
				return;
			}
		}
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("deleteGenre")) {
				AdminClass.deleteGenre(request, response);
				return;
			}
		}
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("addGenre")) {
				AdminClass.addGenre(request, response);
				return;
			}
		}
		//TAGS
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("showListTags")) {
				AdminClass.showListTags(request, response);
				return;
			}
		}
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("addTag")) {
				AdminClass.addTag(request, response);
				return;
			}
		}
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("deleteTag")) {
				AdminClass.deleteTag(request, response);
				return;
			}
		}
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("editTag")) {
				AdminClass.editListTags(request, response);
				return;
			}
		}
		
		//AUTHORS
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("showListAuthorsModal")) {
				AdminClass.showListAuthors(request, response);
				return;
			}
		}
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("addAuthorsModal")) {
				AdminClass.addAuthor(request, response);
				return;
			}
		}
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("deleteAuthorsModal")) {
				AdminClass.deleteAuthor(request, response);
				return;
			}
		}
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("editAuthorsModal")) {
				AdminClass.editListAuthors(request, response);
				return;
			}
		}
		//NEWS
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("showListNews")) {
				AdminClass.showListNews(request, response);
				return;
			}
		}
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("addNews")) {
				AdminClass.addNews(request, response);
				return;
			}
		}
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("deleteNews")) {
				AdminClass.deleteNews(request, response);
				return;
			}
		}
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("editNews")) {
				AdminClass.editListNews(request, response);
				return;
			}
		}
		
		//BOOOKS
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("showListBooks")) {
				AdminClass.showListBooks(request, response);
				return;
			}
		}
		
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("listAttrofBook")) {
				AdminClass.listAttrsofBook(request, response);
				return;
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/templates/admin.jsp");
		rd.forward(request, response);
	}

	public static void index(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		IndexClass.init(request, response);
		Map parameters = request.getParameterMap();
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("reg")) {
				IndexClass.Registration(request, response);
				return;
			}
		}
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("prereg")) {
				IndexClass.preRegistration(request, response);
				return;
			}
		}
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("aboutUsers")) {
				IndexClass.aboutUsers(request, response);
				return;
			}
		}
		if (parameters.containsKey("action")) {
			if (request.getParameter("action").equals("aboutBooks")) {
				IndexClass.aboutBooks(request, response);
				return;
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/templates/index.jsp");
		rd.forward(request, response);
	}

	public static void books(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int booksOnPage = 5;
		
		List<Book> pageBooks = null;
		
		//  ---------------------------------------------- Определение страницы -------------------------------------------------------------- //
		
		if (request.getParameter("page") != null) { // -- Выбрана какая-то страница ----------------------------------------------------------//
			if (request.getParameter("adp").contains(request.getParameter("page")))
				return; // если такая страница уже запрашивалась

			try {
				pageBooks = Factory.getInstance().getBookHAO().getBooksSelection(Integer.parseInt(request.getParameter("page"))*booksOnPage , booksOnPage );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StringBuffer stringBuffer = new StringBuffer("");
			stringBuffer.append(request.getParameter("page") + ";");
			
			for (int i=0; i<pageBooks.size(); i++) {
				stringBuffer.append(pageBooks.get(i).getName() + ":" + pageBooks.get(i).getId() + ":");
				
				Iterator iterator = pageBooks.get(i).getImages().iterator();
				if (iterator.hasNext()) {
					Image image = (Image) iterator.next();
					stringBuffer.append(image.getPath());
				}
				stringBuffer.append(";");
			}
			
			response.getWriter().write(stringBuffer.toString());
			return;
		}
		else if (request.getParameter("id_book") != null) { // ------------------- получение данных о конкретной книге ---------------- //
			int id = Integer.parseInt(request.getParameter("id_book"));
			Book book = null;
			
			try {
				book = Factory.getInstance().getBookHAO().getBooktById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (book == null)
				return;
			
			StringBuffer stringBuffer = new StringBuffer(""); 
			stringBuffer.append(book.getName() + ";"); // name ;
			
			Iterator  iterator = book.getAuthors().iterator();
			while (iterator.hasNext()) {
				Author author = (Author) iterator.next();
				stringBuffer.append(author.getFirstName() + " " + author.getLastName() + ",");
			}
			stringBuffer.append(";"); // name ; author_1, ..... ;
			
			iterator = book.getImages().iterator();
			while (iterator.hasNext()) {
				Image image = (Image) iterator.next();
				stringBuffer.append(image.getPath() + ",");
			}
			stringBuffer.append(";"); // name ; author_1, ..... ; img_1, ....... ,; -- лишняя ,
			
			iterator = book.getTags().iterator();
			while (iterator.hasNext()) {
				Tag tag = (Tag) iterator.next();
				stringBuffer.append(tag.getValue() + ",");
			}
			stringBuffer.append(";"); // name ; author_1, ..... ; img_1, ..... ; tag_1, ..... ,;
			
			List<Comment> comments = null;
			try {
				comments = Factory.getInstance().getCommentHAO().getCommentsByBookId(book.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (int i=0; i<comments.size(); i++) {
				stringBuffer.append(comments.get(i).getId() + ":" + comments.get(i).getUser().getFname() + " " + comments.get(i).getUser().getLname() +
						":" + comments.get(i).getValue() + "_-_");
			}
			stringBuffer.append(";"); // name ; author_1, ..... ; img_1, .., .. ; tag_1, ..... ,; id:fullUserName:comment_-_ .......... ,;
			stringBuffer.append(book.getId() + ";"); // name ; author_1, ..... ; img_1, .., .. ; tag_1, ..... ,; id:fullUserName:comment_-_ .......... ,; id;
			stringBuffer.append(book.getCount() + ";"); // name ; author_1, ..... ; img_1, .., .. ; tag_1, ..... ,; id:fullUserName:comment_-_ .......... ,; id; count;
			
			response.getWriter().write(stringBuffer.toString());
			return;
		}
		else if (request.getParameter("add_new_comment") != null) { // ------- добавление комментария ----------- //
			String s = request.getParameter("add_new_comment");
			if(s.split("_-_")[2] == "")
				return;
			Comment comment = new Comment();
			comment.setIdBook(Integer.parseInt(s.split("_-_")[0]));
			try {
				comment.setUser(Factory.getInstance().getUserHAO().getUserById(Integer.parseInt(s.split("_-_")[1])));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			comment.setValue(s.split("_-_")[2]);
			Factory.getInstance().getCommentHAO().addComment(comment);
			response.getWriter().write(String.valueOf(comment.getId()));
			return;			
		}
		else if (request.getParameter("delete_comment") != null) { // ----------- удаление комментария ------------ //
			int id = Integer.parseInt(request.getParameter("delete_comment"));
			try {
				Factory.getInstance().getCommentHAO().deleteComment(Factory.getInstance().getCommentHAO().getCommentById(id));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write(String.valueOf(id));
			return;
		}
		else { // ---------------------------------------------- Первая загрузка ------------------------------- //
			User user = null;
			if (request.getUserPrincipal() != null) {
				user = Factory.getInstance().getUserHAO().getUserByMail(request.getUserPrincipal().getName());
			}
			if (user != null) {
				request.setAttribute("user_id", user.getId());
				request.setAttribute("user_name", user.getFname() + " " + user.getLname());
				request.setAttribute("user_privileged", user.getPrivileged());
			}
			else { // 0 - admin, 1 - user, 2 - blocked user, 3 - unknow;
				request.setAttribute("user_name", "unknown");
				request.setAttribute("user_privileged", "3");				
			}
			
			List<Book> books = null;
			Double pageCount = 0.0;
			try {
				books = Factory.getInstance().getBookHAO().getRandomBooks(11);
				pageCount = Math.ceil((double) Factory.getInstance().getBookHAO().getBooksCount() / booksOnPage);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("books", books);
			request.setAttribute("pageCount", pageCount.intValue());

			RequestDispatcher rd = request
					.getRequestDispatcher("/templates/books.jsp");
			rd.forward(request, response);
		}
	}

	public static void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request
				.getRequestDispatcher("/templates/register.jsp");
		rd.forward(request, response);
	}

	public static void cabinet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request
				.getRequestDispatcher("/templates/cabinet.jsp");
		rd.forward(request, response);
	}

	public static void signin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().println(
				"User name : " + request.getParameter("usr_name")
						+ " with password " + request.getParameter("usr_pass"));
	}
}
