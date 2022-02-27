<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Review</title>
</head>
<body>
	<form action="AddReviewServlet" method="post">
		Title: <input type="text" name="title"> Comment: <input
			type="text" name="comment"> <input type="submit"
			class="submitReview" value="Call Servlet" />
	</form>
</body>
</html> 