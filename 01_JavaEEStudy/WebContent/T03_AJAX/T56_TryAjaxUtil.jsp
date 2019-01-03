<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>T56_TryAjaxUtil</title>
	 <!-- 聲明js代碼域 -->
	<script src="T56_AjaxUtil.js"></script>
	<script type="text/javascript">
	 	function tryAjaxUtil(){
			alert("ajax開始查詢任務");
	 		var name = document.getElementById("uname").value;
	 		var data = "name=" + name;
	 		myAjax("get", "/01_JavaEEStudy/56_test", date, function(ajax){
	 			//獲取響應數據
	 			var rs = ajax.responseText;
	 			//處理響應數據
	 			alert(rs);
	 		});
	 	}
	 	
	</script>
</head>
<body>
	<h3>T56_TryAjaxUtil</h3>
	<hr>
	佣兵名稱：
	<input type="text" name="uname" value="" id="uname">
	<input type="button" value="Serch" onclick="tryAjaxUtil()">
	<hr>
	<table border="1px" id="ta">
		<tr>
			<td>編號</td>
			<td>名稱</td>
			<td>價格</td>
			<td>位置</td>
			<td>描述</td>
		</tr>
	</table>
</body>
</html>