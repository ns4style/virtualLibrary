<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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


	<div id="myCarousel1" class="carousel slide"
		style="width: 400px; margin: 0 auto">
		<div class="carousel-inner">
			<div class="item active">
				<img src="../images/games_1.jpg" alt="">
				<div class="carousel-caption">
					<h4>Голодные Игры</h4>
					<p>Текст или описание слайда</p>
				</div>
			</div>
			<div class="item">
				<img src="../images/games_2.jpg" alt="">
				<div class="carousel-caption">
					<h4>Голодные Игры</h4>
					<p>Текст или описание слайда 2</p>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel1" data-slide="prev">&lsaquo;</a>
		<a class="right carousel-control" href="#myCarousel1"
			data-slide="next">&rsaquo;</a>
	</div>

	<div id="myCarousel2" class="carousel slide"
		style="width: 400px; margin: 0 auto">
		<div class="carousel-inner">
			<div class="item active">
				<img src="../images/games_1.jpg" alt="">
				<div class="carousel-caption">
					<h4>Голодные Игры</h4>
					<p>Текст или описание слайда</p>
				</div>
			</div>
			<div class="item">
				<img src="../images/games_2.jpg" alt="">
				<div class="carousel-caption">
					<h4>Голодные Игры</h4>
					<p>Текст или описание слайда 2</p>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel2" data-slide="prev">&lsaquo;</a>
		<a class="right carousel-control" href="#myCarousel2"
			data-slide="next">&rsaquo;</a>
	</div>

	<script type="text/javascript">
		$('.carousel').carousel()
	</script>
</body>
</html>
