<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
     <nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="/SpringMvcSignUpLoginWithPasswordEncoder">Home</a></li>
                 <li class="active">
                 <a href=" <spring:url value=  "/user/admin"/> "
					class="btn btn-primary"> Admin Page </a>
				</li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><spring:url value="/user/removeUser" var="removeUserURL" />
					<a href="/SpringMvcSignUpLoginWithPasswordEncoder/logout"> <span
						class="glyphicon glyphicon-log-in"></span> Logout
				</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>
					<a href="#"></a>
				</p>
				<p>
					<a href="#"></a>
				</p>
				<p>
					<a href="#"></a>
				</p>
			</div>
			<div class="col-sm-8 sidenav">
				<spring:url value="/user/admin/delete" var="deleteURL" />
				<form:form method="post" modelAttribute="user"
					action="${deleteURL }">
					<form:hidden path="userId" />
					<h2>${msg}</h2>
					<table border="1" align="center">
						
						<tr>
							<td>Username</td>
							<td>${user.userId }</td>
						</tr>
						
						<tr>
							<td></td>
							<td><button type="submit">Remove</button></td>
						</tr>
					</table>
					
				</form:form>
			</div>

			<div class="col-sm-2 sidenav">
				<div class="well">
					<p></p>
				</div>
				<div class="well">
					<p></p>
				</div>
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
	<p>Footer Text</p>
	</footer>
	

</body>
</html>