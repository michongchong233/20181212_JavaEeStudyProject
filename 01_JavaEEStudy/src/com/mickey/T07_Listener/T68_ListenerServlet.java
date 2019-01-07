package com.mickey.T07_Listener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 使用原始的方式寫Listener
 */
@WebServlet(
		urlPatterns = { "/68_test" }, 
		initParams = { 
				@WebInitParam(name = "68_test", value = "68_test")
		})
public class T68_ListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//獲取請求信息
		System.out.println("T68_ListenerServlet-->server()");
		//處理請求信息
		request.setAttribute("str", "Listener Study");
		request.setAttribute("str", "Listener Study-2");
		request.removeAttribute("str");
		HttpSession hs = request.getSession();
		hs.invalidate();
		//響應處理結果
		response.getWriter().write("this is listener study page");
		
	}
	
}
