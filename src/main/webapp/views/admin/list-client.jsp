<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value ="/views/admin" var="url"> </c:url>
    
 <%
	if(session.getAttribute("usernameAD")==null){
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
  <link href="${url}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${url}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${url}/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${url}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${url}/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="${url}/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="${url}/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="${url}/assets/vendor/simple-datatables/style.css" rel="stylesheet">
  
  

  <!-- Template Main CSS File -->
  <link href="${url}/assets/css/style.css" rel="stylesheet">
  <!--  datatable js -->
 <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.css" />  
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.js"></script>

  <!-- =======================================================
  * Template Name: NiceAdmin - v2.4.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  
 
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />


</head>

<body>


  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="/ProjectShop/admin" class="logo d-flex align-items-center">
        <img src="${url}/assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">Ministore</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->


  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  
<%@include file="/layout/sidebar.jsp" %>
  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Product Category</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/Project/list-product">Home</a></li>
          <li class="breadcrumb-item active">Products</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
      <div class="row">

 	<div class="card">
            <div class="card-body">
            <h5 class="card-title">List of our users</h5>
            
             <table class="table table-hover" id="mytable" >
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Username</th>
                    <th scope="col">Fullname</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                   	<th scope="col">Address</th>
                   	<th scope="col">Action</th>

                   	
                  </tr>
                  </thead>
                   <tbody>
							  <c:forEach items ="${requestScope.listCl }" var="user">
									<tr>
										<td>${user.id }</td>
										<td>${user.username}</td>
									
										<td>${user.fullname }</td>
										<td>${user.phonenumber }</td>
										<td>${user.email }</td>
										<td>${user.address }</td>
										<td> <a onclick="deleteC(${user.id })"> <button class="btn btn-outline-danger">Delete</button> </a> </td>

									</tr>

								</c:forEach> 

					</tbody>
                  </table>
                  
                
            
            
            </div>
            
     </div>
        
      </div>
    </section>

  </main><!-- End #main -->




  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="${url}/assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="${url}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${url}/assets/vendor/chart.js/chart.min.js"></script>
  <script src="${url}/assets/vendor/echarts/echarts.min.js"></script>
  <script src="${url}/assets/vendor/quill/quill.min.js"></script>
  <script src="${url}/assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="${url}/assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="${url}/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="${url}/assets/js/main.js"></script>
<!-- tao chuc nang xoa -->
  <script type="text/javascript">
  function deleteC(id){
	  if(confirm("Are you sure to delete this client ?"))
		  window.location = "/ProjectShop/deleteClient?client_id="+id;
  }
  </script>
  
 
<script type="text/javascript">
$(document).ready( function () {
    $('#mytable').DataTable();
} );
</script>

</body>

</html>