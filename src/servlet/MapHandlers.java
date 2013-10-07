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
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request
				.getRequestDispatcher("/templates/admin.jsp");
		rd.forward(request, response);
	}

	public static void index(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		RequestDispatcher rd = request
				.getRequestDispatcher("/templates/index.jsp");
		rd.forward(request, response);
	}

	public static void books(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Получение списка книг из базы
		List<Book> books = null;
		try {
			books = Factory.getInstance().getBookHAO().getAllBooks();
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
