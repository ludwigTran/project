<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:url value ="/views/admin" var="url"> </c:url>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Ministore</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${url }/assets/img/favicon.png" rel="icon">
  <link href="${url }/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${url }/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${url }/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${url }/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${url }/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="${url }/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="${url }/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="${url }/assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${url }/assets/css/style.css" rel="stylesheet">

</head>

<body>

  <main>
    <div class="container">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="index.html" class="logo d-flex align-items-center w-auto">
                  <img src="${url }/assets/img/logo.png" alt="">
                  <span class="d-none d-lg-block">Ministore</span>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4">Login to Your Account</h5>
                    <p class="text-center small">Enter your username & password to join us!</p>
                  </div>
					<!-- Check if username is existed -->
                    <c:if test="${requestScope.signupError != null }">
                      <p class="alert alert-danger">${requestScope.signupError }</p>
                      </c:if>
                  <form class="row g-3 needs-validation" action="/ProjectShop/signup" method="post" name="form">
					
                    <div class="col-12">
                      <label for="yourUsername" class="form-label">Full name</label>
                      <div class="input-group has-validation">
                        
                        <input type="text" name="fullname" class="form-control" minlength="10" required>
                      </div>
                    </div>
                    
                    <div class="col-12">
                      <label for="yourUsername" class="form-label">Username</label>
                      <div class="input-group has-validation">
                        
                        <input type="text" name="username" class="form-control" minlength="5" required>
                      </div>
                    </div>
                    
                    <div class="col-12">
                      <label for="yourUsername" class="form-label">password</label>
                      <div class="input-group has-validation">
                        
                        <input type="password" name="newPassword" class="form-control" id="newPassword"  onchange="checkPass()" minlength="8" required>
                      </div>
                    </div>
 
                    <div class="col-12">
                      <label for="yourPassword" class="form-label">Re-Password</label>
                      <input type="password" name="repassword" class="form-control" id="rePassword" onchange="checkRepassword()" required>
                    </div>
                    
                    <div class="col-12">
                      <label for="yourUsername" class="form-label">Phone number</label>
                      <div class="input-group has-validation">
                        
                        <input type="text" name="phonenumber" class="form-control" pattern="0[0-9]{9}" maxlength="10" placeholder="only number accepted" required>
                      </div>
                    </div>
                    
                    <div class="col-12">
                      <label for="yourUsername" class="form-label">email</label>
                      <div class="input-group has-validation">
                        
                        <input type="text" name="email" pattern="[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$" class="form-control" placeholder="abc@gmail.com" required>
                      </div>
                    </div>
                    
                    <div class="col-12">
                      <label for="yourUsername" class="form-label">address</label>
                      <div class="input-group has-validation">
                        
                        <input type="text" name="address" class="form-control" placeholder="This address to place order!" required>
                      </div>
                    </div>

                    <div class="col-12">
                      <div class="form-check">
                      
        
                      
                    </div>
                    
                    
                    <div class="col-12">
                      <div class="form-check">
                        <input class="form-check-input" name="terms" type="checkbox" value="" id="acceptTerms" required>
                        <label class="form-check-label" for="acceptTerms">I agree and accept the <a href="#">terms and conditions</a></label>
                        <div class="invalid-feedback">You must agree before submitting.</div>
                      </div>
                    </div>
                    <div class="col-12">
                      <button class="btn btn-primary w-100" onclick="checkall()" type="submit">Create Account</button>
                    </div>
                
                    <div class="col-12">
                      <p class="small mb-0">Already have an account? <a href="/ProjectShop/views/clients/loginClient.jsp">Log in</a></p>
                    </div>
                  </form>

                </div>
              </div>


            </div>
          </div>
        </div>

      </section>

    </div>
  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="${url }/assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="${url }/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${url }/assets/vendor/chart.js/chart.min.js"></script>
  <script src="${url }/assets/vendor/echarts/echarts.min.js"></script>
  <script src="${url }/assets/vendor/quill/quill.min.js"></script>
  <script src="${url }/assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="${url }/assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="${url }/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="${url }/assets/js/main.js"></script>
  
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
            /* alert("Thanks for signing! Let's login now!"); */
        }
        else alert("Failed sign up! Please check your info!");
    }
</script>

</body>

</html>