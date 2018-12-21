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

/**
 * 顯示登入成功頁面
 */
@WebServlet(
		urlPatterns = { "/19_test" }, 
		initParams = { 
				@WebInitParam(name = "19_test", value = "19_test")
		})
public class T19_LoginSuccessPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	Class myClass = this.getClass();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllUseUtil.setRequestResponseEcoding(request, response);//設置請求、響應編碼格式
		//獲取請求信息，無論誰來都直接丟出登入頁面(直接響應)，故此部分跳過
		//處理請求信息，無論誰來都直接丟出登入頁面(直接響應)，故此部分跳過
		//獲取request作用域數據
		String user = (String)request.getAttribute("loginUser");
		
		Cookie[] cookies = request.getCookies();
		String oldSession = "";
		if(cookies != null) for(Cookie cookie : cookies) if(cookie.getName().equals("JSESSIONID")) oldSession = cookie.getValue();
		//獲取Session對象數據
		HttpSession session = request.getSession();
		if(!session.getId().equals(oldSession)) {//若原Session失效, 返回登入頁面
			AllUseUtil.getLogger(myClass, "oldSession"+oldSession, "session.getId()="+session.getId(), "NOT EQUALS");
			response.sendRedirect("/01_JavaEEStudy/14_01_test");
			return;
		}
		String uname = (String) session.getAttribute("uname");
		
		//獲取計數器
		ServletContext sc = this.getServletContext();
		//TODO
		int nums = (sc.getAttribute("nums")!=null)?(int)sc.getAttribute("nums"):0;
		
		//響應處理結果
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		if(user != null)response.getWriter().write("<h3>Hello! "+ user +" Wellcome come back!!</h3>");
		if(uname != null)response.getWriter().write("<h3>Hello! "+ uname +" Wellcome come back!!</h3>");
		response.getWriter().write("<hr>");
		response.getWriter().write("<p>瀏覽計數器：" + nums + "</p>");		
		response.getWriter().write("<form action='27_test'>" + 
				"<input type='submit' value='Show Session'>" + 
				"</form>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
	}
}
