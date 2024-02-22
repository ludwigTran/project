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

<div class="container-fluid">
<p style="padding-top: 100px"></p>
      <div class="row mt-3">
        <div class="col-md-12 text-center pt-5">
          <span class="display-3 thankyou-icon text-primary">
            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-cart-check mb-5" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" d="M11.354 5.646a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L8 8.293l2.646-2.647a.5.5 0 0 1 .708 0z"/>
              <path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
            </svg>
          </span>
          <h2 class="display-3 text-black">Thank you!</h2>
          <p class="lead mb-5">You order was successfully completed.</p>
          <p><a href="/ProjectShop/home" class="btn btn-primary">Back to shop</a></p>
        </div>
      </div>
    </div>
  </div>

<!-- Start - Footer -->
    <%@include file="/layout/Footer.jsp" %>
<!-- End - Footer -->
</body>
</html>