<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>T56_AjaxFz</title>
	<script type="text/javascript">
	/*
	method：請求方式，值為get或post
	url：請求地址
	data：沒有值需要傳入null；有請求數據則傳入字符串數據，格式為"a=1&b=2"
	deal200：接受一個帶有一個形參的js函數對象，形參接收的實參是ajax引擎對象
	deal404：接受一個js函數對象
	deal500：接受一個js函數對象
	
	*/
		function myAjax(method, url, data, deal200, deal404, deal500, asyne){
			//創建ajax引擎對象
			var ajax = getAjax();
			
			//覆寫onreadystatement函數
			ajax.onreadystatechange = function(){
				//判斷ajax狀態碼
				if(ajax.readyState==4){
					//判斷響應狀態碼
					if(ajax.status==200){
						if(deal200){
							deal200(ajax);
						}
					}else if(ajax.status==404){
						if(deal404){
							deal404(ajax);
						}
					}else if(ajax.status==500){
						if(deal500){
							deal500(ajax);
						}
					}
				}else{
					//因為是做簡單的封裝，當ajax還沒獲取完成時不做任何動作
				}
			}
			
			//發送請求
			if(method=="get"){
				//發送請求，get
				ajax.open("get", url + (data==null?"":"?"+data), asyne);
				ajax.send(null);				
			}else if(method=="post"){
				//發送請求，post
				ajax.open("post", url);
				ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");//和瀏覽器說用鍵值對的方式來讀取信息
				ajax.send(data);				
			}//除get、post外的請求
		}
		
		/*使用
		function myAjax("get", "ajax", null, function(a){
		//可寫要執行的動作	
		}, true);
		*/
/*-------------------------------------------------------------*/
		function getAjax(){
			var ajax;
			if(window.XMLHttpRequest){//火狐
				ajax = new XMLHttpRequest();
			}else if(window.ActiveXObject){//舊版IE
				ajax = new ActiveXObject("Msxml2.XMLHTTP");
			}
			return ajax;
		}
		
		var deal200 = function(ajax){
			//獲取元素對象
			var showdiv = document.getElementById("showdiv");
			showdiv.innerHTML = result;
			alert("ajax完成顯示任務");
		}
		
	</script>
</head>
<body>

</body>
</html>