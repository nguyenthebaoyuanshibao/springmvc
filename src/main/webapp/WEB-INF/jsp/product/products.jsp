<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>

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


					<a id="searchButton"> 
					<select>
							<option>ProductName</option>
							<option>Category</option>
							<option>PriceLessThan</option>
							<option>PriceGreatThan</option>
					</select> 
					 Search

					</a>





					<h1>Products</h1>
					<p>All the available products in our store</p>

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
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

<script language="javascript" type="text/javascript">
	var searchButton = document.getElementById('searchButton');
    function showText(value) {
    	searchButton.setAttribute('href', ' /SpringWebStore/products/search?id=' + value)
    }
</script>
</body>
</html>

