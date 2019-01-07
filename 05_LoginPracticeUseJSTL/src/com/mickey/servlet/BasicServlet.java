package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mickey.dto.UserDTO;
import com.mickey.service.UserService;
import com.mickey.service.impl.UserServiceImpl;

/**
 * �@�Ω��h
 */
public abstract class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * �Τ@���s�X�榡���]�w
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�s�X
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���s�X
		response.setContentType("text/html;charset=UTF-8");
		doService(request,response);
	}

	/**
	 * ����U��Servlet�һݭn�����޿�
	 */
	abstract void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * �ˬdCookie���O�_�����T��uid
	 */
	static void checkUidCookie(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		//���ocookie��uid�A�Y�S���h��0
		Cookie[] cookies = request.getCookies();
		int uid = 0;
		for(Cookie cookie:cookies) {
			uid=(cookie.getName().equals("uid")?Integer.parseInt(cookie.getValue()):0);
		}
		UserService checkUserId = new UserServiceImpl();
		UserDTO user = checkUserId.checkUserId(uid);
		if(user!=null) {
			response.sendRedirect(path);
		}else {
			response.sendRedirect("SignIn.jsp");
		}
	}
}
