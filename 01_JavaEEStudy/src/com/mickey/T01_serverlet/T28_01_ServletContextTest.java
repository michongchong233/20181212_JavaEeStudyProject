package com.mickey.T01_serverlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
ServletContext
�@�ΡG�ѨM���P�Τᤣ�P�ШD���ƾڦ@�ɰ��D
�S�I�G�A�Ⱦ��ЫءB�Τ�@��
�@�ΰ�G��Ӷ��ؤ�
�ͩR�P���G�A�Ⱦ��Ұʨ�A�Ⱦ�����
�ϥΡG
	1.���ServletContext��H
		ServletContext sc1 = this.getServletContext();
		ServletContext sc2 = this.getServletConfig().getServletContext();
		ServletContext sc3 = request.getSession().getServletContext();
	2.�ϥ�ServletContext��H�����ƾڦ@��
		�ƾڦs�x�Gsc1.setAttribute("studyNote", this.getClass().getName());
		�ƾ�����Gsc.getAttribute("studyNote");
		�`�N�G���P���Τ�i�H��ServletContext��H�i��ƾڪ��s�x
			������ƾڤ��s�b��^null
	3.������ؤ�web.xml��󤤪������t�m�ƾ�
		Enumeration<String> paramerters = sc1.getInitParameterNames();
		�`�N�G������ƾڤ��s�b��^null
	
	�bweb.xml���t�m�����ƾ�
	<context-param>
		<param-name>myTestProgramName</param-name>
		<param-value>01_JavaEEStudy</param-value>
	</context-param>
	�@�ΡG
		�N�R�A�ƾکM�N�X�i��ѽ�
		�ʺA�������webroot�U���귽��������|�F�ѼƬ����خڥؿ������|(WebContent)
			String path = sc1.getRealPath("T01_servlet/T11_RequestClass.jsp");
		���webroot�U���귽���y��H�F�ѼƬ����خڥؿ������|(WebContent)
			InputStream streamPath = sc1.getResourceAsStream("T01_servlet/T11_RequestClass.jsp");
			�`�N�G�u��������خڥؿ��U���귽�y��H�Aclass��󪺬y��H�ݭn�ϥ����[�������

 */
@WebServlet(
		urlPatterns = { "/28_01_test" }, 
		initParams = { 
				@WebInitParam(name = "28_01_test", value = "28_01_test")
		})
public class T28_01_ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String logLocation = this.getClass().getName() + " || ";

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�s�X�榡
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���s�X�榡
		response.setContentType("text/html;charset=utf-8");
		//���ServletContext��H
		ServletContext sc1 = this.getServletContext();
		ServletContext sc2 = this.getServletConfig().getServletContext();
		ServletContext sc3 = request.getSession().getServletContext();
		if(sc1==sc2 && sc2==sc3) System.out.println(logLocation + "sc1==sc2==sc3");
		//�ϥ�ServletContext��H�����ƾڦ@��
		sc1.setAttribute("studyNote", this.getClass().getName());
		System.out.println(logLocation + "ServletContext:studyNote=" + sc1.getAttribute("studyNote"));
		//�������web.xml�����t�m�ƾ�
		String str = sc1.getInitParameter("myTestProgramName");
		System.out.println(logLocation + "web.xml context-param value=" + str);
		//�M��web.xml�����t�m�ƾ�
		Enumeration<String> paramerters = sc1.getInitParameterNames();
		if(paramerters != null) {
			while(paramerters.hasMoreElements()) {
				String paramName = paramerters.nextElement();
				System.out.println(logLocation + "param-name=" + paramName + " || param-value=" + sc1.getInitParameter(paramName));
			}
		}
		//�ʺA�������webroot�U���귽��������|
		String path = sc1.getRealPath("T01_servlet/T11_RequestClass.jsp");
		System.out.println(logLocation + "getRealPath=" + path);
		//���webroot�U���귽���y��H
		InputStream streamPath = sc1.getResourceAsStream("T01_servlet/T11_RequestClass.jsp");
		System.out.println(logLocation + "getResourceAsStream=" + streamPath.getClass());
		
		//����ШD�ƾ�
		//�B�z�ШD�ƾ�
		//�T���B�z���G

	}
}
