<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mickey.T04_pojo.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>T57_TryFirstEL</title>
</head>
<body>
	<!-- localhost:8080/01_JavaEEStudy/57_test?uname=mickey&pwd=233 -->
	<h3>T57_TryFirstEL</h3><hr>
	<!-- 
	使用傳統的方式獲取作用域的對象 
	缺點：導入包、需要強轉、獲取數據的代碼過於麻煩
	-->
	<p><%= request.getParameter("uname") %> -- <%= request.getParameter("pwd") %></p>
	<p><%= request.getAttribute("str") %></p>
	<p><%=((T57_User)request.getAttribute("user_01")).getAdd().getCountry()%></p>
	<p><%=((ArrayList)request.getAttribute("list_01")).get(2)%></p>
	<p><%=((T57_User)((ArrayList)request.getAttribute("list_02")).get(1)).getAdd().getCity()%></p>
	<p><%=((HashMap)request.getAttribute("map_01")).get("x")%></p>
	<p><%=((T57_User)((HashMap)request.getAttribute("map_02")).get("c")).getAdd().getRoad()%></p>
	<hr>
	<%-- 
	使用EL的方式獲取作用域的對象 
	作用：獲取作用域對象中的數據
	注意：獲取是pageContext、request、session、application四個對象中的數據，其他數據一概不理會
		找到了則獲取返回，找不到則什麼都不錯，也不報錯
	語法：${表達式}
		獲取請求數據：
			request對象存儲了請求數據(一鍵一值)，param.鍵名；返回值
			request對象存儲了請求數據(一鍵多值)，paramvalues.鍵名；返回數組
		通過setAttribute方法存儲到作用域對象中的數據
			${鍵名}., 返回鍵名所對應的值
			注意：如果存儲的是普通字符串則直接返回
				如果存儲的是對象，則返回的是對象
			獲取對象數據：
				普通對象：${鍵名.屬性名.屬性名…}
				集合對象：list集合，${鍵名[角標]}
					map集合，${鍵名.map集合存儲的鍵名}
	EL作用域查找順序：
		pageContext-->request-->session-->application
		注意：每次查找都是從小到大進行查找，找到了則獲取，不再繼續找了(默認查找順序)
		指定查找順序：
			默認查找順序：${T59_01}
			指定查找request：${requestScope.T59_01}
			指定查找pageContext：${pageScope.T59_01}
			指定查找session：${sessionScope.T59_01}
			指定查找application：${applicationScope.T59_01}
	EL表達式的邏輯運算
		${邏輯表達式}
		${算述表達式}
		注意：+表示加法運算，不表示字符連接，使用EL表達式進行字符連接會報錯
	EL的空值判斷：判斷鍵名對象的值是否有數據，${empty 鍵名}
	EL獲取請求頭數據
		${header}，返回所有的請求頭數據
		${header["鍵名"]}，返回指定的鍵名的請求頭數據
		${headerValues["鍵名"]}，返回指定的鍵名(同鍵不同值)的值的數組
	EL獲取Cookie數據
		${cookie}，返回存儲了所有的Cookie對象的map集合
		${cookie.鍵名}，返回指定的Cookie對象
		${cookie.鍵名.name}，返回指定的Cookie對象存儲的數據的鍵名
		${cookie.鍵名.value}，返回指定的Cookie對象存儲的數據的值
	
	 --%>
	<h3>T58_使用EL的方式獲取作用域的對象</h3>
	<% String str_02 = "try EL get"; %>
	<p>${param.uname} -- ${param.pwd}</p>
	<p>${str}</p><!-- request作用域進行數據流流轉 -->
	<p>${user_01.add.country}</p><!-- Object -->
	<p>${list_01[2]}</p><!-- List<String> -->
	<p>${list_02[1].add.city}</p><!-- List<T04_User> -->
	<p>${map_01.x}</p><!-- Map<Integer, String> -->
	<p>${map_02.c.add.road}</p><!-- Map<String, T04_User> -->
	<p>${str_02}</p><!-- 只能獲取作用域中的對象，抓不到也不會報錯 -->
	<!-- localhost:8080/01_JavaEEStudy/57_test?uname=mickey&pwd=233&fav=1&fav=2 -->
	<p>${paramValues.fav[0]}</p><!-- 獲取request一鍵多值 -->
	<hr>
	
	<h3>T59_EL的作用域查找順序，同鍵不同值</h3><!-- 每次查找都是從作用域范圍最小的對象開始找 -->
	<% 
		application.setAttribute("T59_01", "T59_01 Hello application");
		session.setAttribute("T59_01", "T59_01 Hello session");
		request.setAttribute("T59_01", "T59_01 Hello request");
		pageContext.setAttribute("T59_01", "T59_01 Hello pageContext");
	%>
	<p>默認查找順序：${T59_01}</p>
	<p>指定查找request：${requestScope.T59_01}</p>
	<p>指定查找pageContext：${pageScope.T59_01}</p>
	<p>指定查找session：${sessionScope.T59_01}</p>
	<p>指定查找application：${applicationScope.T59_01}</p>
	<hr>
	
	<h3>T59_EL表達式的邏輯運算</h3>
	<p>${1+2}</p><!-- 算數運算 -->
	<p>${1-2}</p>
	<p>${2*2}</p>
	<p>${6/2}</p>
	<p>${3%2}</p>
	<p>${2==1}, ${2>=1?"Male":"Female"}</p><!-- 邏輯運算 -->
	<p>${"1"+2}</p><!-- 只能進行算數運算(會轉為數字)，而不是字符串的連接 -->
	<hr>
	
	<h3>T60_EL的空值判斷</h3>
	<p>${empty T60_01} -- ${empty T60_02} -- ${empty T60_03} -- ${empty T60_04}</p>
	
	<h3>T60_EL獲取請求頭數據和Cookie</h3>
	<p>${header}</p>
	<p>${headerValues}</p>
	<p>${cookie}</p><!-- 獲取所有cookie，返回為map -->
	<p>${cookie.JSESSIONID}</p>
	<p>${cookie.JSESSIONID.name}</p><!-- 取鍵名 -->
	<p>${cookie.JSESSIONID.value}</p><!-- 取值 -->
	
</body>
</html>