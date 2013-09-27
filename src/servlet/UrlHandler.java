package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * интерфейс используется для создания анонимного класса в Helper.mapFill
 */

public interface UrlHandler {
	void get_handler(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NullPointerException;
}
