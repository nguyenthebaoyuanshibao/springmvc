<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
	<section>
		<div class="jumbotron">
			<div class="container">
				<p>
					<a href=" <spring:url value=  "/home" /> " class="btn btn-primary">
						<span class="glyphicon-info-sign glyphicon" /></span> Home
					</a> <a href=" <spring:url value=  "/logout" /> "
						class="btn btn-primary"> <span
						class="glyphicon-info-sign glyphicon" /></span> Logout
					</a>

				</p>
				<div class="row">

					<div class="small-3 columns">
						<input type="text" id="txt" name="searchString"
							onchange="showText(this.value)">
					</div>

					<select id="foo">
						<option>ProductName</option>
						<option>Category</option>
						<option>PriceLessThan</option>
						<option>PriceGreatThan</option>
					</select> <a id="searchButton"> Search </a>

				</div>
			</div>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${product.productName}</h3>
							<h3>productId ${product.productId}</h3>
							<p>description: ${product.description}</p>
							<p>price: ${product.unitPrice}USD</p>
							<p>Available ${product.unitsInStock} units in stock</p>
							<p>
								<a
									href=" <spring:url value=  "/products/product?id=${product.productName}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Detail
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

	<script language="javascript" type="text/javascript">
	
    function showText(value) {
    	if (document.getElementById('foo').selectedIndex==0)
    	document.getElementById('searchButton').setAttribute('href', ' /SpringWebStore/products/search?id=' + value)
    }
</script>
</body>
</html>

