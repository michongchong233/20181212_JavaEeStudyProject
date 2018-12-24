package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 共用底層
 */
public abstract class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 統一做編碼格式的設定
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求編碼
		request.setCharacterEncoding("UTF-8");
		//設置響應編碼
		response.setContentType("text/html;charset=UTF-8");
		doService(request,response);
	}

	/**
	 * 執行各個Servlet所需要不用邏輯
	 */
	abstract void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
