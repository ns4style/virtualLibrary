<%@page import="javax.net.ssl.SSLEngineResult.Status"%>
<%@page import="org.omg.CORBA.Current"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://localhost/functions" prefix="f"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Cabinet</title>

<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/jquery-reg.js"></script>


<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css" />

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
	background-image: url("images/background4.jpg");
	background-attachment: fixed
}

.wrap {
	padding-top: 40px;
	padding-bottom: 120px;
}

.warning {
	color: #FF0000;
}

table,th,td {
	border-style: solid;
	border-width: 1px;
	border-collapse: collapse;
	padding: 2px;
}

th {
	height: 28px;
	background-color: #f892dc;
	color: white;
	border-color: black;
}

h1,h3 {
	color: #FFFFFF;
}

.bookTable {
	background-color: #ffeffb;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}
.user_login_text {
	padding-top: 10px;
	color: #FFFFFF;
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
						</a> <a class="brand" href="index">Home</a>
						<div class="nav-collapse collapse">
							<ul class="nav">
								<li><a href="/Library/books/">Books</a></li>
								<li><a href="/Library/cabinet">Cabinet</a></li>
								<li><a data-target="#authors" data-toggle="modal" href="">Authors</a></li>
								<li><a data-target="#about" data-toggle="modal" href="">About</a></li>
							</ul>
							
							<!-- user name -->
							<div class="user_login_text">
								<c:if test="${user_name != 'unknown'}">
									<div class="pull-right">
										<c:out value=" Hello ${user_name}! You privileged is: " />
										<c:choose>
											<c:when test="${user.getPrivileged() == '0'}">
											admin
										</c:when>
											<c:when test="${user.getPrivileged() == '1'}">
											user
										</c:when>
											<c:when test="${user.getPrivileged() == '2'}">
											blocked user
										</c:when>
										</c:choose>
										<button class="btn" id="logoutButton" style="margin-left: 15px; margin-top: -5px;">Logout</button>
									</div>
								</c:if>
							</div>
							
						</div>
					</div>
				</div>
			</div>

			<h1 align="center">Hello, ${user.getFname()} ${user.getLname()}!</h1>
			<h3 align="center">
				You privileged is :

				<c:choose>
					<c:when test="${user.getPrivileged() == '0'}">
					admin
				</c:when>

					<c:when test="${user.getPrivileged() == '1'}">
					user
				</c:when>

					<c:when test="${user.getPrivileged() == '2'}">
					blocked user
				</c:when>

					<c:otherwise>
					unknow
				</c:otherwise>
				</c:choose>
			</h3>

			<h3 align="center">Taken Book:</h3>

			<table class="bookTable">
				<tr>
					<td>Take Time Stamp</td>
					<td>Book Name</td>
					<td>Days ago</td>
				</tr>

				<c:forEach var="book" items="${books}" varStatus="status">

					<tr>
						<td><c:out value="${tb[status.index].getTimeStamp()}" /></td>
						<td><c:out value="${book.getName()}" /></td>
						<td><c:if
								test="${ f:daysUntilToday(tb[status.index].getTimeStamp()) > 30}">
								<div class="warning">
							</c:if> <c:if
								test="${ f:daysUntilToday(tb[status.index].getTimeStamp()) <= 30}">
								<div class="normal">
							</c:if> <c:out
								value="${ f:daysUntilToday(tb[status.index].getTimeStamp())}" />
							</div></td>
					</tr>
				</c:forEach>
			</table>

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
					<div>
						<h4>Artem Bryukhanov</h4>
					</div>
					<div>
						<h4>Dmitrii Kravchenko</h4>
					</div>
					<div>
						<button data-dismiss="modal" aria-hidden="true"
							class="btn btn-success">Back</button>
					</div>
				</div>
			</div>
			
		<script type="text/javascript">
		// --------------------------------------------- init -------------------------------------------- //
		$("#logoutButton").bind("click", logoutBtnFunc);
		function logoutBtnFunc() {
			$.post("https://" + $(location).attr('host') + "/Library/index?delete_cookie=", callBackLogoutFunc);
		}
		
		function callBackLogoutFunc(data) {
			document.location.reload(true);
		}
		</script>
</body>
</html>