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
JSP的靜態引入和動態引入：
	靜態引入：<%@include file="要引入的JSP文件的相對路徑" %>
		特點：會將引入的JSP文件和當前的JSP文件轉釋成一個Servlet類中，在網頁中也就顯示合并後的顯示效果
		注意：靜態引入引入的JSP文件不會單獨轉釋成Servlet，當前文件和靜態引入的文件中不能使用java代碼塊的同名變量
	動態引入：<jsp:include page="要引入的JSP文件的相對路徑"></jsp:include>
		特點：會將引入的JSP文件單獨轉釋，在當前轉釋的Servlet文件中調用引入的JSP文件的轉釋文件(方法調用方法)，在網頁中顯示合并後的顯示效果
		注意：動態引入允許文件中聲明同名變量
	優點：降底JSP代碼的冗余，便於維護和升級
JSP的轉發標簽：<jsp:forward page="要轉發的JSP的相對路徑"></jsp:forward>
	特點：相告於Servlet的請求轉發，一次請求，地址欄、信息不改變
	注意：在轉發標簽的兩個標簽中間除了寫<jsp:param name="附帶屬性的鍵名" value="附帶屬性的內容" />，其他任何字符都會報錯
		jsp:param會將數據以?的形式拼接在轉發路徑的後面
JSP的九大內置對象：
	內置對象：JSP文件轉釋成其對應的Servlet文件時自動生成並聲明的變量(在_jspService方法中)，在JSP頁面中直接使用即可
	注意：內置對象在JSP頁面中使用只能寫在局部代碼塊或腳本段語句來使用，不能用在全局代碼塊中使用
	內容：
		输入输出对象：out对象、response对象、request对象
		通信控制对象：pageContext对象、session对象、application对象
		Servlet对象：page对象、config对象
		错误处理对象：exception对象
	pageContext：頁面上下文對象，這個對象封存了其他八個內置對象，也就是封存了JSP的運行信息

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
	<hr>
	
	<!-- JSP的靜態引入 -->
	<%@include file="T36_JspStaticInclude.jsp" %>
	<hr>
	
	<!-- JSP的動態引入 -->
	<jsp:include page="T36_JspActionInclude.jsp"></jsp:include>
	<hr>
	
	<!-- JSP的轉發標簽 -->
	<%-- 
	<jsp:forward page="T37_JspForward.jsp">
		<jsp:param name="computer" value="thinkpad" />
	</jsp:forward>
	--%>
	
	<!-- JSP的九大內置對象 -->
	<%= request.getAttribute("computer") %>

</body>
</html>