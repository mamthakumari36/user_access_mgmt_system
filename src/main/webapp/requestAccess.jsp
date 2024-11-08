<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Access</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h2>Request Access</h2>
	<br>
	<br>
	<form action="RequestServlet" method="POST">
		<input name="name" placeholder="enter name" /><br> <br> 
		<select name="software" required>
			<option value="" disabled selected>Select Software</option>
			<%
			List<Map<String, Object>> softwareList = (List<Map<String, Object>>) request.getAttribute("softwareList");
			if (softwareList != null) {
				for (Map<String, Object> software : softwareList) {
					String softwareName = (String) software.get("name");
					Integer softwareId = (Integer) software.get("id");
			%>
			<option value="<%=softwareId%>"><%=softwareName%></option>
			<%
			}
			}
			%>
		</select> <br> <br> <select name="accessType">
			<option value="Read">Read</option>
			<option value="Write">Write</option>
			<option value="Admin">Admin</option>
		</select> <br> <br>
		<textarea name="reason" placeholder="Reason"></textarea>
		<br> <br>
		<button type="submit">Submit Request</button>
	</form>

</body>
</html>