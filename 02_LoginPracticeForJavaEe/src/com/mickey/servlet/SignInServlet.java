package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mickey.dto.UserDTO;
import com.mickey.service.UserService;
import com.mickey.service.impl.UserServiceImpl;

/**
 * 
 */
@WebServlet(
		urlPatterns = { "/SignIn" }, 
		initParams = { 
				@WebInitParam(name = "SignIn", value = "SignIn")
		})
public class SignInServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ާ@��
		String oper = request.getParameter("oper");
		if(oper.equals("signIn")) {//�n�J
			checkUserSignIn(request, response);
		}else if(oper.equals("out")) {//�h�X
			userOut(request, response);
		}else if(oper.equals("reg")) {//�`�U
			
		}else {
			System.out.println("�S�����������ާ@�šG" + oper);
		}
		
	}
	
	/**
	 * �h�X�ШD�B�z
	 */
	private void userOut(HttpServletRequest request, HttpServletResponse response) {
		//���Session��H
		HttpSession hs = request.getSession();
		//�j��P��Session
		hs.invalidate();
		try {
			response.sendRedirect("SignIn.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �n�J�ШD�B�z
	 */
	private void checkUserSignIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ШD�H��
		String uname = (String)request.getParameter("uname");
		String password = (String)request.getParameter("password");
		//�B�z�ШD�H��
		UserService checkSignIn = new UserServiceImpl();
		UserDTO user = checkSignIn.checkUserSignIn(uname, password);
		if (user != null) {
			//�p�G���Ŀ�Remenber Me�N�Nuid�s�x��Cookie��
			String remenberMe = request.getParameter("remenberMe");
			if(remenberMe != null && remenberMe.equals("remenberMe")) {
				Cookie userCookie = new Cookie("uid", Integer.toString(user.getUid()));
				userCookie.setMaxAge(3*24*3600);//�]�mCookie���Ĵ���
				response.addCookie(userCookie);
			}
			
			//���Session
			HttpSession hs = request.getSession();
			//�N�Τ�H���g�JSession��
			hs.setAttribute("user", user);
			
			//�n�J���\�A���w�V��dashboard
			response.sendRedirect("DashBoard.jsp");
		}else{
			request.setAttribute("errorMessage", "error");
			request.getRequestDispatcher("SignIn.jsp").forward(request, response);
		}
	}
}
