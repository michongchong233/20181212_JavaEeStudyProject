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

import com.mickey.T01_service.T15_01_LoginService;
import com.mickey.T01pojo.T15_02_LoginUser;
import com.mickey.serverImp.T15_03_LoginServiceImpl;

/**
 * �B�z�n�J�������n�J�ШD

�ШD����ýX�ѨM-->�ഫ�s�X�榡
	�ϥ�String�ഫ�Guname = new String(uname.getBytes("ISO8859-1"),"UTF-8");
	�ϥΤ��@�t�m(post)�Grequest.setCharacterEncoding("UTF-8");
	�ϥΤ��@�t�m(get)�G
		�B�J1�Grequest.setCharacterEncoding("UTF-8");
		�B�J2�G�btomcat���ؿ��U��conf/server.xml�A�bConnector��ñ���W�[�ݩ�useBodyEncodingForURI="true"

 */
@WebServlet(
		urlPatterns = { "/14_02_test" }, 
		initParams = { 
				@WebInitParam(name = "14_02_test", value = "14_02_test")
		})
public class T14_02_LoginResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�s�X�榡(post��)�A�b��o�ШD�H���e��s�X�榡
		request.setCharacterEncoding("UTF-8");
		
		//�]�m�T���s�X�榡
		response.setContentType("text/html;charset=utf-8");
		//����ШD�H��
		String uname = request.getParameter("uname");
		//�ϥ�String�ഫ�s�X�榡�A�ѨM����ШD�ýX���D�A�s�����h���q�{ISO8859-1�A�A�Ⱦ��q�{UTF-8
		//��java���ഫ�A�u�I�O����get�Mpost���i�H�ΡA���I�O���q�j�ɷ|�ܳ·�
//		uname = new String(uname.getBytes("ISO8859-1"),"UTF-8");
		String password = request.getParameter("password");
		System.out.println(uname + " --> " + password);
		//�B�z�ШD�H���A����~�ȼh��H
		T15_01_LoginService ls = new T15_03_LoginServiceImpl();
		T15_02_LoginUser user = ls.checkLoginService(uname, password);
		System.out.println(user);
		//�T���B�z���G
		if(user != null) {
			System.out.println(uname + "�n�J���\");
			request.setAttribute("loginUser", user.getUname());
			//�]�mCookie�H��
			String uid = "" + user.getUid();
			Cookie uCookie = new Cookie("uid", uid);
			uCookie.setMaxAge(3*24*3600);//�]�m���Ĵ������T��
			uCookie.setPath("/01_JavaEEStudy/22_test");//�]�mCookie���ĸ��|
			response.addCookie(uCookie);//�W�[Cookie���T���H����
			
			//�]�mSession�H��
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10);//�]�m���ĮɮġA10��
			session.setAttribute("uid", user.getUid());
			session.setAttribute("uname", user.getUname());
			session.setAttribute("password", user.getPassword());
			System.out.println(this.getClass().getName() + " || JSESSIONID=" + session.getId() + " || " + user.toString() + " || Login SuCCess");
			
//			request.getRequestDispatcher("19_test").forward(request, response);//�ШD��o�|�����д��檺���D
			/**
			���w�V
			���n�J��i�J��s�������A��url���S����s�A�Y�O��get�覡���ܥΤ��s�|�@�����д���L�Ϊ��H��(�b������s�ᤣ��A����)
			�����O���s�o�@�ӷs���ШD�A�����X��/01_JavaEEStudy/19_test
			�S�I�G1.�⦸�ШD�A���request��H
				2.�s�����a�}��H������
			�ɾ��G1.�p�G�ШD��������ƾڡA�ӼƾڤS������n�A���୫�д���A��ĳ�ϥέ��w�V
				2.�p�G�ШD�Qservlet������A�L�k�i��B�z�A��ĳ�ϥέ��w�V�w���i�H�B�z���귽
			 */
			response.sendRedirect("/01_JavaEEStudy/19_test");//�۷���http://localhost:8080/01_JavaEEStudy/19_test
		} else {
			System.out.println(uname + "�n�J����");
			
			//�ϥ�request��H��{���PServlet���ƾڬy��(T18)
			//request�ͩR�P��-->�@���ШD��������
			request.setAttribute("errorMessage", "�Τ�W�αK�X���~");
			/**
			�ШD��o(T17)
			���ШD��������ƾڥi�H���д���ɡA�i�H�νШD��o
			�@�ΡG��{�h��servlet�p�ʾާ@�B�z�ШD�A�i�קK�N�X���E�A�{servlet��¾�d��[���T
			�S�I�G�@���ШD�B�a�}��H��������
			
			 */
			request.getRequestDispatcher("14_01_test").forward(request, response);
		}
	}
}