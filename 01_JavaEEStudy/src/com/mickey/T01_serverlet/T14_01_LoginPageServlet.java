package com.mickey.T01_serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 處理登入頁面請求
1.創建登入頁面
	創建Servlet進行登錄頁面請求處理
2.點擊登入完成登錄操作
	瀏覽器發送請求到服務器(用戶信息+其他數據)
	服務器調用對應的servlet進行處理
		設置響應編碼格式
		獲取請求信息
		處理請求信息	
		響應處理結果
3.在servlet中完成用戶登錄檢驗
	需要連接數據庫(在mysql中創建用戶表)
使用MVC思想完成練習

Servlet流程總結：
	瀏覽器發起請求到服務器(請求)
	服務器接受瀏覽器的請求，進行解析，創建request對象存儲請求數據
	服務器調用對應的servlet進行請求處理，并將request對象作為實參傳運給servlet的方法
	serlet的方法執行進行請求處理
		1.設置請求紡碼格式
		2.設置響應編碼格式
		3.獲取請求信息
		4.處理請求信息(MVC)
			創建業務層對象
			調用業務層對象的方式
		5.響應處理結果
數據流轉流程：
	瀏覽器-->服務器-->數據庫
	瀏覽器<--服務器<--數據庫
	
 */
@WebServlet(
		urlPatterns = { "/14_01_test" }, 
		initParams = { 
				@WebInitParam(name = "14_01_test", value = "14_01_test")
		})
public class T14_01_LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllUseUtil.setRequestResponseEcoding(request, response);//設置請求、響應編碼格式
		//處理請求，無論誰來都直接丟出登入頁面(直接響應)，故此部分跳過
		//獲取request作用域數據(T18)
		String errorMessage = (String)request.getAttribute("errorMessage");
		
		//響應處理結果，使用html
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		response.getWriter().write("<form action='14_02_test' method='get'>");
		response.getWriter().write("用戶名：<input type='text' name='uname' value=''><br>");
		response.getWriter().write("密碼：<input type='password' name='password' value=''><br>");
		
		//登入失敗時才顯示錯誤信息
		if(errorMessage != null) {
			response.getWriter().write("<p style='color: red'>" + errorMessage + "</p>");			
		}
		response.getWriter().write("<input type='submit' value='登入'>");
		response.getWriter().write("</form>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
	}
}
