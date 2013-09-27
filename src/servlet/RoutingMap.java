package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoutingMap {
	
		private static Map<String, UrlHandler> routing;
		
		static {
			
			routing = new HashMap <String, UrlHandler>();
			Helper.mapFill(routing);
		}
		
		public static void routeToReqPage(String reqPage, HttpServletRequest request, HttpServletResponse response)
				throws NullPointerException, IOException, ServletException {
			
			routing.get(reqPage).get_handler(request, response);
		}
}
