package servlet;

import java.util.Map;

public class Helper{
	public static void mapFill(Map routing){
		routing.put("admin", "/WEB-INF/templates/admin.jsp");
		routing.put("index", "/WEB-INF/templates/index.jsp");
		routing.put("books", "/WEB-INF/templates/books.jsp");
		routing.put("register", "/WEB-INF/templates/register.jsp");
		routing.put("cabinet", "/WEB-INF/templates/cabinet.jsp");
	}
}