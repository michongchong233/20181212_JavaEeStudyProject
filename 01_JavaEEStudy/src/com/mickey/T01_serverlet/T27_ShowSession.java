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
 * ���Session���e
 */
@WebServlet(
		urlPatterns = { "/27_test" }, 
		initParams = { 
				@WebInitParam(name = "27_test", value = "27_test")
		})
public class T27_ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�s�X
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���s�X
		response.setContentType("text/html;charset=utf-8");
		//����ШD�H��
		Cookie[] cookies = request.getCookies();
		String oldSession = "";
		//�����JSESSIONID
		if(cookies != null) for(Cookie cookie : cookies) if(cookie.getName().equals("JSESSIONID")) oldSession = cookie.getValue();
		
		HttpSession session = request.getSession();
		if(!session.getId().equals(oldSession)) {
			System.out.println(this.getClass().getName() + " || oldSession=" + oldSession + " || JSESSIONID=" + session.getId() + " || NOT EQUALS");
			response.sendRedirect("/01_JavaEEStudy/14_01_test");
			return;
		}
		System.out.println(this.getClass().getName() + " || uid=" + session.getAttribute("uid") + " || uname=" + session.getAttribute("uname") + " || password=" + session.getAttribute("password"));
		//�B�z�ШD�H��
		//�T���B�z���G
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
