package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.T01_service.T15_01_LoginService;
import com.mickey.T01pojo.T15_02_LoginUser;
import com.mickey.serverImp.T15_03_LoginServiceImpl;

/**
 * 處理登入頁面的登入請求

請求中文亂碼解決-->轉換編碼格式
	使用String轉換：uname = new String(uname.getBytes("ISO8859-1"),"UTF-8");
	使用公共配置(post)：request.setCharacterEncoding("UTF-8");
	使用公共配置(get)：
		步驟1：request.setCharacterEncoding("UTF-8");
		步驟2：在tomcat的目錄下的conf/server.xml，在Connector標簽中增加屬性useBodyEncodingForURI="true"

 */
@WebServlet(
		urlPatterns = { "/14_02_test" }, 
		initParams = { 
				@WebInitParam(name = "14_02_test", value = "14_02_test")
		})
public class T14_02_LoginResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求編碼格式(post用)，在獲得請求信息前轉編碼格式
		request.setCharacterEncoding("UTF-8");
		
		//設置響應編碼格式
		response.setContentType("text/html;charset=utf-8");
		//獲取請求信息
		String uname = request.getParameter("uname");
		//使用String轉換編碼格式，解決中文請求亂碼問題，瀏覽器多數默認ISO8859-1，服務器默認UTF-8
		//用java來轉換，優點是不分get和post都可以用，缺點是當量大時會很麻煩
//		uname = new String(uname.getBytes("ISO8859-1"),"UTF-8");
		String password = request.getParameter("password");
		System.out.println(uname + " --> " + password);
		//處理請求信息，獲取業務層對象
		T15_01_LoginService ls = new T15_03_LoginServiceImpl();
		T15_02_LoginUser user = ls.checkLoginService(uname, password);
		System.out.println(user);
		//響應處理結果
		if(user != null) {
			System.out.println(uname + "登入成功");
			request.setAttribute("loginUser", user.getUname());
//			request.getRequestDispatcher("19_test").forward(request, response);//請求轉發會有重覆提交的問題
			/**
			重定向
			當登入後進入到新的頁面，但url郤沒有更新，若是用get方式的話用戶刷新會一直重覆提交無用的信息(在頁面刷新後不能再執行)
			指的是重新發一個新的請求，直接訪問/01_JavaEEStudy/19_test
			特點：1.兩次請求，兩個request對象
				2.瀏覽器地址欄信息改變
			時機：1.如果請求中有表單數據，而數據又比較重要，不能重覆提交，建議使用重定向
				2.如果請求被servlet接收後，無法進行處理，建議使用重定向定位到可以處理的資源
			 */
			response.sendRedirect("/01_JavaEEStudy/19_test");//相當於http://localhost:8080/01_JavaEEStudy/19_test
		} else {
			System.out.println(uname + "登入失敗");
			
			//使用request對象實現不同Servlet的數據流轉(T18)
			//request生命周期-->一次請求內都有效
			request.setAttribute("errorMessage", "用戶名或密碼錯誤");
			/**
			請求轉發(T17)
			當請求中的表單數據可以重覆提交時，可以用請求轉發
			作用：實現多個servlet聯動操作處理請求，可避免代碼冗余，認servlet的職責更加明確
			特點：一次請求、地址欄信息不改變
			
			 */
			request.getRequestDispatcher("14_01_test").forward(request, response);
		}
	}
}
