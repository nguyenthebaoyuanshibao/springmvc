<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	height: 300%;
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
	<div>
		<nav class="navbar navbar-inverse navbar-fixed-top ">
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
					<li class="active"><a href="/MobileStore/user/admin/listUser">ListUser</a></li>
					<li class="active"><a href="/MobileStore/user/admin/addProduct">AddProduct</a></li>
					<li class="active"><a href="/MobileStore/user/admin/addCategory">AddCategory</a></li>
					<li class="active"><a href="/MobileStore/user/admin/deleteCategory">DeleteCategory</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><spring:url value="/user/removeUser" var="removeUserURL" />
						<a href="/MobileStore/logout"> <span
							class="glyphicon glyphicon-log-in"></span> Logout
					</a></li>
				</ul>
			</div>
		</div>
		</nav>
	</div>

	<div class="container-fluid text-center " style="margin-top:50px">
		<div class="row content">
			<div class="col-sm-2 sidenav">
			</div>

			<div class="col-sm-8 text-left">
				<div>
				     <h3>${msg }</h3>
				</div>
				<div>
					<c:forEach items="${products}" var="product">
						<div class="col-sm-3 col-md-4"
							style="padding-bottom: 15px; height: 409px;">
							<div class="thumbnail">
								<div class="caption" style="height: 384px">
									<div>
										<image style max-width="100%" height="200" src=${product.url }>
									</div>
									<div>
										<h3>${product.productName}</h3>
									</div>
									<div>
										<p>Price: ${product.unitPrice}USD</p>
									</div>
									<div>	
										<a
											href=" <spring:url value=  "/user/admin/updateProduct?id=${product.productId}" /> "
											class="btn btn-primary"> <span
											class="glyphicon-info-sign glyphicon" /></span> Update
										</a>
										<a
											href=" <spring:url value=  "/user/admin/deleteProduct/?id=${product.productId}" /> "
											onclick="return confirm('Are you sure?')" class="btn btn-warning"> <span
											class="glyphicon-info-sign glyphicon" /></span> Delete
										</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>
			<div class="col-sm-2 sidenav">
				
			</div>

		</div>
	</div>
    <footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>
	<script type="text/javascript">
	
    var confirmIt = function (e) {
        if (!confirm('Are you sure?')) e.preventDefault();
    };   
</script>
</body>
</html>