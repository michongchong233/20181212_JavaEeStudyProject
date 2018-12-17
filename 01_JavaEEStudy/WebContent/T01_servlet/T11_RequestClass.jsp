<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T11_RequestClass</title>
</head>
<body>
	<form action="http://localhost:8080/01_JavaEEStudy/11_test" method="get">
		用戶名：<input type="text" name="uname" value=""><br>
		密碼：<input type="password" name="pwd" value=""><br>
		愛好：<br>
		<input type="checkbox" name="fav" value="1">打球<br>
		<input type="checkbox" name="fav" value="2">畫圖<br>
		<input type="checkbox" name="fav" value="3">玩電腦<br>
		<input type="checkbox" name="fav" value="4">散步<br>
		<input type="submit" value="確認">
	</form>
</body>
</html>