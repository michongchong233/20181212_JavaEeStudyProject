package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
Session
服務器端的數據存儲技術
相當於是在服務器端創建一個此用戶直接相關的對象，並用Cookie技術將Session的id存到瀏覽器
作用：用於解決一個用戶不同請求處理的數據共享問題，只要在JSESSIONID不失效和Session對象不失效的情況下，用戶的任意請求都能獲取到同一個Session對象
原理：用戶第一次訪問服務器，服務器會創建一個Session對象給此用戶，并將該Session對象的JSESSIONID使用Cookie技術存儲到濟覽器中，
	保證用戶的其他請求在處理時都能夠獲取到同一個Session對象，也保證了不同請求能夠獲取到共享的數據
特點：
	存諸在服務器端
	服務器進行創建
	依賴Cookie技術
	生命周期：在JSESSIONID不失效和Session對象不失效的情況下作用域為項目內
	Session在服務器的默認存儲時間是30分鐘
使用：
	創建Session對象/獲取Session對象，若有Session標識符(JSEESSIONID)返回原有Session，若沒有或找不到Session則創建新的Session
		HttpSession hs = request.getSession();
	設置Session的存儲時間
		hs.setMaxInactiveInterval(5);//5秒內沒被使用則銷毀
		在tomcat/conf/web.xml的session-timeout設定，也可設定項目的web.xml
	設置Session強制失效
		hs.invalidate();
	存儲和獲取數據
		存儲：
		獲取：
		注意：存儲的動作和取出的動作發生在不同的請求中，但是存儲要先於取出執行
使用時機：一般用戶在登陸web項目時會將用戶的個人信息存儲到Session中，供該用戶的其他請求使用
Session失效處理：將用戶請求中的JSESSIONID和後台獲取到的Session對象的JSESSIONID進行比對，如果一致則Session沒失效，反之失效。重定向到登錄頁面
	用戶關閉瀏覽器-->不處理
	用戶沒關閉瀏覽器，但Session過時-->處理
注意：JSESSIONID存儲在了Cookie的臨時存儲空間中，瀏覽器關閉即失效
 */
@WebServlet(
		urlPatterns = { "/24_test" }, 
		initParams = { 
				@WebInitParam(name = "24_test", value = "24_test")
		})
public class T24_SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求編碼格式
		request.setCharacterEncoding("UTF-8");
		//設置響應編碼格式
		response.setContentType("text/html;charset=utf-8");
		//獲取請求信息
		String name = "Mini";
		//處理請求信息
			//創建Session對象，若有Session返回原有Session，反之創建新的Session
			HttpSession hs = request.getSession();
			System.out.println("T24_SessionServlet --> " + hs.getId());
			//設置Session的存儲時間
			hs.setMaxInactiveInterval(5);//5秒內沒被使用則銷毀
			//存儲Session數據
			hs.setAttribute("name", name);
			//設置Session強制失效
//			hs.invalidate();
		//響應處理結果，直接響應
			response.getWriter().write("Session Study");
	}
}
