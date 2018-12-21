package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 顯示Session內容
 */
@WebServlet(
		urlPatterns = { "/27_test" }, 
		initParams = { 
				@WebInitParam(name = "27_test", value = "27_test")
		})
public class T27_ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求編碼
		request.setCharacterEncoding("UTF-8");
		//設置響應編碼
		response.setContentType("text/html;charset=utf-8");
		//獲取請求信息
		Cookie[] cookies = request.getCookies();
		String oldSession = "";
		//獲取舊JSESSIONID
		if(cookies != null) for(Cookie cookie : cookies) if(cookie.getName().equals("JSESSIONID")) oldSession = cookie.getValue();
		
		HttpSession session = request.getSession();
		if(!session.getId().equals(oldSession)) {
			System.out.println(this.getClass().getName() + " || oldSession=" + oldSession + " || JSESSIONID=" + session.getId() + " || NOT EQUALS");
			response.sendRedirect("/01_JavaEEStudy/14_01_test");
			return;
		}
		System.out.println(this.getClass().getName() + " || uid=" + session.getAttribute("uid") + " || uname=" + session.getAttribute("uname") + " || password=" + session.getAttribute("password"));
		//處理請求信息
		//響應處理結果
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		
		response.getWriter().write("<table>");
		response.getWriter().write("<tr>");
		response.getWriter().write("<td>User Name</td>");
		response.getWriter().write("<td>" + session.getAttribute("uname") + "</td>");
		response.getWriter().write("</tr>");
		response.getWriter().write("<tr>");
		response.getWriter().write("<td>User Password</td>");
		response.getWriter().write("<td>" + session.getAttribute("password") + "</td>");
		response.getWriter().write("</tr>");
		response.getWriter().write("</table>");
		
		response.getWriter().write("</form>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
		
	}

}
