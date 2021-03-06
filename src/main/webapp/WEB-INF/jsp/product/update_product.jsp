<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>

		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="/MobileStore">Home</a></li>
				<li><a href="/MobileStore/user/admin/listUser">List User</a></li>
				<li><a href="/MobileStore/user/admin/addProduct">Add
						Product</a></li>
				<li><a href="/MobileStore/user/admin/addCategory">Add
						Category</a></li>
				<li><a href="/MobileStore/user/admin/deleteCategory">Delete
						Category</a></li>
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

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>

			<div class="col-sm-8">
				<p>${msg }</p>

				<form>
					<table align="center">
						<tr>
							<td>ProducId :</td>
							<td><input id="id1" type="number" value=${product.productId} disabled /></td>
						</tr>
						<tr>
							<td>Url:</td>
							<td><input id="id2" type="text" value=${product.url} /></td>
						</tr>

						<tr>
							<td>Category:</td>
							<td><select id="id3"  >
									
									<c:forEach items="${listCategory}" var="category">
										<option value="${category.categoryId }">${category.categoryName }</option>
									</c:forEach>
							</select></td>
						</tr>

						<tr>
							<td>ProductName:</td>
							<td><input id="id4" type="text" value=${product.productName} /></td>
						</tr>

						<tr>
							<td>UnitPrice:</td>
							<td><input id="id5" type="number" value=${product.unitPrice} /></td>
						</tr>

						<tr>
							<td>UnitsInStock:</td>
							<td><input id="id6" type="number" value=${product.unitsInStock} /></td>
						</tr>

						<tr>
							<td>Description:</td>
							<td><input id="id7" type="text" value = ${product.description} /></td>
						</tr>

						<tr>
							<td>Manufacturer:</td>
							<td><input id="id8" type="text" value = ${product.manufacturer} /></td>
						</tr>

					</table>
				</form>

				<button onclick="update()" class="btn btn-success">Update</button>
			</div>
			<div class="col-sm-2 sidenav">
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
	<p>Footer Text</p>
	</footer>

	<script language="javascript" type="text/javascript">
	
	    var productIdField =document.getElementById('id1');
		var urlField = document.getElementById('id2');
		var categoryIdField = document.getElementById('id3');
		var productNameField = document.getElementById('id4');
		var unitPriceField = document.getElementById('id5');
		var unitsInStockField = document.getElementById('id6');
        var descriptionField  = document.getElementById('id7');
        var manufacturerField = document.getElementById('id8');
        
		function setUpdateHref() {
			return '/update?id=' + productIdField.value+ '&url=' + urlField.value + '&categoryId=' + categoryIdField.value + '&productName=' + productNameField.value
					+'&unitPrice=' + unitPriceField.value + '&unitsInStock=' +
					unitsInStockField.value + '&description=' + descriptionField.value+ '&manufacturer=' + manufacturerField.value ;
			
		}

		function update() {
			window.location = "/MobileStore/user/admin/updateProduct" + setUpdateHref();
		}
	</script>


</body>
</html>