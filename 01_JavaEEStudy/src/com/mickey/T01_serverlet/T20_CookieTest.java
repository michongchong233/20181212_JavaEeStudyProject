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
Cookie學習：
瀏覽器端的數據存儲技術
作用：解決了不同請求的數據共享問題
使用：
	1.創建Cookie對象
		Cookie c = new Cookie("computer", "thinkpad");
	2.設置Cookie
		設置有效期：c2.setMaxAge(3*24*3600);//3天
		設置有效路徑：c2.setPath("/01_JavaEEStudy/21_test");//http://localhost:8080/01_JavaEEStudy/21_test
	3.響應Cookie信息給戶端
		response.addCookie(c);
	4.獲取Cookie信息數組
		Cookie[] cookies = request.getCookies();
	注意：一個cookie對象儲存一組鍵值對
特點：
	瀏覽器端的數據存儲技術
	存儲的數據聲明在服務器端
	默認是Cookie信息每次請求都會附帶，除非設置有效路徑
	臨時存儲：存儲在瀏覽器的運行內存中，瀏覽器關閉即失效
	定時存儲：設置了Cookie的有效期，存儲在瀏覽器端的歷史數據中，在有效期內符合路徑要求的請求都會附帶該信息
 */
/**
 *Cookie設置
 */
@WebServlet(
		urlPatterns = { "/20_test" }, 
		initParams = { 
				@WebInitParam(name = "20_test", value = "20_test")
		})
public class T20_CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求編碼格式
		request.setCharacterEncoding("UTF-8");
		//設置響應編碼格式
		response.setContentType("text/html;charset=utf-8");
		//獲取響應數據
		//處理響應數據
		
		//創建Cookie對象
		Cookie c = new Cookie("computer", "thinkpad");
		Cookie c2 = new Cookie("keyboard", "ASUS");
		//設置Cookie有效期(秒)，否則默認Cookie瀏覽器關閉即失效
		c2.setMaxAge(3*24*3600);//3天
		//設置有效路徑
		c2.setPath("/01_JavaEEStudy/21_test");//http://localhost:8080/01_JavaEEStudy/21_test
		//響應Cookie信息
		response.addCookie(c);
		response.addCookie(c2);
		//響應處理結果
		
	}
}
