<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h2>Sign Up</h2>
	<form action="SignUpServlet" method="post">
		<label for="username">Username:</label><br> <input type="text"
			name="username" id="username" required><br>
		<br> <label for="password">Password:</label><br> <input
			type="password" name="password" id="password" required><br>
		<br> 
		<label for="role">Role:</label><br> 
		<select id="role" name="role" required>
			<option value="Employee">Employee</option>
			<option value="Manager">Manager</option>
			<option value="Admin">Admin</option>
		</select><br>
		<br>
		<p>
			Already have an account?<a href="login.jsp">Login</a>
		</p>
		<input type="submit" value="Sign Up">
	</form>

</body>
</html>