<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Software</title>
</head>
<body>
<h2>Create Software</h2><br><br>
	<form action="SoftwareServlet" method="POST">
	    <input type="text" name="softwareName" placeholder="Software Name" required><br><br>
	    <textarea name="description" placeholder="Description"></textarea><br><br>
	    <input type="checkbox" name="accessLevels" value="Read"> Read
	    <input type="checkbox" name="accessLevels" value="Write"> Write
	    <input type="checkbox" name="accessLevels" value="Admin"> Admin
	    <br><br>
	    <button type="submit">Create Software</button>
	</form>

</body>
</html>