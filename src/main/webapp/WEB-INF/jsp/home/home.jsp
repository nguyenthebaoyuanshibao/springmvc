<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
					<li class="active"><a
						href="/MobileStore">Home</a></li>

				</ul>
                
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/MobileStore/logout"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">

                     <li><a href="/MobileStore/user/admin"><span
							class="glyphicon glyphicon-log-in"></span> AdminPage</a></li>

                   </sec:authorize>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>

			<div class="col-sm-8 text-left">
				<div>
					<form>
						<table>
							<tr>
								<td>Input Text :</td>
								<td><input type="text" id="txt" name="searchString"></td>
							</tr>

							<tr>
								<td>Category:</td>
								<td><select id="foo" class=>
										<option value=""></option>
										<option value="I phone">I Phone</option>
										<option value="SamSung Galaxy">Samsung Galaxy</option>
										<option value="XiaoMi">XiaoMi</option>
								</select></td>
							</tr>

							<tr>
								<td>Price from:</td>
								<td><input id="id1" type="number" name="priceFrom" min=""></td>
							</tr>

							<tr>
								<td>Price to :</td>
								<td><input id="id2" type="number" name="priceTo" min=""></td>
							</tr>

						</table>
					</form>



					<button onclick="search()">Search</button>
				</div>

				<div>
					<c:forEach items="${products}" var="product">
						<div class="col-sm-3 col-md-3" style="padding-bottom: 15px">
							<div class="thumbnail">
								<div class="caption">
									<div>
										<image style weight="300" height="200" src=${product.url }>
									</div>

									<div>
										<h3>${product.productName}</h3>
									</div>

									<div>
										<p>price: ${product.unitPrice}USD</p>
										<a
											href=" <spring:url value=  "/product/detail?id=${product.productId}" /> "
											class="btn btn-primary"> <span
											class="glyphicon-info-sign glyphicon" /></span> Detail
										</a>
									</div>



								</div>
							</div>
						</div>
					</c:forEach>
				</div>

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

	<script language="javascript" type="text/javascript">
		var textField = document.getElementById('txt');
		var priceFromField = document.getElementById('id1');
		var priceToField = document.getElementById('id2');
		var categoryField = document.getElementById('foo');
		var searchButton = document.getElementById('searchButton');

		function setSearchHref() {
			return 'products/search/?id=' + textField.value + '&category=' + categoryField.value +
			'&price-from=' + priceFromField.value + '&price-to=' + priceToField.value; 
			
		}
		
		function search() {
			window.location = "http://localhost:8080/MobileStore/" + setSearchHref();
		}
	</script>

</body>
</html>
