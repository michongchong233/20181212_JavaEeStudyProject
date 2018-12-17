<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T09_getAndPost</title>
</head>
<!-- 
service方法和doGet方法和doPost方法的區別
service方法，最優先執行
doGet，執行get方式的請求
doPost，執行post方式的請求
注意：從覆寫的service方法進入父類的service方法，在service方法處理完後，會再次根據請求方式響應doGet和doPost方法，所以一般情況下不會覆寫service中調用super.service(req, resp)，以避免出現405錯誤
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		super.service(req, resp);
	}

Servlet的常見錯誤：
	404(資源未找到)：在請求過程中的項目名稱或Servlet別名書寫錯誤
	500：
		在web.xml中servlet類的全限定路徑併寫錯誤
		service方法體的代碼執行錯誤
	405(內部服務器錯誤)：請求方式和servlet中的方法不匹配；盡量使穽service方法進行請求處理，并且不要再service方法中調用父類的service
	
 -->
<body>
	<!-- 
		http://localhost:8080/01_JavaEEStudy/08_test
		可省略成08_test
	-->
	<form action="http://localhost:8080/01_JavaEEStudy/08_test" method="post">
		用戶名：<input type="text" name="uname" value=""><br>
		密碼：<input type="password" name="pwd" value=""><br>
		<input type="submit" value="確認">
	</form>
</body>
</html>