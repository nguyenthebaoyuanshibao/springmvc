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
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						

							<div>
								<image style weight="200" height="200" src=${product.url }>
							</div>


							<h3>${product.productName}</h3>



							<p>Description: ${product.description}</p>
							<p>Price : ${product.unitPrice}</p>
							<p>Units In Stock: ${product.unitsInStock }</p>
						

					</div>

					<div>
						<a href="<spring:url value="/" />"
							class="btn btn-warning btn-large"> <span
							class="glyphicon-shopping-cart glyphicon"></span> Back
						</a> <a href="<spring:url value="/order/${product.productId }" />"
							class="btn btn-warning btn-large"> <span
							class="glyphicon-shopping-cart glyphicon"></span> Order Now
						</a>
					</div>


				</div>
			</c:forEach>
		</div>
	</section>


</body>
</html>