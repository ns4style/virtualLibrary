<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body>
<form name="login" method="post" action="signin">
	<table>
		<tr>
			<td>User Name</td>
			<td><input type="text" name="usr_name" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="usr_pass" /></td>
		</tr>
		<tr>
			<td><button type="submit">Login</button></td>
		</tr>
	</table>
</form>
</body>
</html>