<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Product</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${products.productName}</h3>
				<p>${products.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${products.productId}</span>
				</p>
				<p>
					<strong>manufacturer</strong> : ${products.manufacturer}
				</p>
				<p>
					<strong>category</strong> : ${products.categoryId}
				</p>
				<p>
					<strong>Availble units in stock </strong> : ${products.unitsInStock}
				</p>
				<h4>${products.unitPrice}USD</h4>
				
				<p>
					<a href="<spring:url value="/products" />" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> back
					</a>
					<a href="<spring:url value="/order" />" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Order Now
					</a>
					<a href="<spring:url value="#" />" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Rating
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>