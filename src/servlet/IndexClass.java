package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexClass {
	
	public static void init(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("regSuccesfull", "no");
	}
	
	public static void Registration(HttpServletRequest request, HttpServletResponse response){
		Map parameters=request.getParameterMap();
		
	}
}
