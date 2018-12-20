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
 * �w��Cookie�H��������A�Y�����Τ�h���εn�J(�i�J�[�ﭶ��)�A�Ϥ��i�J�n�J����
 */
@WebServlet(
		urlPatterns = { "/22_test" }, 
		initParams = { 
				@WebInitParam(name = "22_test", value = "22_test")
		})
public class T22_LoginCheckCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginPageUri = "14_01_test";
		String wellcomePageUri = "19_test";
		
		//�]�m�ШD�s�X�榡
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���s�X�榡
		response.setContentType("text/html;charset=utf-8");
		//����ШD�H���G���oCookie
		Cookie[] cookies = request.getCookies();
		//�B�z�ШD�H��
		//�T���B�z���G
		if(cookies != null) {
			for(Cookie cookie:cookies) {//�M���M��cookie�O�_��uid
				if(cookie.getName().equals("uid")) {
					response.sendRedirect(wellcomePageUri);
					System.out.println(cookie.getName() + " --> " + cookie.getValue());
				}
			}
		}else {
			response.sendRedirect(loginPageUri);
		}
	}
}
