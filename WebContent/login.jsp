<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="bootstrap/js/md5.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Sign in</title>

<style>
.page {
	background-image: url("images/background3.jpg");
}

.header {
	
}
</style>

<script language="javascript">
	
	function hash_pass() {
		document.hiden_fields.j_username.value = document.req_form.j_username.value;
		document.hiden_fields.j_password.value = md5(document.req_form.j_password.value);
		document.hiden_fields.submit();
	}
	
</script>

</head>
<body class=page>

	<div>
		<!-- Form Name -->
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<a class="brand">Login</a>
			</div>
		</div>

		<form class="form-horizontal" name="req_form"
			style="margin-top: 17%; margin-left: 35%">
			<fieldset>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="j_username"
						style="color: #000000; font-size: 20px">Login</label>
					<div class="controls">
						<input id="j_username" name="j_username"
							placeholder="mail@example.org" class="input-xlarge" required=""
							type="text">
						<p class="help-block" style="margin-left: 2%; color: #777777">You
							must specify your e-mail address</p>
					</div>
				</div>

				<!-- Password input-->
				<div class="control-group">
					<label class="control-label" for="j_password"
						style="color: #000000; font-size: 20px">Password</label>
					<div class="controls">
						<input id="j_password" name="j_password" placeholder="password"
							class="input-xlarge" required="" type="password">
						<p class="help-block" style="margin-left: 5%; color: #777777">Password
							will be sent secure</p>
					</div>
				</div>

				<!-- Button -->
				<div class="control-group" style="margin-left: 8%;">
					<label class="control-label" for="singlebutton"></label>
					<div class="controls">
						<button id="singlebutton" name="singlebutton"
							class="btn btn-primary" onclick="hash_pass(); return false;">Sign in</button>
					</div>
				</div>

			</fieldset>
		</form>
		
		<form method="POST" action="j_security_check" name="hiden_fields">
			<input type="hidden" name="j_username">
			<input type="hidden" name="j_password">
		</form>
	</div>
</body>
</html>