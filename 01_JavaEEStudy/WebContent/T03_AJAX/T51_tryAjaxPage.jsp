<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>T51_tryAjaxPage</title>
	<!-- 聲明js代碼塊 -->
	<script type="text/javascript">
		function getData(){
			//無使用ajax技術時使用的方法
			//var showdiv = document.getElementById("showdiv");
			//showdiv.innerHTML = "測試測試使用AJAX";
			
			//使用ajax
			//創建ajax引擎對象
				var ajax;
				if(window.XMLHttpRequest){//火狐
					ajax = new XMLHttpRequest();
				}else if(window.ActiveXObject){//舊版IE
					ajax = new ActiveXObject("Msxm12.XMLHTTP");
				}
			//覆寫onreadystatement函數
			ajax.onreadystatechange = function(){
				//獲取響應內容
				var result = ajax.responseText;
				//獲取元素對象
				var showdiv = document.getElementById("showdiv");
				showdiv.innerHTML = result;
			}
			//發送請求
			ajax.open("get", "/01_JavaEEStudy/52_test");//get使用
			ajax.send(null);//post使用
		}
	</script>
	<style type="text/css">
		#showdiv{
			border: solid 1px;
			width: 200px;
			height: 100px;
		}
	</style>
</head>
<body>
	<!-- 
	AJAX
	簡介：異步刷新技術，用來在當前頁面內響應不同的請求內容
	為什麼需要AJAX
		需求：有時候我們需要將本次的響應潔果和前面的響應結果內容在同一個頁面中展現給用戶
		解決：在後台服務器端將多次響應內容重新拼接成一個jsp頁面，響應；但是這會造成很多響應內容裡重複的響應，資源浪費
			使用AJAX
	使用AJAX
		AJAX訪問原理
		AJAX的基本使用流程
		AJAX的狀態碼
		AJAX的異步和同步
		AJAX的請求
		AJAX的響應數據類型
		AJAX的封裝
		AJAX案例
	 -->
	 <h3>T51_tryAjaxPage</h3>
	 <hr>
	 <input type="button" value="test" onclick="getData()">
	 <div id = "showdiv"></div>
</body>
</html>