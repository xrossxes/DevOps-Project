<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Movie</title>
</head>
<body>

<form action="CreateMovieServlet" method="post">
	Title: <input type="text" name="title">
	Director: <input type="text" name="director">
	Release Date: <input type="text" name="releaseDate">
	Genre: <select name="genre">
		<option>Action</option>
		<option>Thriller</option>
		<option>War</option>
		<option>Sci-Fi</option>
		<option>Romance</option>
		<option>Crime</option>
		<option>Musicals</option>
		<option>Comedy</option>
		<option>Horror</option>
		<option>Documentary</option>
		<option>Western</option>
		<option>Fantasy</option>
	</select>
	Plot: <input type="text" name="plot">
	<input type="submit" value="Call Servlet" />
</form>

</body>
</html>