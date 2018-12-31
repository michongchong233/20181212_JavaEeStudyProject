package com.mickey.T03_ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 學習、使用ajax技術
 */
@WebServlet(
		urlPatterns = { "/52_test" }, 
		initParams = { 
				@WebInitParam(name = "52_test", value = "52_test")
		})
public class T52_AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求和響應編碼格式
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			Thread.sleep(5000);//等待五秒，用來測試ajax的loading圖示
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//獲取請求信息
		//處理請求信息
		//響應處理結果
		response.getWriter().write("測試測試使用AJAX");
	}

}
