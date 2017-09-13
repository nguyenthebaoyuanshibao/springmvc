<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Order</title>
</head>
<body>


	<div>
		<image style weight="200" height="200" src=${ product.url} >
	</div>


	<h3>${product.productName}</h3>



	<p>Description: ${product.description}</p>
	<p>Price : ${product.unitPrice}</p>
	<p>Units In Stock: ${product.unitsInStock} </p>



	<a href="<spring:url value="/" />" class="btn btn-warning btn-large">
		<span class="glyphicon-shopping-cart glyphicon"></span> Back
	</a>
	<form>
	    Number of stocks you want buy: <input id="id1" type="number" name="" min="0">
	</form>
	<button onclick="search()">Order</button>
	
	<script language="javascript" type="text/javascript">
		
		var numberOfQuantityField = document.getElementById('id1');
		
		function setSearchHref() {
			return "/"+ numberOfQuantityField.value;
			
		}
		
		function search() {
			window.location = window.location.href + setSearchHref();
		}
	</script>
</body>
</html>