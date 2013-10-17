package servlet;

import hibernateAccesObject.BookHAO;
import hibernateAccesObject.Factory;
import hibernateMappingClass.Book;
import hibernateMappingClass.Image;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
		else if (request.getParameter("book") != null) { // ------------------- получение данных о конкретной книге ---------------- //
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
			
			StringBuffer stringBuffer = new StringBuffer(""); // name ; img_1 : ..... ; 
			stringBuffer.append(book.getName() + ";");
			
			Iterator iterator = book.getImages().iterator();
			if (iterator.hasNext()) {
				Image image = (Image) iterator.next();
				stringBuffer.append(image.getPath() + ":");
			}	
			
			
		}
		else { // ---------------------------------------------- Первая загрузка ------------------------------- //
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
