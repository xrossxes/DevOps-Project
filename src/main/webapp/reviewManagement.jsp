<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review Management</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><link
	rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">Reviews Section asd</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the addnote.jsp page -->
				<a href="<%=request.getContextPath()%>/addReview.jsp"
					class="btnbtnsuccess">Add New Review</a>
			</div>
			<br>
			<!-- Create a table to list out all current note information -->
			<table class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Comment</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of note receive via the Servlet’s response to a loop
-->
				<tbody>
					<c:forEach var="review" items="${listReviews}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${review.title}" /></td>
							<td><c:out value="${review.comment}" /></td>
							<!-- For each note in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a href="edit?title=<c:out value='${review.title}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?title=<c:out
value='${review.title}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>