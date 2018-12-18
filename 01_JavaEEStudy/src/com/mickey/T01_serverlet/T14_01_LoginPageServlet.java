package com.mickey.T01_serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �B�z�n�J�����ШD
1.�Ыصn�J����
	�Ы�Servlet�i��n�������ШD�B�z
2.�I���n�J�����n���ާ@
	�s�����o�e�ШD��A�Ⱦ�(�Τ�H��+��L�ƾ�)
	�A�Ⱦ��եι�����servlet�i��B�z
		�]�m�T���s�X�榡
		����ШD�H��
		�B�z�ШD�H��
			
		�T���B�z���G
3.�bservlet�������Τ�n������
	�ݭn�s���ƾڮw(�bmysql���ЫإΤ��)
�ϥ�MVC��Q�����m��
 */
@WebServlet(
		urlPatterns = { "/14_01_test" }, 
		initParams = { 
				@WebInitParam(name = "14_01_test", value = "14_01_test")
		})
public class T14_01_LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�T���s�X�榡
		response.setContentType("text/html;charset=utf-8");
		//����ШD�H���A�L�׽֨ӳ�������X�n�J����(�����T��)�A�G���������L
		//�B�z�ШD�A�L�׽֨ӳ�������X�n�J����(�����T��)�A�G���������L
		//�T���B�z���G�A�ϥ�html
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		response.getWriter().write("<form action='14_02_test' method='get'>");
		response.getWriter().write("�Τ�W�G<input type='text' name='uname' value=''><br>");
		response.getWriter().write("�K�X�G<input type='password' name='password' value=''><br>");
		response.getWriter().write("<input type='submit' value='�n�J'>");
		response.getWriter().write("</form>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
	}
}
