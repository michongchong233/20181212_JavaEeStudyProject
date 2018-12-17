package com.mickey.T01_serverlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
request��H
�A�Ⱦ������s�������ШD��A�|�Ыؤ@��Request��H�A��H���s�x�F�����ШD�M�������ШD�ƾڡA�A�Ⱦ��b�ե�Servlet�ɷ|�o��Ыت�Request��H�@����ѶǹBServlet����k
request��H���ʦs�F��e�ШD���Ҧ��ШD�ƾ�
request��H�O��tomcat�A�Ⱦ��ЫءA�}�@����Ѷǻ���servlet��service��k

 */
@WebServlet(
		urlPatterns = { "/11_test" }, 
		initParams = { 
				@WebInitParam(name = "11_test", value = "/11_test")
		})
public class T11_RequestClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ШD�Y�ƾڡA�ШD�覡�AGET
		System.out.println("request.getMethod : " + request.getMethod());
		//�ШD�Y�ƾڡA�ШDURL�Ahttp://localhost:8080/01_JavaEEStudy/11_test
		System.out.println("request.getRequestURL : " + request.getRequestURL());
		//�ШD�Y�ƾڡA�ШDURI�A/01_JavaEEStudy/11_test
		System.out.println("request.getRequestURI : " + request.getRequestURI());
		//�ШD�Y�ƾڡA�ШD��ĳ�Ahttp
		System.out.println("request.getScheme : " + request.getScheme());
		
		//���w�ШD��ƾڡAMozilla/5.0 (Windows NT 10.0; Win64; x64; Trident/7.0; rv:11.0) like Gecko
		System.out.println(request.getHeader("User-Agent"));
		//����ШD�檺�Ҧ��䪺�ƾ�
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()) {
			String headerKey = (String)e.nextElement();
			String headerValue = request.getHeader(headerKey);
			System.out.println(headerKey + "-->" + headerValue);
		}
		
		//����Τ�ƾڡA�Y��^���ȬOnull�N��getParameter���ѼƼg���F
		System.out.println("uname : " + request.getParameter("uname"));
		System.out.println("pwd : " + request.getParameter("pwd"));
		
//		System.out.println("fav : " + request.getParameter("fav"));//�w��P�䤣�P�ȷ|�����D
		String[] favValues = request.getParameterValues("fav");//����Τ�ƾ�(�P�䤣�P�ȡA�p�G�h��)
		if(favValues != null) {//�קK�S����ܦӥX�{�ū��w���`
			for(String favValue: favValues) {
				System.out.println("fav : " + favValue);
			}			
		}
		//����Τ�ƾڪ��䪺�T�|�����X
		Enumeration<String> eParameter = request.getParameterNames();
		while(eParameter.hasMoreElements()) {
			String parameterKey = (String)eParameter.nextElement();
			String[] parameterValues = request.getParameterValues(parameterKey);
			for(String parameterValue : parameterValues) {
				if(parameterValues != null) {
					System.out.println(parameterKey + " --> " + parameterValue);
				}
			}
		}
	}

}
