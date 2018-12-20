package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.T01_service.T15_01_LoginService;
import com.mickey.T01pojo.T15_02_LoginUser;
import com.mickey.serverImp.T15_03_LoginServiceImpl;

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
				String uid = "";
				if(cookie.getName().equals("uid")) {
					uid = uid + cookie.getValue();
					System.out.println(cookie.getName() + " --> " + uid);
					//開始校驗uid信息在數據庫是否存在
					T15_01_LoginService ls = new T15_03_LoginServiceImpl();
					T15_02_LoginUser user = ls.checkUidService(cookie.getValue());
					if(user != null) {
						//cookie有uid並且此uid在數據庫也存在時進入歡迎頁面
						System.out.println("歡迎" + user.getUname() + "用戶回來");
						response.sendRedirect(wellcomePageUri);
						//TODO T22，筆記做到一半
						response.addHeader("uname", user.getUname());
					}else {
						System.out.println("查無此用戶，要重新登入");
						response.sendRedirect(loginPageUri);
					}
				}
			}
		}else {
			System.out.println("首次登入");
			response.sendRedirect(loginPageUri);
		}
	}
}
