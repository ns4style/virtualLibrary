<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page import="hibernateMappingClass.Book"%>
<%@ page import="hibernateMappingClass.Image"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript" src="../bootstrap/js/jquery.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.css" />
</head>
<body>


	<%
		List<Book> books = null;
		books = (List)request.getAttribute("books");
		int i = 1;
		Iterator it = books.iterator();
		while(it.hasNext()) {
			
			Book book = (Book)it.next();
			System.out.println(book.getName() + " ");
			
			int j = 0;
			Iterator it_inner = book.getImages().iterator();
			
			while(it_inner.hasNext()) {
				
				String item = "item";
				if (j == 0) item = "active_item";
				System.out.print(" " + item + " ");
				
				Image image = (Image)it_inner.next();
				System.out.print(image.getPath() + " ");
				
				j++;
			}
			System.out.println("");
			i++;
		}
	%>

	<script type="text/javascript">
		$('div[class^=carousel]').carousel()
	</script>
</body>
</html>
