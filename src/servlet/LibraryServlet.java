package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LibraryServlet() {
		super();
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