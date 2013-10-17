<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/jquery-reg.js"></script>
<script src="bootstrap/js/md5.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library</title>
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
	background-image: url("images/background3.jpg");
}

.wrap {
	padding-top: 120px;
	padding-bottom: 120px;
}

.footer {
	height: 100px;
	margin-top: -100px;
	background-color: #c8c8c8;
}

</style>
	<div class="page">
		<div class="wrap" id="wrap">
			<div class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-inner">
					<div class="container">
						<a class="btn btn-navbar" data-toggle="collapse"
							data-target=".nav-collapse"> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
						</a> <a class="brand" href="index">Home</a>
						<div class="nav-collapse collapse">
							<ul class="nav">
								<li><a href="/Library/books/">Books</a></li>
								<li><a data-target="#authors" data-toggle="modal" href="">Authors</a></li>
								<li><a data-target="#about" data-toggle="modal" href="">About</a></li>
							</ul>
							<form class="navbar-form pull-right">
								<input class="span2" type="text" placeholder="Email"> <input
									class="span2" type="password" placeholder="Password">
								<button type="submit" class="btn">Login</button>
								<button data-target="#register" data-toggle="modal"
									type="submit" class="btn">Register</button>
							</form>
						</div>
					</div>
				</div>
			</div>

			<div id="register" class="modal hide fade">
				<div class="modal-header">
					<h2>Registration</h2>
				</div>
				<div class="modal-body">
					<div>
						<input name="action" class="span2 hide" type="text" value="reg">
					</div>
					<div id="email">
						<div>
							<p>Enter your Email:</p>
						</div>
						<input name="email" class="span2" type="text" placeholder="Email">
					</div>
					<div id="fname">
						<div>
							<p>Enter your first name:</p>
						</div>
						<input name="fname" class="span2" type="text" placeholder="">
					</div>
					<div id="lname">
						<div>
							<p>Enter your second name:</p>
						</div>
						<input name="lname" class="span2" type="text" placeholder="">
					</div>
					<div id="pass">
						<div>
							<p>Enter your password:</p>
						</div>
						<input name="pass" class="span2" type="password"
							placeholder="Password">
					</div>
					<div id="descr">
						<div>
							<p>Enter something about yourself:</p>
						</div>
						<input name="descr" class="span2" type="text" placeholder="">
					</div>
					<button data-dismiss="modal" aria-hidden="true"
						class="btn btn-warning">Back</button>
					<button name="reg" class="btn btn-success">Register</button>
				</div>
			</div>

			<div id="about" class="modal hide fade text-center">
				<div class="modal-header">
					<h2>About library:</h2>
				</div>
				<div id="about-body" class="modal-body"></div>
			</div>
			
			<div id="authors" class="modal hide fade text-center">
				<div class="modal-header">
					<h2>Authors:</h2>
				</div>
				<div id="authors-body" class="modal-body">
				<div><h4>Artem Bryukhanov</h4></div>
				<div><h4>Dmitrii Kravchenko</h4></div>
				<div><h4>Nikita Tretyakov</h4></div>
				<div><button data-dismiss="modal" aria-hidden="true" class="btn btn-success">Back</button></div>
				</div>
			</div>

			<div id="regComplete" class="modal hide fade">
				<div class="modal-header">
					<h2>Status</h2>
				</div>
				<div class="modal-body">Registration Complete.</div>
			</div>

			<div id="regFailed" class="modal hide fade">
				<div class="modal-header">
					<h2>Status</h2>
				</div>
				<div class="modal-body">Registration Failed.</div>
			</div>

			<div class="text-center">
				<h1>News:</h1>
				<c:forEach var="oneNews" items="${news}">
					<h1>${oneNews.getNews()}</h1>
				</c:forEach>

			</div>
		</div>

	</div>

	<div class="footer">
		<h3 class="pull-right">Copyright(c)</h3>
	</div>
</body>
</html>