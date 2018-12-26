<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DashBoard_Change Password</title>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link href="css/DashBoard.css" rel="stylesheet">
    <style>
    	.btn-myStyle{
		    color: #fff;
		    background-color: #594c4b;
		    border-color: #594c4b;
		}
		
		.btn-myStyle:hover{
		    color: #fff;
			background-color: #826f6e;
		}
    </style>
</head>
<body>
	<!-- 上方layout使用動態引入 -->
	<jsp:include page="DashBoard_top.jsp"></jsp:include>
	
	<div class="container-fluid">
	  <div class="row">
		<!-- 左方layout使用靜態引入 -->
	    <%@include file="DashBoard_left.jsp" %>
	
	    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
	      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	        <h1 class="h2">Change Password</h1>
	      </div>
	      <div class="row col-md-6">
	      	<form class="needs-validation" action="SignIn" method="post">
			  	<input type="hidden" name="oper" value="signIn"><!-- 用於後端判斷執行內容 -->
			  	<div class="mb-3">
					<label for="inputPassword">New Password</label>
					<input type="password" id="newPassword" class="form-control" placeholder="New Password">
				</div>
				<div class="mb-3">
					<label for="inputPassword">Confirm Password</label>
					<input type="password" id="" class="form-control" placeholder="Confirm Password">
				</div>
		      <hr class="mb-4">
			  <% 
			  	String errorMessage = (String)request.getAttribute("errorMessage");
			  	if(errorMessage != null){ 
			  %>
			  	<p style="color:red">Incorrect username or password.</p>
			  <% } %>
			  <button class="btn btn-lg btn-myStyle" type="submit">Confirm</button>
			</form>
	      </div>
	</div>	
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>