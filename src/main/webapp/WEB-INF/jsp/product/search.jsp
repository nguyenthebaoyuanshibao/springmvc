<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Result</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Search Result</h1>
			</div>
		</div>
	</section>
	<section class="container">

		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<image style weight="300" height="200" src=${product.url }>
							<h3>${product.productName}</h3>
							<p>description: ${product.description}</p>
							<p>price: ${product.unitPrice}USD</p>
							<p>Available ${product.unitsInStock} units in stock</p>

							<a href="<spring:url value="/" />"
								class="btn btn-warning btn-large"> <span
								class="glyphicon-shopping-cart glyphicon"></span> back
							</a> <a href="<spring:url value="/order" />"
								class="btn btn-warning btn-large"> <span
								class="glyphicon-shopping-cart glyphicon"></span> Order Now
							</a> <a href="<spring:url value="#" />"
								class="btn btn-warning btn-large"> <span
								class="glyphicon-shopping-cart glyphicon"></span> Rating
							</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

</body>
</html>