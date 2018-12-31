package com.mickey.T03_ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ǲߡB�ϥ�ajax�޳N
 */
@WebServlet(
		urlPatterns = { "/52_test" }, 
		initParams = { 
				@WebInitParam(name = "52_test", value = "52_test")
		})
public class T52_AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�M�T���s�X�榡
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			Thread.sleep(5000);//���ݤ���A�ΨӴ���ajax��loading�ϥ�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//����ШD�H��
		//�B�z�ШD�H��
		//�T���B�z���G
		response.getWriter().write("���մ��ըϥ�AJAX");
	}

}
