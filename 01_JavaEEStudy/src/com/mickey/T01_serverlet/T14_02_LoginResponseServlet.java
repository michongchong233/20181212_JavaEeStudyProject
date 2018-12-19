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
			response.getWriter().write("登入成功");
		} else {
			response.getWriter().write("登入失敗");
		}
	}

}
