package com.mickey.T06_Filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T65_TryFilterServlet
 */
@WebServlet(
		urlPatterns = { "/65_test.do" }, 
		initParams = { 
				@WebInitParam(name = "65_test", value = "65_test")
		})
public class T65_TryFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�s�X�榡
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���s�X�榡
		response.setContentType("text/html;charset=UTF-8");
		//����ШD�H��
		System.out.println("T65_TryFilterServlet-->server()");
		//�B�z�ШD�H��
		//�T���B�z���G
		
	}
}
