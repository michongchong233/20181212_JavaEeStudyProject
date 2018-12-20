package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.T01_service.T15_01_LoginService;
import com.mickey.T01pojo.T15_02_LoginUser;
import com.mickey.serverImp.T15_03_LoginServiceImpl;

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
				String uid = "";
				if(cookie.getName().equals("uid")) {
					uid = uid + cookie.getValue();
					System.out.println(cookie.getName() + " --> " + uid);
					//�}�l����uid�H���b�ƾڮw�O�_�s�b
					T15_01_LoginService ls = new T15_03_LoginServiceImpl();
					T15_02_LoginUser user = ls.checkUidService(cookie.getValue());
					if(user != null) {
						//cookie��uid�åB��uid�b�ƾڮw�]�s�b�ɶi�J�w�ﭶ��
						System.out.println("�w��" + user.getUname() + "�Τ�^��");
						response.sendRedirect(wellcomePageUri);
						//TODO T22�A���O����@�b
						response.addHeader("uname", user.getUname());
					}else {
						System.out.println("�d�L���Τ�A�n���s�n�J");
						response.sendRedirect(loginPageUri);
					}
				}
			}
		}else {
			System.out.println("�����n�J");
			response.sendRedirect(loginPageUri);
		}
	}
}
