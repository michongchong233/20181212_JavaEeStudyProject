<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>T54_AjaxGetPost</title>
	<script type="text/javascript">
		function getData(){
			//獲取請求數據
			var uname = document.getElementById("uname").value;
			var pwd = document.getElementById("pwd").value;
			var data = "uname=" + uname + "&pwd=" + pwd;
			//創建ajax引擎對象
			var ajax;
			if(window.XMLHttpRequest){
				ajax = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				ajax = new ActiveXObject("Msxml2.XMLHTTP");
			}
			//覆寫onreadystatechange函數
			ajax.onreadystatechange = function(){
				//判斷ajax狀態碼
				if(ajax.readyState==4){
					//判斷響應狀態碼
					if(ajax.status==200){
						//獲取響應內容
						var result = ajax.responseText;
						//處理響應內容
						alert(result);
					}
					
				}
				
			}
			//發送請求
			//get方式
			//ajax.open("get", "/01_JavaEEStudy/52_test?" + data);
			//ajax.send(null);
			//post方式
			ajax.open("post", "/01_JavaEEStudy/52_test");
			ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");//和瀏覽器說用鍵值對的方式來讀取信息
			ajax.send(data);
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
	 <h3>T54_AjaxGetPost</h3>
	 <hr>
	 <form action="" enctype="application/x-www-from-urlencoded"></form>
	 <input type="text" name="uname" value="" id="uname"><br>
	 <input type="password" name="pwd" value="" id="pwd">
	 <input type="button" value="test" onclick="getData()">
	 <div id = "showdiv"></div>

</body>
</html>