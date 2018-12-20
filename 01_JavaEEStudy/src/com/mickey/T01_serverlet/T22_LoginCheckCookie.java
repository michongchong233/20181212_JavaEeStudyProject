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
 * 針對Cookie信息的校驗，若有此用戶則不用登入(進入觀迎頁面)，反之進入登入頁面
 */
@WebServlet(
		urlPatterns = { "/22_test" }, 
		initParams = { 
				@WebInitParam(name = "22_test", value = "22_test")
		})
public class T22_LoginCheckCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginPageUri = "14_01_test";
		String wellcomePageUri = "19_test";
		
		//設置請求編碼格式
		request.setCharacterEncoding("UTF-8");
		//設置響應編碼格式
		response.setContentType("text/html;charset=utf-8");
		//獲取請求信息：取得Cookie
		Cookie[] cookies = request.getCookies();
		//處理請求信息
		//響應處理結果
		if(cookies != null) {
			for(Cookie cookie:cookies) {//遍歷尋找cookie是否有uid
				if(cookie.getName().equals("uid")) {
					response.sendRedirect(wellcomePageUri);
					System.out.println(cookie.getName() + " --> " + cookie.getValue());
				}
			}
		}else {
			response.sendRedirect(loginPageUri);
		}
	}
}
