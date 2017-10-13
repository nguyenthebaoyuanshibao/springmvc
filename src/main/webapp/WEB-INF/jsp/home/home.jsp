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
	height: 380%;
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
.carousel-inner > .item > img{
margin:auto;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
			</div>
			
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/MobileStore">Home</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/MobileStore/logout"> <span
							class="glyphicon glyphicon-log-in"></span> Logout
					</a></li>
					
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="/MobileStore/user/admin">
						<span class="glyphicon glyphicon-log-in"></span> AdminPage</a></li>
					</sec:authorize>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center" style="margin-top:50px">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>

			<div class="col-sm-8 text-left">
				<div style="margin-top:20px">
					<form>
						<table>
							<tr>
								<td>Input Text :</td>
								<td><input type="text" id="txt"></td>
							</tr>
							<tr>
								<td>Category:</td>
								<td><select id="foo" style="height:25px; width:199px; margin-top:3px">
										<option value=""></option>
										<c:forEach items="${listCategory}" var="category">
											<option value="${category.categoryId }">${category.categoryName }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>Price from:</td>
								<td><input id="id1" type="number" name="priceFrom" min="" style=" margin-top:3px"></td>
							</tr>
							<tr>
								<td>Price to :</td>
								<td><input id="id2" type="number" name="priceTo" min="" style=" margin-top:3px"></td>
							</tr>
						</table>
					</form>
					<button onclick="search()" class="btn btn-success">SEARCH</button>
				</div>
				<div id="myCarousel" class="container carousel slide" data-ride="carousel" style="margin-top:30px" >
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner ">
						<div class="item active ">
							<img src="https://vn-live-03.slatic.net/p/2/samsung-galaxy-s7-edge-
							32gb-vang-hang-nhap-khau-1464071425-6106812-2046257e28cc21ba6431315c8a3d90de-webp-product.jpg" alt="Los Angeles" style="width: 30%; height:50%;">
						</div>

						<div class="item">
							<img src="https://vn-live-01.slatic.net/p/2/samsung-galaxy-j7-prime-
							32gb-vang-trang-hang-phan-phoi-chinhthuc-1496304018-7641916-5190a1aa018201fea93ba3861609d3c7-webp-zoom.jpg" alt="Chicago" style="width: 30%; height:50%;">
						</div>

						<div class="item">
							<img src="https://vn-live-03.slatic.net/p/2/samsung-galaxy-s8-plus-64g-ram-4gb-
							62inch-den-huyen-bi-hangphan-phoi-chinh-thuc-tang-loa-level-box-slim-pin-sac-duphongsamsung-2017-10200mah-1502336328-2357805-850360aceed96584324273f8030e3d6a-webp-zoom.jpg" alt="New york" style="width: 30%; height:50%;">
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<div style="margin-top:30px">
					<c:forEach items="${products}" var="product">
						<div class="col-sm-3 col-md-4"
							style="padding-bottom: 15px; height: 415px;">
							<div class="thumbnail">
								<div class="caption" style="height: 384px">
									<div>
										    <a
											href=" <spring:url value=  "/product/detail?id=${product.productId}" /> ">
											<img  class =" .img-circle" style width="250" height="150" src=${product.url }></img>
											</a>
									</div>
									<div>
										<h3>${product.productName}</h3>
									</div>
									<div>
										<p>Price: ${product.unitPrice}USD</p>
									</div>
									<div>
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
