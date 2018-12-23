<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sign Up</title>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    
    <style>
    	body {
			background-color: #f5f5f5;
		}
		
		*{
    		color: #594c4b;
		}
		
		.input-group-text{
    		color: #594c4b;
		}

		.btn-myStyle{
		    color: #fff;
		    background-color: #594c4b;
		    border-color: #594c4b;
		}
		
		.btn-myStyle:hover{
		    background-color: #826f6e;
		}
    </style>
</head>
<body class="container">
	<div class="py-5 text-center">
	    <img class="d-block mx-auto mb-4" src="image/myLogo.png" alt="myLogo" height="100">
	    <h2>Sign Up</h2>
	    <p class="lead">Below is an example form built entirely with Bootstrap’s form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>
	</div>
	
	<div class="row justify-content-md-center">
	    <div class="col-md-6 order-md-1">	
	    	<form class="needs-validation">
				<div class="mb-3">
					<label for="username">User name</label>
					<input type="text" class="form-control" id="uname" placeholder="Username">
					<div class="invalid-feedback" style="width: 100%;">
						Your username is required.
			        </div>
			   	</div>
			   	
			    <div class="mb-3">
					<label for="inputPassword">Password</label>
			  		<input type="password" id="password" class="form-control" placeholder="Password">
			    </div>		
		        <hr class="mb-4">
		        
		        <div class="row">
					<div class="input-group col-md-6 mb-3">
						<div class="input-group-prepend">
					    	<label class="input-group-text" for="inputGroupSelect01">Gender</label>
					  	</div>
						<select class="custom-select" id="inputGroupSelect01">
						    <option selected>Choose...</option>
						    <option value="1">Male</option>
						    <option value="2">Female</option>
						</select>
					</div>
					<div class="input-group col-md-6 mb-3">
  						<div class="input-group-prepend">
    						<span class="input-group-text">Age</span>
  						</div>
  						<input type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)">
					</div>
				</div>
				
				<div class="mb-3">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
						    <span class="input-group-text">Birth</span>
						</div>
						<input type="text" placeholder="Year" aria-label="Year" class="form-control">
						<input type="text" placeholder="Month" aria-label="Month" class="form-control">
						<input type="text" placeholder="Day" aria-label="Day" class="form-control">
					</div>
				</div>
	        	<hr class="mb-4">
	        	
	        	<button class="btn btn-primary btn-lg btn-block btn-myStyle" type="submit">Continue to checkout</button>
	      	</form>
	      	<div class="row justify-content-md-center">
	    		<a href="SignIn.jsp">Return to Sing In</a>
	    	</div>
	    </div>
	  </div>

	<footer class="my-5 pt-5 text-muted text-center text-small">
    	<p class="mb-1">© 2018/12/23</p>
  	</footer>
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>