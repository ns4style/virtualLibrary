package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Данный класс создан для формирования Map'ы вызовов функции в зависимости от запрашиваемой страницы
 * для каждой определенной страницы создается анонимный класс, реализующий интерфейс UrlHandler
 * в нем определяется функция get_handler, работа этой функции заключается в вызове правильного 
 * обработчика для указанной страницы
 */

public class Helper{
	public static void mapFill(Map routing){
		
		routing.put("/admin", new UrlHandler() {
								public void get_handler(HttpServletRequest request, HttpServletResponse response) 
										throws IOException, ServletException, NullPointerException, SQLException {
									MapHandlers.admin(request, response);
								}
							}
					);
		
		routing.put("/", new UrlHandler() {
								public void get_handler(HttpServletRequest request, HttpServletResponse response) 
										throws IOException, ServletException, NullPointerException, SQLException {
									MapHandlers.index(request, response);
								}
							} 
					);
		
		routing.put("/index", new UrlHandler() {
								public void get_handler(HttpServletRequest request, HttpServletResponse response) 
										throws IOException, ServletException, NullPointerException, SQLException {
									MapHandlers.index(request, response);
								}
							}
					);
		
		routing.put("/books", new UrlHandler() {
								public void get_handler(HttpServletRequest request, HttpServletResponse response) 
										throws IOException, ServletException, NullPointerException {
									MapHandlers.books(request, response);
								}
							}
					);
		
		routing.put("/cabinet", new UrlHandler() {
								public void get_handler(HttpServletRequest request, HttpServletResponse response) 
										throws IOException, ServletException, NullPointerException {
									MapHandlers.cabinet(request, response);
								}
							}
					);
		

		routing.put("/signin", new UrlHandler() {
								public void get_handler(HttpServletRequest request, HttpServletResponse response) 
										throws IOException, ServletException, NullPointerException {
									MapHandlers.signin(request, response);
								}
							}
					);
		
		routing.put("/j_security_check", new UrlHandler() {
			public void get_handler(HttpServletRequest request, HttpServletResponse response) 
					throws IOException, ServletException, NullPointerException {
				MapHandlers.check(request, response);
			}
		}
);
		
	}
	
}