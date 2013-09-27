package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Реализация обработчиков запросов, имена методов соответствуют
 * запрашиваемой странице
 */

public class map_handlers {
	
	public static void admin(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.println("<H1>Admin page</H1>");
		} catch (IOException ex) {
			System.err.println("Error in admin page! " + ex.getMessage());
		}
	}
	
	public static void index(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.println("<H1>Index page</H1>");
		} catch (IOException ex) {
			System.err.println("Error in admin page! " + ex.getMessage());
		}
	}
	
	public static void books(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.println("<H1>Books page</H1>");
		} catch (IOException ex) {
			System.err.println("Error in admin page! " + ex.getMessage());
		}
	}
	
	public static void register(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.println("<H1>Register page</H1>");
		} catch (IOException ex) {
			System.err.println("Error in admin page! " + ex.getMessage());
		}
	}
	
	public static void cabinet(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			pw.println("<H1>Cabinet page</H1>");
		} catch (IOException ex) {
			System.err.println("Error in admin page! " + ex.getMessage());
		}
	}
}
