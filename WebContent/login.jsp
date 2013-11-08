<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>

<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/md5.js"></script>
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

.login_form {
	color: #FFFFFF;
	padding-top:20%;
}
;
</style>

	<div class="page">
		<div class="login_form" align="center">
			<form method="POST" action="j_security_check">
				<p>
					User name : <input type="text" name="j_username" id="j_username" />
				</p>
				<p>
					User pass : <input type="password" name="j_password"
						id="j_password" />
				</p>
				<input type="submit" class="btn" value="Login" id="loginBtn">
			</form>
		</div>
	</div>

	<script type="text/javascript">
		$("#loginBtn").bind("click", passHash);

		function passHash() {
			var clearTxt = $("#j_password").val();
			$("#j_password").val($.md5(clearTxt));
		}
	</script>

</body>
</html>