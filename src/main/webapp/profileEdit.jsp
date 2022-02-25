<!DOCTYPE html> 
<html>
<head>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<title>Edit Profile</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body> 

	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Profile Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ProfileServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${profile != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${profile == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${profile != null}">
Edit Profile
</c:if>
						<c:if test="${profile == null}">
Add New Profile
</c:if>
					</h2>
				</caption>
				<c:if test="${profile != null}">
					<input type="hidden" name="oriFirstname"
						value="<c:out 
value='${profile.firstname}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>First Name</label> <input type="text" value="<c:out value='${profile.firstname}'/>" class="form-control" name="firstname" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Last name</label> <input type="text"	value="<c:out value='${profile.lastname}' />" class="form-control" name="lastname">
				</fieldset>
				<fieldset class="form-group">
					<label>Gender</label> <input type="text" value="<c:out value='${profile.gender}' />" class="form-control" name="gender">
					</fieldset>
				<button type="submit" class="editbutton">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>