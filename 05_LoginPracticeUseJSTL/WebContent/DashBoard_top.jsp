<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.mickey.dto.UserDTO"
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DashBoard</title>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link href="css/DashBoard.css" rel="stylesheet">
</head>
<body class="text-center">
	<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  		<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Hi ${user}</a>
  		<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  		<ul class="navbar-nav px-3">
	    	<li class="nav-item text-nowrap">
	      		<a class="nav-link" href="javascript:void(0)" id="out">Sign out</a>
	    	</li>
 		</ul>
	</nav>
	
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <script>
    	$(function(){
    		//sign out
    		$("#out").click(function(){
    			var flag = window.confirm("really?");
    			if(flag){
    				window.top.location.href="SignIn.jsp?oper=out";
    			}
    		})
    	})
    </script>
</body>
</html>