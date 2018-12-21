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
 * ���Session��H�ƾ�
 */
@WebServlet(
		urlPatterns = { "/25_test" }, 
		initParams = { 
				@WebInitParam(name = "25_test", value = "25_test")
		})
public class T25_GetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String oldSessionId = null;
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("JSESSIONID")) {
					oldSessionId = cookie.getValue();
					System.out.println("T25_GetSession oldSessionId --> " + oldSessionId);
				}
			}
		}
		
		HttpSession hs = request.getSession();
		if(hs.getId().equals(oldSessionId)) {//�Y��Ӫ�Session���īh�����Session�ƾ�
			System.out.println("��Ӫ�Session�S���ġA�}�l����ƾ�");
			System.out.println("T25_GetSession --> " + hs.getId());
			response.getWriter().write("name --> " + hs.getAttribute("name"));
		}else {
			System.out.println("��Ӫ�Session����");
			response.sendRedirect("/01_JavaEEStudy/24_test");
		}
	}
}
