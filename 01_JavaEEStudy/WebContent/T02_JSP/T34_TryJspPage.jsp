<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="T34_ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T34_TryJspPage</title>
</head>
<body>
	<p>T34_TryJspPage</p>
<%-- 
注釋：
	前端注釋(html & css)：會被轉釋和發送，但不會被瀏覽器執行
	Java注釋：會被轉釋，但不被Servlet執行
	JSP注釋：不會被轉釋 
JSP指令：<%@ page  %>
	language：聲明JSP要被轉釋的語言
	import：聲明轉釋的java文件要導入的包，不同的包用,分開
	pageEncoding：設置JSP文件的數據編碼格式
	contentType：設置JSP響應給瀏覽器的解析和編碼格式
	session：設置轉釋的Servlet中是否開啟Session支持，默認開啟為true
	errorPage：設置JSP運行錯誤跳轉的頁面
	extends：設置JSP轉釋的java文件要繼承的父類(包名.類名)
JSP的局部代碼塊：<%  %>
	特點：局部代碼塊聲明的java代碼會被原樣轉釋到jsp對應的servlet文件的_jspService方法中，在局部代碼塊聲明的變量都是局部變量
	缺點：使用局部代碼塊在JSP中做邏輯判斷，書寫麻煩、閱讀困難
	使用：使用Servlet進行請求邏輯處理，使用JSP進行頁面展現
JSP的全局代碼塊：<%! %>
	特點：聲明的java代碼作為全局代碼轉釋到Servlet類中
	注意：用全局代碼塊聲明，用局部代碼塊調用
JSP的腳本段語句：<%= 變量或方法 %>
	特點：幫助我們快速地獲取變量或方法的返回值，作為數據侷應給瀏覽器，相當於out.write(變量或方法);
	注意：不能在裡面加;，會報錯
	位置：除JSP語法要求以外的任意位置

--%>
	<% //int i = 5/0;//編釋無錯誤但執行錯誤，會轉到errorPage中所指定的頁面 %>
	<!-- JSP的局部代碼塊 -->
	<% 
		int j = (int)(java.lang.Math.random()*100); 
		System.out.println("j=" + j);
	%>
	<% if(j<50) { %>
		<p>小於50</p>
	<% }else{ %>
		<p>大於50</p>	
	<% } %>
	<!-- JSP的全局代碼塊 -->
	<%! public void test_T35(){
		System.out.println("全局代碼塊聲明");
	} %>
	<% test_T35(); %>
	
	<!-- JSP的腳本段語句 -->
	<% out.write("j=" + j); %><%-- 這樣寫太麻煩 --%>
	<%= "j=" + j %>

</body>
</html>