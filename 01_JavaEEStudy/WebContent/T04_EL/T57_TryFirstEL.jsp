<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>T57_TryFirstEL</title>
</head>
<body>
	<h3>T57_TryFirstEL</h3><hr>
	<!-- 使用傳統的方式獲取作用域的對象 -->
	<p><%= request.getParameter("uname") %> -- <%= request.getParameter("pwd") %></p>
	<p><%= request.getAttribute("str") %></p>

</body>
</html>