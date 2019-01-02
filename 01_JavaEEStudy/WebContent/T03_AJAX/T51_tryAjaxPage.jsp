<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>T51_tryAjaxPage</title>
	<!-- 聲明js代碼塊 -->
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
	<!-- 
	1.ajax的概念：局部刷新技術，不是一門新技術，是多種技術的組合，是瀏覽器端的技術
	2.ajax的作用：實現在當前結果頁中顯示其他請求的響應內容
	3.ajax的使用
		ajax的基本流程
			創建ajax引擎對象
			覆寫onreadystatement函數
				判斷ajax狀態碼
					判斷響應狀態碼
						獲取響應內容(響應內容的格式)
							普通字符串
							json【重點】：其實就是講述數據按照json 的格式排版好的字符串，方便使用eval方法，將接受的字符串數據直接轉換為js的對象
								json格式：
									var 對象名={
										屬性名:屬性值,
										屬性名:屬性值,
										…
									}
							xml
						處理響應內容(js操作文檔結構)
			發送請求
				get請求：get的請求實體排接在url後面，以?隔開，鍵值對
					ajax.open("get", url);
					ajax.send(null);
				post請求：有單獨的請求實體
					ajax.open("post", url);
					ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");//和瀏覽器說用鍵值對的方式來讀取信息
					ajax.send("uname=Mickey&pwd=233");
		ajax的狀態碼
			ajax狀態碼
				readyState:0, 1, 2, 3, 4(表示響應內容被成功接收)
				響應狀態碼：status:200, 404, 500
		ajax的異步和同步
			ajax.open(method, url, async);
				asyne：false為同步代碼執行，true為異步代碼執行(默認)
	 -->
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
				ajax = new ActiveXObject("Msxml2.XMLHTTP");
			}
			//覆寫onreadystatement函數
			ajax.onreadystatechange = function(){
				//判斷ajax狀態碼
				if(ajax.readyState==4){
					//判斷響應狀態碼
					if(ajax.status==200){
						//獲取響應內容
						var result = ajax.responseText;
						//獲取元素對象
						var showdiv = document.getElementById("showdiv");
						showdiv.innerHTML = result;
						alert("ajax完成顯示任務");
					}else if(ajax.status==404){
						var showdiv = document.getElementById("showdiv");
						showdiv.innerHTML = "請求資源不存在";
					}else if(ajax.status==500){
						var showdiv = document.getElementById("showdiv");
						showdiv.innerHTML = "服務器繁忙";
					}
				}else{//當ajax還沒獲取完成時顯示loading圖示
					//獲取元素對象
					var showdiv = document.getElementById("showdiv");
					showdiv.innerHTML = "<img src='loading.gif' width='200px' height='100px'/>";
				}
			}
			//發送請求
			ajax.open("get", "/01_JavaEEStudy/52_test");//get使用，默認是異步
			ajax.send(null);//post使用
			alert("異步指的是多線程");
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
	 <h3>T51_tryAjaxPage</h3>
	 <hr>
	 <input type="button" value="test" onclick="getData()">
	 <div id = "showdiv"></div>
</body>
</html>