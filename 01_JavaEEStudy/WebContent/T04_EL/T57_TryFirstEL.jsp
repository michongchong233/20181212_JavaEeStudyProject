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
	<p><%= ((T04_User)request.getAttribute("user_01")).getAdd().getCountry() %></p>
	<p><%= ((ArrayList)request.getAttribute("list_01")).get(2) %></p>
	<p><%= ((T04_User)((ArrayList)request.getAttribute("list_02")).get(1)).getAdd().getCity() %></p>
	<p><%= ((HashMap)request.getAttribute("map_01")).get("x") %></p>
	<p><%= ((T04_User)((HashMap)request.getAttribute("map_02")).get("c")).getAdd().getRoad() %></p>
	<hr>
	<!-- 
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
		
	-->
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

</body>
</html>