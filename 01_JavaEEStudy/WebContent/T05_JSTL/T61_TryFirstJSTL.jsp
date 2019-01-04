<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>T61_TryFirstJSTL</title>
</head>
<body>
	<%-- 
	JSTL
	作用：提高在jsp中的邏輯代碼的編寫效率，使用標簽
	http://www.runoob.com/jsp/jsp-jstl.html
	
	JSTL核心標簽庫
		1.導入jar包
			http://archive.apache.org/dist/jakarta/taglibs/standard/binaries/
		2.聲明JSTL標簽庫的引用(核心標簽庫)
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		3.內容
			基本標簽：
				<c:out value="數據" default="默認數據"></c:out>
					數據可以為常量值也可以是EL表達式
					作用：將數據輸出給客戶端
				<c:set var="T61" value="hello pageContext" scope="page"></c:set>
					作用：存儲數據到作用域對象中
					var：存儲的鍵名
					value：存儲的數據
					scope：存儲的作用域對象，page、request、session、application
				<c:remove var="T61" scope="page"></c:remove>
					作用：刪除作用域中指定鍵的數據，若無指定作用域則則除這個鍵全部作用域的值
			邏輯標簽：
				<c:if></c:if>
				
				
	JSTL格式化標簽庫
	JSTL SQL標簽庫
	JSTL函數標簽庫
	JSTL XML標簽庫
	
	 --%>
	<h3>T61_TryFirstJSTL</h3><hr>
	<%-- 基本標簽 --%>
	<% request.setAttribute("str", "try <c:out> for JSTL"); %>
	<c:out value="數據"></c:out><br>
	<c:out value="${str}"></c:out><br>
	<c:out value="${str2}" default="若value為空則顯示"></c:out><br>
	
	<c:set var="T61" value="hello pageContext" scope="page"></c:set>
	<c:set var="T61" value="hello request" scope="request"></c:set>
	<c:set var="T61" value="hello session" scope="session"></c:set>
	<c:set var="T61" value="hello application" scope="application"></c:set>
	<p>c:set: ${pageScope.T61} -- ${requestScope.T61}</p>
	
	<c:remove var="T61" scope="page"></c:remove><!-- 若無指定作用域則全刪 -->
	<c:out value="${T61}" default="non found"></c:out>
	
	<%-- 邏輯標簽 --%>
	<p>
		<% 
			int i = 4;//原來使用jsp的寫法
			if(i==4){
		%>
		jsp: i==4 --> true
		<%		
			}else{
		%>
		jsp: i==4 --> false
		<%	
			}
		%>
	</p>
	<c:set var="T62_01" value="12" scope="page"></c:set>
	<c:if test="12>4"><p>JSTL: T62_01>4 --> true</p></c:if><%-- JSTL依賴於EL，只能從作用域獲取數據 --%>
		
</body>
</html>