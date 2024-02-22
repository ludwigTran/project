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
	<div class="container" style="padding-top: 120px">
		
		<div class="row">
		<c:set value="${sessionScope.client }" var="client"></c:set>
		        <div class="col-md-6 mb-5 mb-md-0">
		          <h2 class="h3 mb-3 text-black">Billing Details</h2>
		          <div class="p-3 p-lg-5 border bg-white">
		            
		            <div class="form-group row">
		              <div class="col-md-12">
		                <label for="c_fname" class="text-black">Full Name <span class="text-danger">*</span></label>
		                <input type="text" class="form-control" id="c_fname" name="fullname" value="${client.getFullname()}" readonly="readonly">
		              </div>
		            </div>


		            <div class="form-group row">
		              <div class="col-md-12">
		                <label for="c_address" class="text-black">Address <span class="text-danger">*</span></label>
		                <input type="text" class="form-control" id="address" name="c_address" value="${client.getAddress()}">
		              </div>
		            </div>
		            <div class="form-group row mb-5">
		              <div class="col-md-6">
		                <label for="c_email_address" class="text-black">Email Address <span class="text-danger">*</span></label>
		                <input type="text" class="form-control" id="c_email_address" name="c_email_address" value="${client.getEmail() }" readonly="readonly">
		              </div>
		              <div class="col-md-6">
		                <label for="c_phone" class="text-black">Phone to Receive <span class="text-danger">*</span></label>
		                <input type="text" class="form-control" id="c_phone" name="phone" value="${client.getPhonenumber()}">
		              </div>
		            </div>

		            <div class="form-group">
		              <label for="c_order_notes" class="text-black">Order Notes<span class="text-danger">*</span></label>
		              <textarea name="note" id="note" cols="30" rows="5" class="form-control" placeholder="Please note: 'COD' if Cash on Delivery used and Bank + grandtotal (Bank 3100) if you use banking method"></textarea>
		            </div>

		          </div>
		        </div>
		       
		        <div class="col-md-6">
		          <div class="row mb-5">
		            <div class="col-md-12">
		              <h2 class="h3 mb-3 text-black">Your Order</h2>
		              <div class="p-3 p-lg-5 border bg-white">
		                <table class="table site-block-order-table mb-5">
		                  <thead>
		                    <th>Product</th>
		                    <th>Price per each</th>
		                    <th> Subtotal </th>
		                  </thead>
		                  <tbody>
		                 
		                  <c:forEach items="${requestScope.cartID}" var="pro">
		                  
		                    <tr>
		                      <td>${pro.product_name} <strong class="mx-2">x</strong> ${pro.quantity}</td>
		                      <td>$ ${pro.price} </td>
		                      <td>= <span>$ ${pro.quantity*pro.price}</span></td>
		                      
		                    </tr>
		                 	<tr>
		                 		<td>Shipping cost:  </td>
		                 		<td>$15</td>
		                 	</tr>
		                    
		                   </c:forEach> 
		                    <tr>
		                      <td class="text-black font-weight-bold"><strong>Grand total</strong></td>
		                      <td class="text-black" colspan="2" id="total">$<c:out value="${grandTotal}"></c:out></td>
		                    </tr>
		                    
		                  </tbody>
		                </table>

		                <div class="border p-3 mb-3">
		                  <h3 class="h6 mb-0"><a class="d-block" data-bs-toggle="collapse" href="#collapsebank" role="button" aria-expanded="false" aria-controls="collapsebank">Direct Bank Transfer</a></h3>

		                  <div class="collapse" id="collapsebank">
		                    <div class="py-2">
		                      <p class="mb-0" style="color: black">
								CASH ON DELIVERY (C.O.D), simple, convenient!
										                      
								</p>
		                    </div>
		                  </div>
		                </div>

		                <div class="border p-3 mb-3">
		                  <h3 class="h6 mb-0"><a class="d-block" data-bs-toggle="collapse" href="#collapsecheque" role="button" aria-expanded="false" aria-controls="collapsecheque">Cheque Payment</a></h3>

		                  <div class="collapse" id="collapsecheque">
		                    <div class="py-2" >
								<p style="color: black">
								When processing telegraphic transfer via Bank, please write <br>
								NAME + PHONE NUMBER in transfering description in order to verify your purchase. Thank you so much <br>
								►ACCOUNT<br>
								- VIETINBANK brand Hai Ba Trung: 0354966799 - Ludwig Tran
								</p>		                    
		                    
		                    </div>
		                  </div>
		                </div>

		               
		                
		                <div class="form-group">
		               		<%-- <a href="/ProjectShop/home?page=checkout&total=<c:out value="${grandTotal}" />"> --%>
		               		
		               	
		                 		 <button onclick="checkout(${grandTotal})" class="btn btn-outline-success btn-lg py-3 btn-block">Place Order </button>
							</a>		               
		                </div>
		                
		                

		              </div>
		            </div>
		          </div>

		        </div>
		      </div>
	
	</div>
	
	
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
<script type="text/javascript">
function checkout(total) {
	var address = document.getElementById("address");
	var note = document.getElementById("note");
	const url = "/ProjectShop/home?page=checkout&address="+address.value+"&note="+note.value +"&total="+total;
	window.location.href = url;			
}

</script>
</body>
</html>