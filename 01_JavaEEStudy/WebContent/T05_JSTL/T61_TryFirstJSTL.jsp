<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- 核心標簽 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 格式化標簽 -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %><!-- sql標簽 -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %><!-- xml標簽 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><!-- JSTL函數 -->
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
				<c:if test="${EL表達式}">
					前端代碼
				</c:if>
					作用：進行邏輯判斷，相當於java代碼的單分支判斷
					注意：邏輯判斷標簽需要依賴EL的邏輯運算，也就是表達式中涉及到的數據必須從作用域中獲取
				<c:choose>
					<c:when test="">前端代碼</c:when>
					<c:when test="">前端代碼</c:when>
					…
					<c:otherwise>前端代碼</c:otherwise>
				</c:choose>
					作用：用來進行多條件的邏輯判斷，類似於java中的多分支語句
					注意：條件成立只會執行一次，都不成來則執行otherwise
			循環標簽：
				<c:forEach begin="1" end="4" step="2">
					循環體
				</c:forEach>
					作用：循環內容進行處理
					使用：begin，聲明循環開始位值
						end，聲明循環結束位置
						step，設置步長
						verStatus：聲明變量記錄每次循環體的數據(角標、次數、是否第一次循環、是否最後一次循環)
							注意：數據存儲在作用域中，需要使用EL表達式
						items：聲明遍歷對象，結合EL表達式獲取對象
						var：聲明變量記錄每次循環的結果，存儲在作用域中，需要使用EL表達式獲取
				
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
	<c:if test="${T62_01>4}"><p>JSTL: T62_01>4 --> true</p></c:if><%-- JSTL依賴於EL，只能從作用域獲取數據 --%>
	<c:choose>
		<c:when test="${T62_01>=10}"><p>JSTL: T62_01>=10</p></c:when>
		<c:when test="${T62_01<10 && T62_01>=5}"><p>JSTL: 10>T62_01>=5</p></c:when>
		<c:otherwise><p>JSTL: T62_01<5</p></c:otherwise>
	</c:choose>
	
	<table border="1px">
		<tr>
			<td>uid</td>
			<td>uname</td>
			<td>pwd</td>
			<td>lucky num</td>
		</tr>
		<c:forEach begin="1" end="4" step="1" var="num">
			<tr>
				<td><c:out value="${num}"></c:out></td>
				<td>mickey</td>
				<td>233</td>
				<td>777</td>
			</tr>
		</c:forEach>
	</table><br>
	
	<c:forEach items="${list_01}" var="T63_list">
		${T63_list}<br>
	</c:forEach><br>
	
	<c:forEach items="${map_01}" var="T63_map" varStatus="T63_mapProperties">
		${T63_mapProperties.index}--${T63_mapProperties.count}--${T63_map.key}--${T63_map.value}--${T63_mapProperties.first}--${T63_mapProperties.last}<br>
	</c:forEach>
		
</body>
</html>