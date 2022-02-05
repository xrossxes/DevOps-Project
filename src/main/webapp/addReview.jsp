<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Title Here</title>
</head>
<body>
	<form action="AddReviewServlet" method="post">
		Title: <input type="text" name="title"> 
		Comment: <input type="text" name="comment"> 
		<input type="submit" value="Call Servlet" />
	</form>
</body>
</html> 