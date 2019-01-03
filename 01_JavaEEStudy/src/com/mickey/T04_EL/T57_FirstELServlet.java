package com.mickey.T04_EL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
EL�ǲ�
���D�G�bservlet�i��ШD�B�z��A�ϥΧ@�ΰ��H�@�|�ƾڬy�઺����A�N�ƾڬy�൹������jsp���A����bjsp������@�ΩΤ����ƾکO�H
�ϥΡG
	�ǲΤ覡�G�bjsp�������ϥ�java�}���q�y�y

 */
@WebServlet(
		urlPatterns = { "/57_test" }, 
		initParams = { 
				@WebInitParam(name = "57_test", value = "57_test")
		})
public class T57_FirstELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//localhost:8080/01_JavaEEStudy/57_test?uname=mickey&pwd=233
		//�]�m�ШD�M�T���s�X�榡
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//����ШD�H��
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		//�B�z�ШD�H��
		System.out.println(uname + "--" + pwd);
		//�T���B�z���G
		request.setAttribute("str", "Study EL class");//�ϥ�request�@�ΰ�i��ƾڬy�y��
		//Object
		//�ШD��o
		request.getRequestDispatcher("T04_EL/T57_TryFirstEL.jsp").forward(request, response);
		
	}

}
