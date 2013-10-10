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
<script type="text/javascript"
	src="../bootstrap/js/jcarousellite_1.0.1.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jcarousellite_1.0.1.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.css" />
</head>
<body>
	<script type="text/javascript">
		var div = document.createElement('div');
		div.setAttribute('class', 'mycarousel');

		var ul = document.createElement('ul');
		div.appendChild(ul);

		document.body.appendChild(div);
	</script>

	<c:forEach var="book" items="${books}" varStatus="i_book">

		<script type="text/javascript">
			var array = new Array();
		</script>

		<c:forEach var="image" items="${book.getImages()}">
			<script type="text/javascript">
				array.push("${image.getPath()}");
			</script>
		</c:forEach>

		<script type="text/javascript">
			var li = document.createElement('li');

			var carousel = document.createElement('div');
			carousel.setAttribute('class', 'carousel slide');
			carousel.setAttribute('id', 'myCarousel${i_book.index}');

			carousel.innerHTML = ' \
			<div class="carousel-inner"> \
				<div class="active item"> \
					<img src="' + array[0] + '"> \
					\
					<div class="carousel-caption"> \
						<h4>${book.getName()}</h4> \
					</div> \
				</div> \
				\
				<div class="item"> \
					<img src="' + array[1] +'"> \
					\
					<div class="carousel-caption"> \
						<h4>${book.getName()}</h4> \
					</div> \
				</div> \
				\
				<div class="item"> \
					<img src="' + array[2] +'"> \
					\
					<div class="carousel-caption"> \
						<h4>${book.getName()}</h4> \
					</div> \
				</div> \
			</div>';

			li.appendChild(carousel);
			ul.appendChild(li);
		</script>

	</c:forEach>

	<script type="text/javascript">
		$('.carousel').each(function() {
			$(this).carousel({
				interval : Math.random() * 8000 + 4000
			});
		});
		$(function() {
			$(".mycarousel").jCarouselLite({
				auto : 3000,
				speed : 1000,
				circular : true,
				visible : 4
			});
		});
	</script>
</body>
</html>
