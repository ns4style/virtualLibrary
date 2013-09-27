package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Реализация обработчиков запросов, имена методов соответствуют
 * запрашиваемой странице
 */

public class map_handlers {
	
	public static void admin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/admin.jsp");
		rd.forward(request, response);
	}
	
	public static void index(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/index.jsp");
		rd.forward(request, response);	
	}
	
	public static void books(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/books.jsp");
		rd.forward(request, response);
	}
	
	public static void register(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/register.jsp");
		rd.forward(request, response);
	}
	
	public static void cabinet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/cabinet.jsp");
		rd.forward(request, response);
	}
}
