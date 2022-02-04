<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ProfileSuccessServlet" method="post">
		First Name: <input type="text" name="firstname"> 
		Last Name: <input type="text" name="lastname"> 
		Gender: <select name="gender">
			<option>Male</option>
			<option>Female</option>
			<option>Others</option>
		</select> <input type="submit" value="Create Profile" />
	</form> 
</body>
</html>

