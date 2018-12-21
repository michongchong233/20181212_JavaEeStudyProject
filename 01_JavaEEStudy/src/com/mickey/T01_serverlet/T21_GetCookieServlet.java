package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie的獲取
 */
@WebServlet(
		urlPatterns = { "/21_test" }, 
		initParams = { 
				@WebInitParam(name = "21_test", value = "21_test")
		})
public class T21_GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求信息編碼
		request.setCharacterEncoding("UTF-8");
		//設置響應信息編碼
		response.setContentType("text/html;charset=utf-8");
		//獲取響應信息(用戶信息)
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				System.out.println(cookie.getName() + " --> " + cookie.getValue() + "<br>");
			}
		}
	}
}
