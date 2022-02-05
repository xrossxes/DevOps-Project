<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>List of Movies</title>
</head>

<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Movies</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new movie button redirects to the createMovie.jsp page -->
				<a href="<%=request.getContextPath()%>/createMovie.jsp"
					class="btn btn-success">Add New Movie</a>
			</div>
			<br>
			<!-- Create a table to list out all current movies information -->
			<table class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Director</th>
						<th>Release Date</th>
						<th>Genre</th>
						<th>Plot</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of movies receive via the Servlet's response to a loop -->
				<tbody>
					<c:forEach var="movie" items="${listMovies}">
						<!-- For each movie in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${movie.title}" /></td>
							<td><c:out value="${movie.director}" /></td>
							<td><c:out value="${movie.releaseDate}" /></td>
							<td><c:out value="${movie.genre}" /></td>
							<td><c:out value="${movie.plot}" /></td>
							<!-- For each movie in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td><a href="edit?title=<c:out value='${movie.title}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?title=<c:out value='${movie.title}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>