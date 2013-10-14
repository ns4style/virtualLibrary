<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="bootstrap/js/bootstrap.js"></script>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Access Denied!</title>

<style>
.page {
	background-image: url("images/background3.jpg");
}
</style>

</head>
<body class=page>
<% if (request.getUserPrincipal() != null) { %>
		<%= request.getUserPrincipal().getName() %>
<%	} else { %>
	unknown
<% } %>
</body>
</html>