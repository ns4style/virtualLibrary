<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="hibernateMappingClass.Book"%>
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


	<c:forEach var="book" items="${books}">
		<script type="text/javascript">
			var array = new Array();
		</script>
		<c:forEach var="image" items="${book.getImages()}">
			<script type="text/javascript">
				array.push("${image.getPath()}");
			</script>
		</c:forEach>

		<script type="text/javascript">
			var carousel = document.createElement('div');
			carousel.setAttribute('class', 'carousel');
			carousel.setAttribute('id', 'myCarousel');

			var str = "../images/dorian_1.jpg";

			carousel.innerHTML = '\
					<div class="carousel-inner"> \
    				<div class="active item"><img src="' + array[0] +'"></div> \
    				<div class="item"><img src="' + array[1] + '"></div> \
    				<div class="item"><img src="../images/dorian_3.jpg"></div> \
  					</div> \
  					\
  					<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a> \
  					<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>';
  			document.body.appendChild(carousel);
		</script>


	</c:forEach>
	
	<script type="text/javascript">
		$('.carousel').carousel();
	</script>
</body>
</html>
