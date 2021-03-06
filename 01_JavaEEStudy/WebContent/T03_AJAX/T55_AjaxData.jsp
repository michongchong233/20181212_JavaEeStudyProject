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
		 		if(ajax.readyState==4){
		 			//判斷響應狀態碼
		 			if(ajax.status==200){
		 				//獲取響應數據
		 				var result = ajax.responseText;
		 				//eval(result);//使用字符串的方式
		 				eval("var u="+result);//使用json的方式
		 				alert(u.uname);
		 				//處理響應數據
		 				var ta = document.getElementById("ta");//獲取table對象
		 				ta.innerHTML = "";
		 				
		 				//表頭
		 				var tr = ta.insertRow(0);//插入新的行
		 				var cell0 = tr.insertCell(0);
		 				cell0.innerHTML = "編號";
		 				var cell1 = tr.insertCell(1);
		 				cell1.innerHTML = "名稱";
		 				var cell2 = tr.insertCell(2);
		 				cell2.innerHTML = "價格";
		 				var cell3 = tr.insertCell(3);
		 				cell3.innerHTML = "位置";
		 				var cell4 = tr.insertCell(4);
		 				cell4.innerHTML = "描述";
		 				
		 				//查詢結果
		 				var tr = ta.insertRow(1);//插入新的行
		 				var cell0 = tr.insertCell(0);
		 				cell0.innerHTML = u.uid;
		 				var cell1 = tr.insertCell(1);
		 				cell1.innerHTML = u.uname;
		 				var cell2 = tr.insertCell(2);
		 				cell2.innerHTML = u.price;
		 				var cell3 = tr.insertCell(3);
		 				cell3.innerHTML = u.loc;
		 				var cell4 = tr.insertCell(4);
		 				cell4.innerHTML = u.desc;
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
	<h3>T55_AjaxData</h3>
	<hr>
	佣兵名稱：
	<input type="text" name="uname" value="" id="uname">
	<input type="button" value="Serch" onclick="getData()">
	<hr>
	<table border="1px" id="ta">
		<!-- 
		<tr>
			<td>編號</td>
			<td>名稱</td>
			<td>價格</td>
			<td>位置</td>
			<td>描述</td>
		</tr>
		 -->
	</table>
</body>
</html>