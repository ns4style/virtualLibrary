package servlet;

import hibernateAccesObject.Factory;
import hibernateMappingClass.Book;

import java.io.IOException;
import java.sql.SQLException;
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
		
		// Получение рандомных книг для слайдера
		List<Book> books = null;
		try {
			books = Factory.getInstance().getBookHAO().getRandomBooks(11);
			System.out.print(Factory.getInstance().getBookHAO().getBooksCount());
		} catch (SQLException e) {
			// TODO Auto-generated catch blockS
			e.printStackTrace();
		}

		request.setAttribute("books", books);
		RequestDispatcher rd = request
				.getRequestDispatcher("/templates/books.jsp");
		rd.forward(request, response);
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
