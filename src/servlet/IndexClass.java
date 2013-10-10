package servlet;

import hibernateAccesObject.Factory;
import hibernateMappingClass.News;
import hibernateMappingClass.User;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexClass {
	
	public static void init(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		List<News> newsList = Factory.getInstance().getNewsHAO().getAllNews();
		Collections.reverse(newsList);
		request.setAttribute("news", newsList);
	}
	
	public static void Registration(HttpServletRequest request, HttpServletResponse response) throws IOException{
		final Pattern email = Pattern.compile("^[A-Za-z0-9.%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}+$");
		final Pattern onlyLetters = Pattern.compile("^[_a-zA-Z0-9]+$");
		
		Matcher matcher = email.matcher(request.getParameter("email"));
		if (!matcher.find()){
			return;
		}
		
		matcher = onlyLetters.matcher(request.getParameter("fname"));
		if (!matcher.find()){
			return;
		}
		
		matcher = onlyLetters.matcher(request.getParameter("lname"));
		if (!matcher.find()){
			return;
		}
		
		matcher = onlyLetters.matcher(request.getParameter("pass"));
		if (!matcher.find()){
			return;
		}
		
		matcher = onlyLetters.matcher(request.getParameter("descr"));
		if (!matcher.find()){
			return;
		}
		
		User checkUser=Factory.getInstance().getUserHAO().getUserByMail(request.getParameter("email"));
		if (checkUser != null)
			return;
		
		User newUser = new User();
		newUser.setMail(request.getParameter("email"));
		newUser.setFname(request.getParameter("fname"));
		newUser.setLname(request.getParameter("lname"));
		newUser.setHashPass(request.getParameter("pass"));
		newUser.setDescription(request.getParameter("descr"));
		Factory.getInstance().getUserHAO().addUser(newUser);
		
		Writer wr=response.getWriter();
		wr.write("true");
		wr.close();
		return;
	}
	
	public static void preRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException{
		final Pattern email = Pattern.compile("^[A-Za-z0-9.%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}+$");
		Matcher matcher = email.matcher(request.getParameter("email"));
		if (!matcher.find()){
			return;
		}
		User newUser=Factory.getInstance().getUserHAO().getUserByMail(request.getParameter("email"));
		Writer wr=response.getWriter();
		if (newUser != null) {
			wr.write("true");
			wr.close();
		}
		
	}
	
	public static void aboutUsers(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Writer wr = response.getWriter();
		wr.write(Factory.getInstance().getUserHAO().countUsers().toString());
		wr.close();
		return;
	}
	
	public static void aboutBooks(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Writer wr = response.getWriter();
		wr.write(Factory.getInstance().getBookHAO().countBooks().toString());
		wr.close();
		return;
	}
}
