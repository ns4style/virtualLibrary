<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/jquery-reg.js"></script>
<script src="bootstrap/js/admin.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin of Library</title>
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

.middle {
	padding-top:30px;
}

.dropdown-menu li:hover {
	background: #66CCCC;
}

.footer {
	height: 100px;
	margin-top: -100px;
	background-color: #c8c8c8;
};
</style>
	<div class="page">
		<div class="wrap">
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
						</div>
					</div>
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
				<div id="about-body" class="modal-body">
					<div>
						<h4>Artem Bryukhanov</h4>
					</div>
					<div>
						<h4>Dmitrii Kravchenko</h4>
					</div>
					<div>
						<h4>Nikita Tretyakov</h4>
					</div>
					<div>
						<button data-dismiss="modal" aria-hidden="true"
							class="btn btn-success">Back</button>
					</div>
				</div>
			</div>
			<div class="text-center"><h1>Admin panel</h1></div>
			<div class="middle text-center">
			<div>
			<h3>Edit list of genres</h3>
			<a data-target="#genres" data-toggle="modal" href="" class="btn">Edit genres</a>
			<div id="genres" class="modal hide fade text-center">
				<div class="modal-header">
					<h2>List of Genres:</h2>
				</div>
				<div id="genres-body" class="modal-body"></div>
			</div>
			</div>
			<div>
			<h3>Edit list of tags</h3>
			<a data-target="#tags" data-toggle="modal" href="" class="btn">Edit tags</a>
			<div id="tags" class="modal hide fade text-center">
				<div class="modal-header">
					<h2>List of Tags:</h2>
				</div>
				<div id="tags-body" class="modal-body"></div>
			</div>
			</div>
			<div>
			<h3>Edit list of Authors</h3>
			<a data-target="#authorsModal" data-toggle="modal" href="" class="btn">Edit Authors</a>
			<div id="authorsModal" class="modal hide fade text-center">
				<div class="modal-header">
					<h2>List of Authors:</h2>
				</div>
				<div id="authorsModal-body" class="modal-body"></div>
			</div>
			</div>
			<div>
			<h3>Edit list of News</h3>
			<a data-target="#news" data-toggle="modal" href="" class="btn">Edit News</a>
			<div id="news" class="modal hide fade text-center">
				<div class="modal-header">
					<h2>List of News:</h2>
				</div>
				<div id="news-body" class="modal-body"></div>
			</div>
			</div>
			<div>
			<h3>Edit list of Books</h3>
			<a data-target="#books" data-toggle="modal" href="" class="btn">Edit Books</a>
			<div id="books" class="modal hide fade text-center">
				<div class="modal-header">
					<h2>List of Books:</h2>
				</div>
				<div id="books-body" class="modal-body"></div>
			</div>
			</div>
			<div>
			<div id="bookEditDetail" class="modal hide fade text-center">
				<div class="modal-header" id="bookEditDetail-header">
				</div>
				<div id="bookEditDetail-body" class="modal-body pull-left text-left span5">
				</div>
			</div>
			</div>
			</div>
			
		</div>
	</div>

</body>
</html>