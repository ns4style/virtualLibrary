<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="hibernateMappingClass.Book"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Books</title>

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

	<style>
html,body {
	height: 100%;
	width: 100%;
	margin: 0px;
	padding: 0px;
}

.page {
	min-height: 100%;
	height: auto !important;
	height: 100%;
	background-color: #9d261d;
	background-image: url("../images/background3.jpg");
}

.wrap {
	padding-top: 40px;
	padding-bottom: 120px;
}

.footer {
	height: 100px;
	margin-top: -100px;
	background-color: #c8c8c8;
}

.carousel-caption {
	position: absolute;
	left: 0;
	right: 0;
	bottom: 0;
	padding: 0px;
	background: #333333;
	background: rgba(0, 0, 0, 0.75);
}

.carousel-caption h4 {
	font-family: Helvetica, sans-serif;
	font-size: 11px;
	text-align: center;
}

.mycarousel {
	margin-top: 20px;
	margin-bottom: 20px; margin-left : auto;
	margin-right: auto;
	margin-left: auto;
}

.img-polaroid {
	padding: 4px;
	background-color: #000;
	border: 1px solid #000;
	border: 1px solid rgba(0, 0, 0, 0.2);
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}
;
</style>

	<div class="page">
		<div class="wrap" id="wrap">
			<div class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-inner">
					<div class="container">
						<a class="btn btn-navbar" data-toggle="collapse"
							data-target=".nav-collapse"> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
						</a> <a class="brand">Home</a>
						<div class="nav-collapse collapse">
							<ul class="nav">
								<li><a href="/Library/books">Books</a></li>
								<li><a href="">Authors</a></li>
								<li><a href="">About</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- carousel -->
		</div>
	</div>

	<script type="text/javascript">
		var div = document.createElement('div');
		div.setAttribute('class', 'mycarousel');

		var ul = document.createElement('ul');
		div.appendChild(ul);

		$("#wrap").append(div);

		var test = document.getElementById('test');
		test.insertAdjacentElement("afterEnd", div);

		var test1 = document.getElementById('test1');
		alert(test1.innerHTML);
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
                                            <img src="' + array[0] + '" width="110" height="70" class="img-polaroid"> \
                                            \
                                            <div class="carousel-caption"> \
                                                    <h4>${book.getName()}</h4> \
                                            </div> \
                                    </div> \
                                    \
                                    <div class="item"> \
                                            <img src="' + array[1] +'" width="110" height="70" class="img-polaroid"> \
                                            \
                                            <div class="carousel-caption"> \
                                                    <h4>${book.getName()}</h4> \
                                            </div> \
                                    </div> \
                                    \
                                    <div class="item"> \
                                            <img src="' + array[2] +'" width="110" height="70" class="img-polaroid"> \
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
				visible : 7
			});
		});
		
		
	</script>
	
	
	
</body>
</html>

