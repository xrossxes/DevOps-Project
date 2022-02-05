<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Movie Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Movie Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/MovieServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${movie != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${movie == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${movie != null}">Edit Movie</c:if>
						<c:if test="${movie == null}">Add New Movie</c:if>
					</h2>
				</caption>
				<c:if test="${movie != null}">
					<input type="hidden" name="oriTitle"
						value="<c:out value='${movie.title}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Movie Title</label> <input type="text"
						value="<c:out value='${movie.title}' />" class="form-control"
						name="title" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Director</label> <input type="text"
						value="<c:out value='${movie.director}' />" class="form-control" name="director">
				</fieldset>
				<fieldset class="form-group">
					<label>Movie Release Date</label> <input type="text"
						value="<c:out value='${movie.releaseDate}' />"
						class="form-control" name="releaseDate">
				</fieldset>
				<fieldset class="form-group">
					<label> Genre</label> <input type="text"
						value="<c:out value='${movie.genre}' />" class="form-control" name="genre">
				</fieldset>
				<fieldset class="form-group">
					<label> Plot</label> <input type="text"
						value="<c:out value='${movie.plot}' />" class="form-control" name="plot">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
			</div>
		</div>
	</div>
</body>

</html>