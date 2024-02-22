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
<body>
	<!-- Start - Header -->
	<%@include file="/layout/Header.jsp"%>
	<!-- End - Header -->
	<div class="container" style="padding-top: 120px">
		<c:if test="${requestScope.errorH != null }">
			<p class="alert alert-danger">${requestScope.errorH }</p>
		</c:if>
		<!-- cart -->
		<div>
			<div class="container">
				<c:set var="total" value="0"></c:set>
				<div class="row">
					<div class="col-lg-9">
						<h2>Your current Shopping Cart:</h2>
					</div>
					<div class="col-lg-3">
						<!-- //History -->
						<a href="/ProjectShop/historyOrder"><p
								class="btn btn-outline-warning fs-4">History ordered</p></a>
					</div>

					<div class="col-lg-8">

						<div class="cart-table-wrap mt-5" style="padding-top: 0px">
							<table class="table" id="myTable"
								style="text-align: center; justify-content: center;">

								<thead class="cart-table-head">
									<tr class="table-head-row">
										<th class="product-remove"></th>
										<th class="product-image">Product Image</th>
										<th class="product-name">Name</th>
										<th class="product-price">Price</th>
										<th class="product-quantity">Quantity</th>
										<th class="product-price">Price per product</th>
									</tr>
								</thead>
								<tbody style="line-height: 100px">
									<c:forEach items="${requestScope.cartID}" var="pro"
										varStatus="loop">
										<c:set value="${total + pro.price*pro.quantity }" var="total"></c:set>
										<tr class="table-body-row">
											<td class="product-remove"><a
												href="/ProjectShop/removeCart?id=${pro.product_id}"><i
													class="far fa-window-close"></i></a></td>
											<td class="product-image"><img style="max-width: 80px"
												src="/ProjectShop/views/clients/assets/images/${pro.product_image}"
												alt=""></td>
											<td class="product-name">${pro.product_name}</td>
											<td class="product-price" id="price">$ ${pro.price}</td>
											<c:if test="${requestScope.error != nul }">
												<p class="alert alert-danger">${requestScope.error }</p>
											</c:if>
											<td><c:if test="${requestScope.ex1 != null }">
													<p class="alert alert-danger">${requestScope.ex1 }</p>
												</c:if>

												<p>
													
													<input
														style="line-height: 30px; width: 70px; text-align: center"
														type="number" value="${pro.quantity}"
														onchange="quantity(${pro.product_id })" pattern="[^\.]"
														name="quantity" id="${pro.product_id }" onkeypress="return isNumberKey(event)">
												</p></td>
											<td>$<span>${pro.price*pro.quantity} </span>
											</td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div class="col-lg-4">
						<div class="total-section mt-5">
							<table class="table"
								style="text-align: center; justify-content: center; align-items: center">
								<thead class="total-table-head">
									<tr class="table-total-row">
										<th>Total</th>
										<th>Price</th>
									</tr>
								</thead>
								<tbody>
									<tr class="total-data">
										<td><strong>Subtotal: </strong></td>
										<td id="receipt">$ <span><c:out value="${total}"></c:out></span></td>
									</tr>
									<tr class="total-data">
										<td><strong>Shipping: </strong></td>
										<td>$15</td>
									</tr>
									<tr class="total-data">
										<td><strong>Total: </strong></td>
										<td id="total">$<c:out value="${total+15}"></c:out></td>
									</tr>
								</tbody>
							</table>
							<c:choose>
								<c:when test="${total == 0}">
									<c:set var="z1" value="none"></c:set>
									<td> <p style="color: red; font-size: 20x">Please add products to your cart! Thanks</p> </td>
								</c:when>
								<c:otherwise>
									<td><a
										href="/ProjectShop/cartsymbol?page=checkout&total=<c:out value="${total+15}" />">
											<button style="margin-left: 150px"
												class="btn btn-outline-success">Check out</button>
									</a></td>
								</c:otherwise>
							</c:choose>



						</div>




					</div>
				</div>
			</div>
			<!-- end cart -->

			<!-- Start in delivery cart -->
			<!-- Order payslip -->

			<div class="row">
				<div class="col-lg-9">
					<h3 class="mt-3">Please find your order in delivery belows:</h3>
				</div>
				<div class="col-lg-3">
					<h3 class="mt-3">Order ID: ${requestScope.order }</h3>
				</div>

				<div class="col-lg-8">
					<div class="cart-table-wrap mt-5"
						style="padding-top: 0px; text-align: center">
						<table class="table" id="myTable">
							<thead class="cart-table-head">
								<tr class="table-head-row">

									<th class="product-name">Order ID</th>
									<th class="product-name">Create date</th>
									<th class="product-price">Total Price</th>
									<th class="product-name">Status</th>
									<th class="product-price">Info</th>

									<th class="product-name">Action</th>

								</tr>
							</thead>

							<tbody>
								<!-- Detail of each order -->

								<c:forEach items="${requestScope.listC}" var="pro">
									<tr class="table-body-row">

										<td class="product-name">${pro.getOrder_id()}</td>
										<td class="product-price" id="price">${pro.getCreate_date()}</td>
										<td class="product-quantity">$ ${pro.getTotalPrice()}</td>
										<td class="product-quantity" id="status">${pro.getStatus()}
										</td>
										<td class="product-name"><a
											href="/ProjectShop/cartsymbol?order_id=${pro.getOrder_id()}">
												<button class="btn btn-primary">details</button>
										</a></td>
										<c:choose>
											<c:when test="${pro.getStatus() == 'In Process'}">
												<c:set var="z" value="disabled"></c:set>
												<c:set var="href" value="#"></c:set>
											</c:when>
											<c:otherwise>
												<c:set var="z" value=" "></c:set>
												<c:set var="href"
													value="/ProjectShop/cartsymbol?page=received&order_id=${pro.getOrder_id()}"></c:set>
											</c:otherwise>
										</c:choose>
										<td class="product-name"><a
											href="<c:out value="${href}"></c:out>"><button
													class="btn btn-danger" <c:out value="${z}"></c:out>>Received</button></a>
										</td>

										<c:set var="x" value="none"></c:set>
										<c:set var="y" value="In Delivery"></c:set>
										<c:choose>
											<c:when test="${pro.getStatus() != y }">
												<c:set var="x" value="flex"></c:set>
											</c:when>
											<c:otherwise>
												<c:set var="x" value="none"></c:set>
											</c:otherwise>
										</c:choose>
										<td class="product-name" id="display"
											style="display: <c:out value="${x}"></c:out>"><a
											href="/ProjectShop/cancel?cancelorder_id=${pro.getOrder_id()}"><button
													class="btn btn-danger">Cancel Order</button></a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>


				</div>

				<div class="col-lg-4">

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
								<c:forEach items="${requestScope.listDeli}" var="pro">
									<tr class="total-data">

										<td>${ pro.getProduct_name()}</td>
										<td>$ ${ pro.getPrice()}</td>
										<td>${ pro.getQuantity()}</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>


				</div>
			</div>


		</div>

		<!-- Start - Footer -->
		<%@include file="/layout/Footer.jsp"%>
		<!-- End - Footer -->
		<script
			src="/ProjectShop/views/clients/assets/js/jquery-1.11.0.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
		<script type="text/javascript"
			src="/ProjectShop/views/clients/assets/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript"
			src="/ProjectShop/views/clients/assets/js/plugins.js"></script>
		<script type="text/javascript"
			src="/ProjectShop/views/clients/assets/js/script.js"></script>
		<script type="text/javascript">
function quantity(id) {
	var quantity = document.getElementById(id);
	const url = "/ProjectShop/quantity?action=quantity&id="+id+"&quantity="+quantity.value;
	document.getElementById(id).innerHTML = quantity.value;
	window.location.href = url;			
}
function isNumberKey(evt) {
	  var charCode = (evt.which) ? evt.keyCode : evt.which
	  if (charCode > 31 && (charCode < 48 || charCode > 57))
	    return false;
	  return true;
	}

</script>
</body>
</html>