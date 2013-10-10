<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="bootstrap/js/md5.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>

<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>
<body>
<style>
	
	.page {
    background-color: #9d261d;
 	 }

</style>
<div>

<!-- Form Name -->
<legend style="text-align: center">Login</legend>

<form class="form-horizontal" method="POST" action="j_security_check" style="margin-top: 17%; margin-left: 35%">
<fieldset>

	<!-- Text input-->
	<div class="control-group">
  		<label class="control-label" for="j_username">Login</label>
  			<div class="controls">
  	  			<input id="j_username" name="j_username" placeholder="mail@example.org" class="input-xlarge" required="" type="text" >
  	  			<p class="help-block" style="margin-left: 2%">You must specify your e-mail address</p>
  			</div>
	</div>

	<!-- Password input-->
	<div class="control-group">
	  <label class="control-label" for="j_password">Password</label>
  		<div class="controls">
    		<input id="j_password" name="j_password" placeholder="password" class="input-xlarge" required="" type="password">
    		<p class="help-block" style="margin-left: 5%">Password will be sent secure</p>
  		</div>
	</div>

	<!-- Button -->
	<div class="control-group" style="margin-left: 8%;">
  		<label class="control-label" for="singlebutton"></label>
  			<div class="controls">
    			<button id="singlebutton" name="singlebutton" class="btn btn-primary">Sign in</button>
  			</div>
	</div>

</fieldset>
</form>

</div>
</body>
</html>