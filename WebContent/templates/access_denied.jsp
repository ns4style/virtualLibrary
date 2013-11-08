<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error login</title>
</head>

<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css" />

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
	background-image: url("images/background4.jpg");
}

.loginTxt {
	color: #FFFFFF;
	padding-top: 20%;
}
;
</style>

	<div class="page">
		<div class="loginTxt" align="center"><h2>Error login!</h2></div>
	</div>
	
	<script type="text/javascript">
		$.post("index?delete_cookie=", callBack);
		
		function callBack(data) {
		}
	</script>

</body>
</html>