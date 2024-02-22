<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Product detail</title>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="author" content="">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css"
	href="/ProjectShop/views/clients/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/ProjectShop/views/clients/assets/css/style.css">


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400;500&family=Lato:wght@300;400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<!-- script
    ================================================== -->
<script src="/ProjectShop/views/clients/assets/js/modernizr.js"></script>
</head>
<body >
	<!-- Start - Header -->
	<%@include file="/layout/Header.jsp"%>
	<!-- End - Header -->
<!-- Body -->

			<!-- single product -->
			<c:set var="pro" value="${requestScope.listID}"></c:set>
	<div class="single-product">
		<div class="container">
			<div class="row">
			
				<div class="col-md-5" style="padding-top:100px">
					<div class="single-product-img">
						<img src="/ProjectShop/views/clients/assets/images/${pro.image}" alt="">
					</div>
				</div>
				
				<div class="col-md-7"style="padding-top:100px">
					<div class="single-product-content" >
						<h3 >${pro.name }</h3>
						<p class="single-product-pricing" style="color: black"> $ ${pro.price}</p>
						<p style="color: black">${pro.desc}</p>
						<div class="single-product-form">
							<p style="color: black">Quantity: 1</p>
							<a href="/ProjectShop/cartDetail?product_id=${pro.id}" class="btn btn-outline-success mb-2"><i class="fas fa-shopping-cart"></i> Add to Cart</a>
							<p style="color: black">Categories: ${pro.getCategoryName()}</p>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	<!-- end single product -->
		
<!-- Start - Footer -->
	<%@include file="/layout/Footer.jsp"%>
	<!-- End - Footer -->
	<script src="/ProjectShop/views/clients/assets/js/jquery-1.11.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
	<script type="text/javascript"
		src="/ProjectShop/views/clients/assets/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="/ProjectShop/views/clients/assets/js/plugins.js"></script>
	<script type="text/javascript"
		src="/ProjectShop/views/clients/assets/js/script.js"></script>
</body>
</html>
