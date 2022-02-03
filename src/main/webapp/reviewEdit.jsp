<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert review here</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Review Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Review Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ReviewServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${review != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${review == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${review != null}">
Edit Review
</c:if>
						<c:if test="${review == null}">
Add New Review
</c:if>
					</h2>
				</caption>
				<c:if test="${review != null}">
					<input type="hidden" name="oriTitle"
						value="<c:out
value='${review.title}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Title</label> <input type="text"
						value="<c:out
value='${review.title}' />" class="form-control"
						name="title" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Comment</label> <input type="text"
						value="<c:out
value='${review.comment}' />" class="form-control"
						name="comment">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	
	
</body>
</html>