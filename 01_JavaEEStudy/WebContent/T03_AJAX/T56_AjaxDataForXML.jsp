<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>T56_AjaxDataForXml</title>
	 <!-- 聲明js代碼域 -->
	 <script type="text/javascript">
	 	//獲取數據
	 	function getDataXML(){
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
		 				var result = ajax.responseXML;//使用xml方式，返回document對象
		 				alert(result.getElementsByTagName("uname")[0].innerHTML);//獲取元素對象
		 				
		 				var ta = document.getElementById("ta");//獲取table對象
		 				//查詢結果
		 				var tr = ta.insertRow(1);//插入新的行
		 				var cell0 = tr.insertCell(0);
		 				cell0.innerHTML = result.getElementsByTagName("uid")[0].innerHTML;
		 				var cell1 = tr.insertCell(1);
		 				cell1.innerHTML = result.getElementsByTagName("uname")[0].innerHTML;
		 				var cell2 = tr.insertCell(2);
		 				cell2.innerHTML = result.getElementsByTagName("price")[0].innerHTML;
		 				var cell3 = tr.insertCell(3);
		 				cell3.innerHTML = result.getElementsByTagName("loc")[0].innerHTML;
		 				var cell4 = tr.insertCell(4);
		 				cell4.innerHTML = result.getElementsByTagName("desc")[0].innerHTML;
		 			}
		 		}
		 	}
		 	//發送請求
		 	ajax.open("get", "/01_JavaEEStudy/56_test?name=" + name);
		 	ajax.send(null);
	 	}
	 </script>
</head>
<body>
	<h3>T56_AjaxDataForXml</h3>
	<hr>
	佣兵名稱：
	<input type="text" name="uname" value="" id="uname">
	<input type="button" value="Serch" onclick="getDataXML()">
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