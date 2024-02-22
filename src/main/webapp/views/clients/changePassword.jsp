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
	<div class="container" style="padding-top: 100px">
	<!-- cart -->
		<div class="row">
			<div class="col-lg-9">
				<h3 class="mt-3">Hi, ${sessionScope.client.getFullname()}</h3><br>
			</div>
			<c:if test="${requestScope.error != null }">
				<p class="alert alert-danger">${requestScope.error }</p>
			</c:if>
			<div>
				<form style="font-size: 15px" name="form" action="/ProjectShop/password" class="form-group" method="post">
							
					<label>Your current password:</label>
					<input type="password" name="password" class="form-control">
					<label>Your new password:</label>
					<input  type="password" name="newPassword" class="form-control" id="newPassword" minlength="8" onchange="checkPass()">
					<label>Re - new password:</label>
					<input type="password" name="rePassword" class="form-control" id="rePassword" minlength="8" onchange="checkRepassword()">
					<input type="submit" onclick="checkall()" value="Submit" class="btn btn-outline-primary mt-3">
				</form>
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
<script>
	function checkRepassword() {
		var newPassword = document.getElementById("newPassword");
		var rePassword = document.getElementById("rePassword");

		if(newPassword.value != rePassword.value){
			alert("Your new password is not matched");
			newPassword.focus();
			return false;
		}else 
			return true;
	}
	function checkPass(){
	/* 	cont a = 0, b = 0, c = 0; */
        const pw = document.forms["form"].newPassword.value;
        // 2 kiểm tra password có ký tự viết hoa hay không
        if(!/[^A-Za-z0-9]/.test(pw)){
            alert('password phải chứa ký tự đặc biệt');
            return false;
        }else{
        	if (!/[A-Z]/.test(pw)) {
                alert('password phải chứa ký tự viết hoa');
                return false;
            }
        	else{
                if(!/[a-z]/.test(pw)){
                    alert('password phải chứa ký tự viết thường');
                    return false;
                   } else return true;
        	}
        }

    }

    function checkall(){
 
        if(checkRepassword() && checkPass()){
           /*  alert("nhập thành công"); */
        }
        else alert("nhập fail");
    }
</script>
</body>
</html>