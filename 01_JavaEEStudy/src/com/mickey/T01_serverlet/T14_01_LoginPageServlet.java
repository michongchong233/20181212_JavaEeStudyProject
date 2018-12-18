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
 */
@WebServlet(
		urlPatterns = { "/14_01_test" }, 
		initParams = { 
				@WebInitParam(name = "14_01_test", value = "14_01_test")
		})
public class T14_01_LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置響應編碼格式
		response.setContentType("text/html;charset=utf-8");
		//獲取請求信息，無論誰來都直接丟出登入頁面(直接響應)，故此部分跳過
		//處理請求，無論誰來都直接丟出登入頁面(直接響應)，故此部分跳過
		//響應處理結果，使用html
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		response.getWriter().write("<form action='14_02_test' method='get'>");
		response.getWriter().write("用戶名：<input type='text' name='uname' value=''><br>");
		response.getWriter().write("密碼：<input type='password' name='password' value=''><br>");
		response.getWriter().write("<input type='submit' value='登入'>");
		response.getWriter().write("</form>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
	}
}
