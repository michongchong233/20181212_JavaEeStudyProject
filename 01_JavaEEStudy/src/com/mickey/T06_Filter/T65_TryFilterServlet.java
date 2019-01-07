package com.mickey.T06_Filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T65_TryFilterServlet
 */
@WebServlet(
		urlPatterns = { "/65_test.do" }, 
		initParams = { 
				@WebInitParam(name = "65_test", value = "65_test")
		})
public class T65_TryFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求編碼格式
		request.setCharacterEncoding("UTF-8");
		//設置響應編碼格式
		response.setContentType("text/html;charset=UTF-8");
		//獲取請求信息
		System.out.println("T65_TryFilterServlet-->server()");
		//處理請求信息
		//響應處理結果
		
	}
}
