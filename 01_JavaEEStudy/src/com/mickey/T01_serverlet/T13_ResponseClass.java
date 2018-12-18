package com.mickey.T01_serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
Response��H�ǲ�
�@�ΡG�Ψ��T���ƾڨ��s�������@�ӹ�H
�ϥΡG�]�m�T���Y�B�]�m��������
service�ШD�B�z�N�X�y�{�G�]�m�T���s�X�榡-->����ШD�ƾ�-->�B�z�ШD�ƾ�-->�T���B�z���G
 */
@WebServlet(
		urlPatterns = { "/13_test" }, 
		initParams = { 
				@WebInitParam(name = "13_test", value = "13_test")
		})
public class T13_ResponseClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�T���B�z���G�A�]�m�����H��
		response.setHeader("mouse", "Mickey");//�P��|�л\
		//�T���B�z���G�A�K�[�T���H��
		response.addHeader("keybaord", "Microsoft");
		response.addHeader("keybaord", "XiaoMi");
		//�]�w�s�X�榡�A�Y���]�w���ܤ���|��ܶýX
		response.setContentType("text/xml;charset=utf-8");//��ܴ��q�奻
		response.setContentType("text/plain;charset=utf-8");//��ܴ��q�奻
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		//�]�m�T�����A�X
		response.sendError(404,"Sorry");
		//�]�m�T������
		response.getWriter().write("<b>print some message in website</b><br>");
		response.getWriter().write("��J����|���ýX�A���Ӧbhttp�T���Y�g�T���s�X");
	}
}
