<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sign In</title>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="css/SignIn.css">
</head>
<body class="text-center">
    <form class="form-signin" action="SignIn" method="post">
	  <img class="mb-4" src="image/myLogo.png" alt="myLogo" height="100">
	  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
	  <input type="hidden" name="oper" value="signIn"><!-- 用於後端判斷執行內容 -->
	  
		  <label for="input" class="sr-only">User name</label>
		  <input type="text" name="uname" value="" class="form-control" placeholder="User name" required>
		  <div class="invalid-feedback">
         	Valid first name is required.
          </div>
	  
		  <label for="inputPassword" class="sr-only">Password</label>
		  <input type="password" name="password" value="" class="form-control" placeholder="Password" required>
		  <div class="invalid-feedback">
         	Valid first name is required.
          </div>
	  
	  <div class="checkbox mb-3">
	    <label>
	      <input type="checkbox" name="remenberMe" value="remenberMe"> Remember me
	    </label>
	  </div>
	  <% 
	  	String errorMessage = (String)request.getAttribute("errorMessage");
	  	if(errorMessage != null){ 
	  %>
	  	<p style="color:red">Incorrect username or password.</p>
	  <% } %>
	  <button class="btn btn-lg btn-myStyle btn-block" type="submit">Sign in</button>
	      	<div class="row justify-content-md-center">
	    		<a href="SignUp.jsp">Sign up</a>
	    	</div>
	  <p class="mt-5 mb-3 text-muted">© 2018/12/23</p>
	</form>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>