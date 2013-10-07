package servlet;

import java.io.IOException;

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
							"/home/g33k/c0d3/Java/GIT/number2/mumber2/jaas.config");
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
			RoutingMap.routeToReqPage(request.getServletPath(), request,
					response);
		} catch (NullPointerException ex) {
			MapHandlers.index(request, response);
		}
	}
}
