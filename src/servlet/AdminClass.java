package servlet;


import hibernateAccesObject.Factory;
import hibernateMappingClass.Genre;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminClass {
	
	public static void showListGenres(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Writer wr=response.getWriter();
		String str="";
		List<Genre> genres = Factory.getInstance().getGenreHAO().getAllGenres();
		for (ListIterator<Genre> i=genres.listIterator(); i.hasNext();){
		str+=i.next().getValue()+" ";
		}
		str=str.substring(0, str.length()-1);
		wr.write(str);
		wr.close();
		return;
	}

}
