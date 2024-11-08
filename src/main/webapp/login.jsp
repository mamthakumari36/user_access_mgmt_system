<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	 <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <label for="username">Username:</label><br>
        <input type="text" name="username" id="username" required><br><br>

        <label for="password">Password:</label><br>
        <input type="password" name="password" id="password" required><br><br>

        <input type="submit" value="Login">
    </form>
	
</body>
</html>