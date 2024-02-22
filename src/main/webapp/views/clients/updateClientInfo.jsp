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
<!-- <link rel="stylesheet"
	href="/ProjectShop/views/clients/assets1/css/main.css">  -->
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
	<div class="container" style="padding-top: 120px; width: 90%">

		<!-- cart -->
		<div class="row">



			<div class="col-lg-9">
				<h3 class="mt-3">Your information as belows:</h3>
			</div>

			<div>
				<c:set value="${requestScope.client }" var="cl"></c:set>
				<form class="row g-3 needs-validation"
					action="/ProjectShop/editClientInfo" method="post">

					<div class="col-12">
						<label for="yourUsername" class="form-label">Full name</label>
						<div class="input-group has-validation">

							<input type="text" name="fullname" class="form-control"
								value="${cl.getFullname()}" minlength="10">
						</div>
					</div>

					<div class="col-12">
						<label for="yourUsername" class="form-label">Username</label>
						<div class="input-group has-validation" minlength="5">

							<input type="text" name="username" class="form-control"
								value="${cl.getUsername()}" readonly="readonly">
						</div>
					</div>
					<div class="col-12">
						<label for="yourUsername" class="form-label">Phone number</label>
						<div class="input-group has-validation">
							<input type="text" name="phonenumber" class="form-control" pattern="0[0-9]{9}" maxlength="10" value="${cl.getPhonenumber()}" required="required">
						</div>
					</div>

					<div class="col-12">
						<label for="yourUsername" class="form-label">email</label>
						<div class="input-group has-validation">

							<input type="text" name="email" class="form-control" value="${cl.getEmail()}" pattern="[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$" required="required">
						</div>
					</div>

					<div class="col-12">
						<label for="yourUsername" class="form-label">address</label>
						<div class="input-group has-validation">
							<input type="text" name="address" class="form-control" value="${cl.getAddress()}" required="required">
						</div>
					</div>
					<div class="col-12">
						<input type="submit" class="btn btn-outline-primary" value="Submit">
					</div>
				</form>
			</div>
			<!-- end cart -->
		</div>
		<!-- div container -->
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
