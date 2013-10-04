package servlet;

import hibernateAccesObject.Factory;
import hibernateMappingClass.Book;
import hibernateMappingClass.Image;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// получение двумерного массива, где
		// [i][0] - имя книги
		// [i][j] - пути картинок для книг
		String books_pathArray[][] = new String[books.size()][];

		for (int i = 0; i < books.size(); i++) {
			books_pathArray[i] = new String[books.get(i).getImages().size() + 1];
			books_pathArray[i][0] = books.get(i).getName();

			Iterator it = books.get(i).getImages().iterator();
			int j = 1;
			while (it.hasNext()) {
				Image image = (Image) it.next();
				books_pathArray[i][j] = image.getPath();
				j++;
			}
		}
		
		//request.setAttribute("books_pathArray", books_pathArray);
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
