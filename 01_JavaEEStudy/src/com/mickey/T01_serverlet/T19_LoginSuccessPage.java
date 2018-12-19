package com.mickey.T01_serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T19_LoginSuccessPage
 */
@WebServlet(
		urlPatterns = { "/19_test" }, 
		initParams = { 
				@WebInitParam(name = "19_test", value = "19_test")
		})
public class T19_LoginSuccessPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�s�X�榡
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���s�X�榡
		response.setContentType("text/html;charset=utf-8");
		//����ШD�H���A�L�׽֨ӳ�������X�n�J����(�����T��)�A�G���������L
		//�B�z�ШD�H���A�L�׽֨ӳ�������X�n�J����(�����T��)�A�G���������L
		//���request�@�ΰ�ƾ�
		String user = (String)request.getAttribute("loginUser");
		//�T���B�z���G
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		response.getWriter().write("<h3>Hello! "+ user +" Wellcome come back!!</h3>");
		response.getWriter().write("<hr>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
	}
}
