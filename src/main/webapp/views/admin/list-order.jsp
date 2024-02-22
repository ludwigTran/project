<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/views/admin" var="url">
</c:url>

<%
if (session.getAttribute("usernameAD") == null) {
	response.sendRedirect("/ProjectShop/views/admin/login.jsp");
}
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Ministore</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="${url}/assets/img/favicon.png" rel="icon">
<link href="${url}/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${url}/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="${url}/assets/vendor/quill/quill.bubble.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link href="${url}/assets/vendor/simple-datatables/style.css"
	rel="stylesheet">



<!-- Template Main CSS File -->
<link href="${url}/assets/css/style.css" rel="stylesheet">
<!--  datatable js -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.js"></script>

<!-- =======================================================
  * Template Name: NiceAdmin - v2.4.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />


</head>

<body>


	<header id="header" class="header fixed-top d-flex align-items-center">

		<div class="d-flex align-items-center justify-content-between">
			<a href="/ProjectShop/admin" class="logo d-flex align-items-center">
				<img src="${url}/assets/img/logo.png" alt=""> <span
				class="d-none d-lg-block">Ministore</span>
			</a> <i class="bi bi-list toggle-sidebar-btn"></i>
		</div>
		<!-- End Logo -->



	</header>
	<!-- End Header -->

	<!-- ======= Sidebar ======= -->

	<%@include file="/layout/sidebar.jsp"%>
	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Product Category</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="/Project/list-product">Home</a></li>
					<li class="breadcrumb-item active">Products</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<%--            <c:set var="orderID" value="x"></c:set>
            <c:set var="clientID" value="y"></c:set> --%>


		<section class="section dashboard">
			<div class="row">

				<div class="card">
					<div class="card-body">

						<h5 class="card-title">List of Order</h5>

						<table class="table table-hover table-bordered" id="mytable">
							<thead style="font-size: 15px;">
								<tr>
									<th scope="col">Order ID</th>
									<th scope="col">Client ID</th>
									<th scope="col">Order Date</th>
									<th scope="col">Total ($)</th>
									<th scope="col" style="padding: 10px 50px">Status</th>

									<th scope="col">Action 1</th>
									<th scope="col"></th>
									


								</tr>
							</thead>
							<tbody>
								<c:set var="client_name" value="x"></c:set>

								<c:forEach items="${requestScope.listOrd }" var="order">
									<tr>
										<td>${order.getOrder_id() }</td>
										<td>${order.getClient_id() }</td>
										<td>${order.getCreate_date()}</td>
										<td>${order.getTotalPrice() }</td>
										<c:set var="orderID" value="${order.getOrder_id() }"></c:set>
										<c:set var="clientID" value="${order.getClient_id() }"></c:set>
										<!-- chọn tình trạng đơn hàng -->
										<td>${order.status}</td>
										<td class="product-name">
											<p class="d-inline-flex gap-1">
												<a
													href="/ProjectShop/admin?page=detailOrder&order_id=${order.getOrder_id()}&client_id=${order.getClient_id()}">
													<button class="btn btn-primary padding:10px" type="button"
														data-bs-toggle="collapse"
														data-bs-target="#collapseExample" aria-expanded="false"
														aria-controls="collapseExample">Details </button>
												</a>
											</p>
										</td>

										<c:set var="x" value="none"></c:set>
										<c:set var="y" value="In Process"></c:set>
										<c:choose>
											<c:when test="${order.status != y}">
												<c:set var="x" value="none"></c:set>
											</c:when>
											<c:otherwise>
												<c:set var="x" value="flex"></c:set>
											</c:otherwise>
										</c:choose>
										
										<td class="product-name" id="display"
											style="display: <c:out value="${x}"></c:out>">
											<a
											href="/ProjectShop/admin?page=updateOrdA&id=${order.order_id }">
											<button class="btn btn-success">In Delivery </button></a> <span style="padding: 20px; margin-bottom: 13px"></span>
											<a
											href="/ProjectShop/admin?page=updateOrdC&id=${order.order_id }"><button
													class="btn btn-danger">Cancel Order</button></a>
										</td>

									</tr>

								</c:forEach>

							</tbody>
						</table>




					</div>

				</div>

			</div>
		</section>

		<!-- Detail of order -->
		<!-- <div class="collapse" id="collapseExample">  -->
		<div class="card card-body">

			<section class="section dashboard">
				<div class="row">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Detail Order:
								${requestScope.listCart.get(0).getOrder_id()}</h5>
							<p>
								<span>Name: ${requestScope.clientDetail.getFullname() } </span> <br>
								<span>Phone:
									${requestScope.clientDetail.getPhonenumber()} </span><br> <span>Address:
									${requestScope.orderAd.getAddress()} </span> <br> <span>Note:
									${requestScope.orderAd.getNote()} </span>
							</p>

							<table class="table table-hover" id="">
								<thead style="font-size: 15px;">
									<tr>
										<th scope="col">Product ID</th>
										<th scope="col">Product Name</th>
										<th scope="col">Price($)</th>
										<th scope="col">Quantity</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requestScope.listCart }" var="cart">
										<tr>
											<td>${cart.getProduct_id() }</td>
											<td>${cart.getProduct_name() }</td>
											<td>$ ${cart.getPrice() }</td>
											<td>${cart.getQuantity()}</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>




						</div>

					</div>

				</div>
			</section>

		</div>
		<!-- 	</div>  -->

	</main>
	<!-- End #main -->


	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="${url}/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="${url}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${url}/assets/vendor/chart.js/chart.min.js"></script>
	<script src="${url}/assets/vendor/echarts/echarts.min.js"></script>
	<script src="${url}/assets/vendor/quill/quill.min.js"></script>
	<script
		src="${url}/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="${url}/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="${url}/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="${url}/assets/js/main.js"></script>
	<!-- tao chuc nang xoa -->
	<script type="text/javascript">
		function deleteProduct(id) {
			if (confirm("Are you sure to delete this product ?"))
				window.location = "DeleteProduct?id=" + id;
		}
	</script>


	<script type="text/javascript">
		$(document).ready(function() {
			$('#mytable').DataTable();
		});
	</script>

</body>

</html>