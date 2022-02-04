<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
 
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Profiles</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the addprofile.jsp page -->
				<a href="<%=request.getContextPath()%>/addprofile.jsp"
					class="btn btnsuccess">Add New Profile</a>
			</div>
			<br>
			<!-- Create a table to list out all current profile information -->
			<table class="table">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Gender</th>
						<th>Others</th>
					</tr> 
				</thead>
				<!-- Pass in the list of profile receive via the Servlet’s response to a loop
-->
				<tbody>
					<c:forEach var="profile" items="${listProfiles}">
						<!-- For each profile in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${profile.firstname}" /></td>
							<td><c:out value="${profile.lastname}" /></td>
							<td><c:out value="${profile.gender}" /></td>
							<!-- For each profile in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a
								href="edit?firstname=<c:out value='${profile.firstname}'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?firstname=<c:out value='${profile.firstname}'/>">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>