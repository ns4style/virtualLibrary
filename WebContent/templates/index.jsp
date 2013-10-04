<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>

html, body {
    height: 100%;
    width: 100%;
    margin: 0px;
    padding: 0px;
    text-align: center;
  }
  .page {
    min-height: 100%;
    height: auto !important;
    height: 100%;
     background-color: #9d261d
  }
  .wrap {
    padding-top :120px;
    padding-bottom: 120px;
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
<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</a>
<a class="brand">Home</a>
<div class="nav-collapse collapse">
<ul class="nav">
<li><a href="/Library/books">Books</a></li>
<li><a href="">Authors</a></li>
<li><a href="">About</a></li>
</ul>
<% if (request.getAttribute("regSuccesfull").equals("yes")) { %>
	<p class="navbar-text pull-right">
	Logged in as ${username}
	</p>
<% } else { %>
	 <form class="navbar-form pull-right">
	<input class="span2" type="text" placeholder="Email">
	<input class="span2" type="password" placeholder="Password">
	<button type="submit" class="btn">Login</button>
	<button data-target="#register" data-toggle="modal" type="submit" class="btn">Register</button>
	</form>
<% } %>
</div> 
</div>
</div>
</div>

<div id="register" class="modal hide fade">
	<div class="modal-header">
		<h2>Registration</h2>
	</div>
	<div class="modal-body">
		<form action=index method=post>
		<div>
			<input name="action" class="span2 hide" type="text" value="reg">
		</div>
		<div>
			<div><p> Enter your Email:</p></div>
			<input name="email" class="span2" type="text" placeholder="Email">
		</div>
		<div>
			<div><p> Enter your first name:</p></div>
			<input name="fname" class="span2" type="text" placeholder="">
		</div>
		<div>
			<div><p> Enter your second name:</p></div>
			<input name="lname" class="span2" type="text" placeholder="">
		</div>
		<div>
			<div><p> Enter your password:</p></div>
			<input name="pass" class="span2" type="password" placeholder="Password">
		</div>
		<div>
			<div><p> Enter something about yourself:</p></div>
			<input name="description" class="span2" type="text" placeholder="">
		</div>
		<button data-dismiss="modal" aria-hidden="true" class="btn btn-warning">Back</button>
		<button type="submit" class="btn btn-success">Register</button>
		</form>
	</div>
</div>

<h1>News:</h1>
</div>

</div>

<div class="footer">
<h3 class="pull-right">Copyright(c)</h3>
</div>
</body>
</html>