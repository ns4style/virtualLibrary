package servlet;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LibraryServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		System.setProperty("java.security.auth.login.config", 
							"C:/Users/Admin/workspace/virtualLibrary/jaas.config");
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * RoutingMap по умолчанию инициализируется при помощи метода
		 * Helper.mapFill routeToReqPage вызывает обработчик для запрашиваемой
		 * страницы, если таковой существует (все определения обработчиков
		 * находятся в MapHandlers)
		 */
		
		try {
			try {
				RoutingMap.routeToReqPage(request.getServletPath(), request,
						response);
			} catch (SQLException e) {
				Writer wr=response.getWriter();
				wr.write("Error");
				wr.close();
				System.out.println(e.getStackTrace());
			}
		} catch (NullPointerException ex) {
				//MapHandlers.index(request, response);
		}
	}
}
