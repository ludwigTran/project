<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Update info</title>
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
				<h3 class="mt-3">Your history orders as belows:</h3>
			</div>

			<div class="col-lg-8">
				<div class="cart-table-wrap mt-5" style="padding-top: 0px">
					<table class="table" id="myTable">
						<thead class="cart-table-head">
							<tr class="table-head-row">

								<th class="product-name">Order ID</th>
								<th class="product-name">Create date</th>
								<th class="product-price">Total Price</th>
								<th class="product-name">Status Order</th>
								<th class="product-name"></th>

							</tr>
						</thead>

						<tbody>
							<!-- Detail of each order -->

							<c:forEach items="${requestScope.listH}" var="pro">
								<tr class="table-body-row">
									<td class="product-name">${pro.getOrder_id()}</td>
									<td class="product-price" id="price">${pro.getCreate_date()}</td>
									<td class="product-quantity">$ ${pro.getTotalPrice()}</td>
									<td class="product-name">${pro.getStatus()}</td>
									<td class="product-name"><a
										href="/ProjectShop/historyOrder?order_id=${pro.getOrder_id()}">
											<button class="btn btn-primary">details</button>
									</a></td>
								</tr>

							</c:forEach>

						</tbody>
					</table>

				</div>


			</div>

		 <div class="col-lg-4">
				<%-- <h4>Order ID: ${requestScope.cartListH.get(0).getOrder_id() }</h4> --%>
				<div class="total-section mt-5">
					<table class="table">
						<thead class="total-table-head">
							<tr class="table-total-row">
								<th>Product name</th>
								<th>Unit price</th>
								<th>Quantity</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.cartListH}" var="pro1">
								<tr class="total-data">
									<td>${ pro1.getProduct_name()}</td>
									<td>$ ${ pro1.getPrice()}     </td>
									<td>${ pro1.getQuantity()}    </td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div> 


			</div>
				
	
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