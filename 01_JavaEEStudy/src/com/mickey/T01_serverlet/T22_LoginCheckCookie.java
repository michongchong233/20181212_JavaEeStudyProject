package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	@SuppressWarnings("rawtypes")
	Class myClass = this.getClass();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginPageUri = "14_01_test";
		String wellcomePageUri = "19_test";

		AllUseUtil.setRequestResponseEcoding(request, response);//設置請求、響應編碼格式
		//獲取請求信息：取得Cookie
		Cookie[] cookies = request.getCookies();
		//處理請求信息
		//響應處理結果
		if(cookies != null) {
			for(Cookie cookie:cookies) {//遍歷尋找cookie是否有uid
				String uid = "";
				if(cookie.getName().equals("uid")) {
					uid = uid + cookie.getValue();

					AllUseUtil.getLogger(myClass, "cookie.getName()"+cookie.getName(), "uid="+uid);
					//開始校驗uid信息在數據庫是否存在
					T15_01_LoginService ls = new T15_03_LoginServiceImpl();
					T15_02_LoginUser user = ls.checkUidService(cookie.getValue());
					if(user != null) {
						//處理若用戶關閉瀏覽器但沒清cookie的登入校驗
						//若Session還在，則將數據庫的用戶信息更新至Session，反之則建立Session並放入數據庫的用戶信息
						HttpSession session = request.getSession();
						session.setMaxInactiveInterval(10);
						session.setAttribute("uid", user.getUid());
						session.setAttribute("uname", user.getUname());
						session.setAttribute("password", user.getPassword());
						AllUseUtil.getLogger(myClass, "JSESSIONID="+session.getId(), user.toString(), "wellcome back");
						
						//從Cookie自增的網頁計數器自增
						ServletContext sc = this.getServletContext();
						int nums = (sc.getAttribute("nums") != null)?(int)(sc.getAttribute("nums"))+1:1;
						sc.setAttribute("nums", nums);
						
						//cookie有uid並且此uid在數據庫也存在時進入歡迎頁面
						response.sendRedirect(wellcomePageUri);
					}else {
						AllUseUtil.getLogger(myClass, "查無此用戶，要重新登入");
						response.sendRedirect(loginPageUri);
					}
				}
			}
		}else {
			AllUseUtil.getLogger(myClass, "首次登入");
			response.sendRedirect(loginPageUri);
		}
	}
}
