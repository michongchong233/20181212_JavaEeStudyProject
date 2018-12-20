package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
Session
�A�Ⱦ��ݪ��ƾڦs�x�޳N
�۷��O�b�A�Ⱦ��ݳЫؤ@�Ӧ��Τ᪽����������H�A�å�Cookie�޳N�NSession��id�s���s����
�@�ΡG�Ω�ѨM�@�ӥΤᤣ�P�ШD�B�z���ƾڦ@�ɰ��D�A�u�n�bJSESSIONID�����ĩMSession��H�����Ī����p�U�A�Τ᪺���N�ШD���������P�@��Session��H
��z�G�Τ�Ĥ@���X�ݪA�Ⱦ��A�A�Ⱦ��|�Ыؤ@��Session��H�����Τ�A�}�N��Session��H��JSESSIONID�ϥ�Cookie�޳N�s�x�����������A
	�O�ҥΤ᪺��L�ШD�b�B�z�ɳ���������P�@��Session��H�A�]�O�ҤF���P�ШD��������@�ɪ��ƾ�
�S�I�G
	�s�Ѧb�A�Ⱦ���
	�A�Ⱦ��i��Ы�
	�̿�Cookie�޳N
	�ͩR�P���G�bJSESSIONID�����ĩMSession��H�����Ī����p�U�@�ΰ쬰���ؤ�
	Session�b�A�Ⱦ����q�{�s�x�ɶ��O30����
�ϥΡG
	�Ы�Session��H/���Session��H�A�Y��Session���Ѳ�(JSEESSIONID)��^�즳Session�A�Y�S���Χ䤣��Session�h�Ыطs��Session
		HttpSession hs = request.getSession();
	�]�mSession���s�x�ɶ�
		hs.setMaxInactiveInterval(5);//5���S�Q�ϥΫh�P��
		�btomcat/conf/web.xml��session-timeout�]�w�A�]�i�]�w���ت�web.xml
	�]�mSession�j���
		hs.invalidate();
	�s�x�M����ƾ�
		�s�x�G
		����G
		�`�N�G�s�x���ʧ@�M���X���ʧ@�o�ͦb���P���ШD���A���O�s�x�n������X����
�ϥήɾ��G�@��Τ�b�n��web���خɷ|�N�Τ᪺�ӤH�H���s�x��Session���A�ѸӥΤ᪺��L�ШD�ϥ�
Session���ĳB�z�G�N�Τ�ШD����JSESSIONID�M��x����쪺Session��H��JSESSIONID�i����A�p�G�@�P�hSession�S���ġA�Ϥ����ġC���w�V��n������
	�Τ������s����-->���B�z
	�Τ�S�����s�����A��Session�L��-->�B�z
�`�N�GJSESSIONID�s�x�b�FCookie���{�ɦs�x�Ŷ����A�s���������Y����
 */
@WebServlet(
		urlPatterns = { "/24_test" }, 
		initParams = { 
				@WebInitParam(name = "24_test", value = "24_test")
		})
public class T24_SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�s�X�榡
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���s�X�榡
		response.setContentType("text/html;charset=utf-8");
		//����ШD�H��
		String name = "Mini";
		//�B�z�ШD�H��
			//�Ы�Session��H�A�Y��Session��^�즳Session�A�Ϥ��Ыطs��Session
			HttpSession hs = request.getSession();
			System.out.println("T24_SessionServlet --> " + hs.getId());
			//�]�mSession���s�x�ɶ�
			hs.setMaxInactiveInterval(5);//5���S�Q�ϥΫh�P��
			//�s�xSession�ƾ�
			hs.setAttribute("name", name);
			//�]�mSession�j���
//			hs.invalidate();
		//�T���B�z���G�A�����T��
			response.getWriter().write("Session Study");
	}
}
