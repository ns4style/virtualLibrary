package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Library_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Library_servlet() {
		super();
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Map routing=new HashMap <String,String>();
		Helper.mapFill(routing);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
