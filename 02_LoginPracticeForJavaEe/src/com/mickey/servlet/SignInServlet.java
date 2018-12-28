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
 * ����Τ᪺�Ҧ�servlet
 * �ھڤ��P�ާ@�ŽեΤ��P����k
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
		System.out.println(oper);
		if(oper.equals("signIn")) {//�n�J
			checkUserSignIn(request, response);
		}else if(oper.equals("out")) {//�h�X
			userOut(request, response);
		}else if(oper.equals("allUser")) {//�d�թҦ��Τ���
			getAllUser(request, response);
		}else if(oper.equals("changePwd")) {//�ק�K�X
			changePassword(request, response);
		}else if(oper.equals("reg")) {//�`�U
			addAccount(request, response);
		}else {
			System.out.println("�S�����������ާ@�šG" + oper);
		}
	}
	
	/**
	 * �B�z�`�U�Τ�ШD
	 */
	private void addAccount(HttpServletRequest request, HttpServletResponse response) {
		UserDTO user = new UserDTO();
		user.setUname(request.getParameter("uname"));
		user.setPassword(request.getParameter("password"));
		user.setGender(Byte.parseByte(request.getParameter("gender")));
		user.setAge(request.getParameter("age")!=null?Integer.parseInt(request.getParameter("age")):0);
		String birthYear = request.getParameter("birthYear");
		String birthMonth = request.getParameter("birthMonth");
		String birthDay = request.getParameter("birthDay");
		if(birthYear != "" && birthMonth != "" && birthDay != "") {
			user.setBirth(String.format("%d-%d-%d", Integer.parseInt(birthYear), Integer.parseInt(birthMonth), Integer.parseInt(birthDay)));
		}
		System.out.println(user.toString());
		UserService addAccount = new UserServiceImpl();
		if(addAccount.signUpAccount(user) > 0) {
			System.out.println("�s�W�ᦨ�\");
		} else {
			System.out.println("�s�W�ᥢ��");
		}
	}
	
	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		String newPassword = request.getParameter("newPassword");
		int uid = ((UserDTO)request.getSession().getAttribute("user")).getUid();
		System.out.println(newPassword);
		UserService changePassword = new UserServiceImpl();
		int updateNum = changePassword.changePassword(uid, newPassword);
		if(updateNum > 0) {
			System.out.println("�ק�K�X���\");
			request.setAttribute("successMessage", "success");
			try {
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("�ק�K�X����");
		}
	}
	
	/**
	 * �B�z����Ҧ��Τ�H���ШD
	 */
	private void getAllUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("search all user");
		UserService getAllUser = new UserServiceImpl();
		//�N�������Τ�H�����ШD��
		request.setAttribute("users", getAllUser.getAllUser());	
		try {
			//��o�ШD
			request.getRequestDispatcher("AllUserInformation.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
