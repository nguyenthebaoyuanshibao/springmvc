<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Detail</title>
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
	height: 850px
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
						href="/MobileStore">Home</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/MobileStore/logout"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>

			<div class="col-sm-8 " style="margin-top: 30px">
				<div class="col-sm-4 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div>
							<img style weight="300" height="250" src=${product.url } />
						</div>
						<div style="margin-top: 30px">
							<table>
								<tr>
									<td></td>
									<td>${product.productName}</td>
								</tr>
								<tr>
								<td></td>
								<td>Description: ${product.description}</td>
								</tr>
								<tr>
								    <td></td>
								    <td>Price : ${product.unitPrice}USD</td>
								</tr>
								<tr>
								    <td></td>
								    <td>Units In Stock: ${product.unitsInStock }</td>
								</tr>
								<tr>
									<td></td>
									<td><a
										href="<spring:url value="/order/${product.productId }" />"
										class="btn btn-warning btn-large"> <span
											class="glyphicon-shopping-cart glyphicon"></span> Order Now
									</a></td>
								</tr>
							</table>
						</div>
					</div>
					<div class="container-fluid text-left">
						<form>
							<div>
								<label for="comment">Comment:</label>
								<textarea class="form-control" style="width:270px;" rows="5" id="comment">${userId }</textarea>
							</div>
						</form>
						<button  onclick="submitComment" class="btn btn-info">Submit</button>
					</div>
				</div>	
				<div class="container col-sm-4 " >
				</div>
				<div class="container col-sm-4 " >
				    <div class="container-fluid text-left">
							<div>
								<label for="comment">Top Comment:</label>
								<textarea class="form-control " rows="26" >    
								</textarea>
							</div>			
					</div>
				</div>
			</div>
			
			<div class="col-sm-2 sidenav">
				
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	<script language="javascript" type="text/javascript">
		

		function setSubmmitCommentHref() {
			return 'product/detail/?id='; 
			
		}
		
		function submmitComment() {
			window.location = "http://localhost:8080/MobileStore/" + setSearchHref();
		}
	</script>	
</body>
</html>