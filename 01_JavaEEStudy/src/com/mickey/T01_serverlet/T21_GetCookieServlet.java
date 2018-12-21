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
 * Cookie�����
 */
@WebServlet(
		urlPatterns = { "/21_test" }, 
		initParams = { 
				@WebInitParam(name = "21_test", value = "21_test")
		})
public class T21_GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�H���s�X
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���H���s�X
		response.setContentType("text/html;charset=utf-8");
		//����T���H��(�Τ�H��)
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				System.out.println(cookie.getName() + " --> " + cookie.getValue() + "<br>");
			}
		}
	}
}
