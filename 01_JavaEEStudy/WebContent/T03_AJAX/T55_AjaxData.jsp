<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>T55_AjaxData</title>
	<!-- 
	需求分配：
		1.在當前頁面內顯示查詢結果，考慮使用ajax
		2.創建ajax函數
		3.調用ajax函數發送請求到UserServlet
		4.調用業務層獲取對應的數據
	 -->
	 <!-- 聲明js代碼域 -->
	 <script type="text/javascript">
	 	//獲取數據
	 	function getData(){
			alert("ajax開始查詢任務");
	 		//獲取用戶請求信息
	 		var name = document.getElementById("uname").value;
	 		//創建ajax引擎對象
	 		var ajax;
			if(window.XMLHttpRequest){//火狐
				ajax = new XMLHttpRequest();
			}else if(window.ActiveXObject){//舊版IE
				ajax = new ActiveXObject("Msxml2.XMLHTTP");
			}
		 	//覆寫onreadyStatechange
		 	ajax.onreadystatechange = function(){
		 		//判斷ajax狀態碼
		 		if(ajax.readState==4){
		 			//判斷響應狀態碼
		 			if(ajax.status==200){
		 				//獲取響應數據
		 				//處理響應數據
		 			}
		 		}
		 	}
		 	//發送請求
		 	ajax.open("get", "/01_JavaEEStudy/55_test?name=" + name);
		 	ajax.send(null);
	 	}
	 </script>
</head>
<body>
	<h3>T54_AjaxGetPost</h3>
	<hr>
	佣兵名稱：
	<input type="text" name="uname" value="" id="uname">
	<input type="button" value="Serch" onclick="getData()">
	<hr>
	<table border="1px">
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