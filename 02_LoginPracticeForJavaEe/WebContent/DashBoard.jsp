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
	<!-- 上方layout使用動態引入 -->
	<jsp:include page="DashBoard_top.jsp"></jsp:include>
	
	<div class="container-fluid">
	  <div class="row">
		<!-- 左方layout使用靜態引入 -->
	    <%@include file="DashBoard_left.jsp" %>
	
	    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
	      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	        <h1 class="h2">Dashboard</h1>
	      </div>

	      <h2>Section title</h2>
	      <div class="table-responsive">
	        <table class="table table-striped table-sm">
	          <thead>
	            <tr>
	              <th>uid</th>
	              <th>uname</th>
	              <th>gender</th>
	              <th>age</th>
	              <th>birth</th>
	            </tr>
	          </thead>
	          <tbody>
	            <tr>
	              <td><%= ((UserDTO)request.getSession().getAttribute("user")).getUid() %></td>
	              <td><%= ((UserDTO)request.getSession().getAttribute("user")).getUname() %></td>
	              <% 
					int userGender = ((UserDTO)request.getSession().getAttribute("user")).getGender();
		            String gender;
		            if(userGender == 1){
		            	gender = "Male";	
		            } else if (userGender == 2){
		            	gender = "Female";
		            } else{
		            	gender = "";
		            }
		          %>
	              <td><%= gender %></td>
	              <td><%= ((UserDTO)request.getSession().getAttribute("user")).getAge() %></td>
	              <td><%= ((UserDTO)request.getSession().getAttribute("user")).getBirth() %></td>
	            </tr>
	          </tbody>
	        </table>
	      </div>
	    </main>
	  </div>
	</div>
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>