package com.mickey.T01_serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T19_LoginSuccessPage
 */
@WebServlet(
		urlPatterns = { "/19_test" }, 
		initParams = { 
				@WebInitParam(name = "19_test", value = "19_test")
		})
public class T19_LoginSuccessPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求編碼格式
		request.setCharacterEncoding("UTF-8");
		//設置響應編碼格式
		response.setContentType("text/html;charset=utf-8");
		//獲取請求信息，無論誰來都直接丟出登入頁面(直接響應)，故此部分跳過
		//處理請求信息，無論誰來都直接丟出登入頁面(直接響應)，故此部分跳過
		//獲取request作用域數據
		String user = (String)request.getAttribute("loginUser");
		//響應處理結果
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		response.getWriter().write("<h3>Hello! "+ user +" Wellcome come back!!</h3>");
		response.getWriter().write("<hr>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
	}
}
