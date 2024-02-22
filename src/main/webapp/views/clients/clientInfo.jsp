<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Ministore</title>
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
	<div class="container-fluid" style="padding-top: 120px; width: 90%">
	
	<!-- cart -->
			<div class="row">
				
			

			<div class="col-lg-9">
				<h3 class="mt-3">Your information as belows:</h3>
			</div>

			<div>
					<table class="table" id="myTable">
						<thead class="cart-table-head">
							<tr class="table-head-row">

								<th class="product-name">Full Name</th>
								<th class="product-name">Username</th>
								<th class="product-name">Password</th>
								<th class="product-name">Phone number</th>
								<th class="product-name">Email</th>
								<th class="product-name">Eddress</th>
								<th class="product-name">Action</th>
							</tr>
						</thead>

						<tbody class="table-striped">
							<!-- Detail of each order -->
							<c:set value="${requestScope.clientInfo}" var="pro"></c:set>
								<tr class="table-body-row">
									<td class="product-name">${pro.getFullname()}</td>
									<td class="product-name">${pro.getUsername()}</td>
									
									<td class="product-name">
										<a href="/ProjectShop/password"> <button>Change passwords</button></a>
										
									
									</td>
									<td class="product-name">${pro.getPhonenumber()}</td>
									<td class="product-name">${pro.getEmail()}</td>
									<td class="product-name">${pro.getAddress()}</td>
									<td class="product-name"><a
										href="/ProjectShop/editClientInfo">
											<button class="btn btn-outline-primary">Edit these info</button>
									</a></td>
								</tr>

							

						</tbody>
					</table>



			</div>

	<!-- end cart -->

	
	
</div> <!-- div container -->
	
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