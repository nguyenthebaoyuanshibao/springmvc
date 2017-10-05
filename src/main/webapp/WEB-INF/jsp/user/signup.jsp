<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
					<li class="active"><a href="/MobileStore">Home</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right"></ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
			</div>
			
			<div class="col-sm-8 text-left">
				<form:form action="/MobileStore/user/register"
					modelAttribute="userForm" method="post" align="center">

					<table align="center">
						<tr>
							<td>UserId:</td>
							<td><form:input type="text" name="userName" path="userName"/></td>
							<form:errors path="userName" />
						</tr>

						<tr>
							<td>Password:</td>
							<td><form:input type="password" name="password" path="password"/></td>
							<form:errors path="password" />
						</tr>

						<tr>
							<td>Confirm Password:</td>
							<td><form:input type="password" name="confirmPassword" path="confirmPassword" /></td>
							<form:errors path="confirmPassword" />
						</tr>
						
						<tr>
						    <td></td>
						    <td><button align="center" type="submit" class="btn btn-warning">Sign up</button></td>
						    
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