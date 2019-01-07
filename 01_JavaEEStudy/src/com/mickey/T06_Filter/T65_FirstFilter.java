package com.mickey.T06_Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
Filter�A�L�o��
�@�ΡG��A�Ⱦ��������ШD�귽�M�T�����s�������귽�i��޲z�A�O�@servlet
�ϥΡG
	�Ыؤ@�ӹ�{�FFilter���f�����qjava��
	�мg���f��kinit()�BdoFilter()�Bdestory()
	�bweb.xml���t�m�L�o��
		<filter>
		  <filter-name>65_filter</filter-name>
		  <filter-class>com.mickey.T06_Filter.T65_FirstFilter</filter-class><!-- filter��url -->
		</filter>
		<filter-mapping>
		  <filter-name>65_filter</filter-name>
		  <url-pattern>/*</url-pattern><!-- �N��Ҧ���servlet���n�d�I -->
		</filter-mapping>
		�`�N�Gurl-pattern�G/*�A����d�I�Ҧ��ШD
			url-pattern�G*.do�A��ܩҦ��H.do�������ШD�A�@��ΨӶi��Ҷ��d�I�B�z
			url-pattern�G/test�A����d�I���wurl���ШD�A�w��Y��servlet�ШD�i���d�I�A�O�@servlet
�L�o�����ͩR�P���G�A�Ⱦ��Ұʨ�A�Ⱦ�����
�`���G�L�o���{�ǭ��n���M�t�m�A�A�Ⱦ��ھڽШD����uri�H���ե�
����G�s�����o�_�ШD��A�Ⱦ��A�A�Ⱦ�������ШD��A�ھ�uri�H���bweb.xml�����������L�o������doFilter()�A�Ӥ�k�惡���ШD�i��B�z��p�G�ŦX�n�D�h�Q����A�����p�G�٦��ŦX�n�D���L�o���h�~�i��L�o�A�����������servlet�i��ШD�B�z�Aservlet��ШD�B�z������A�]�N�Oservice()�����A�ٻݭn�~���^������doFilter()�~����
�רҡG�Τ@�s�X�榡�]�m�Bsession�޲z�B�v���޲z�B�귽�޲z(�Τ@���L�B�M�ӵ��סK)

 */
public class T65_FirstFilter implements Filter {
	/**
	 * �A�Ⱦ������ɽե�
	 */
	public void destroy() {
		System.out.println("T65_FirstFilter-->destroy()");
	}

	/**
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("T65_FirstFilter-->doFilter()");
		chain.doFilter(request, response);
		System.out.println("T65_FirstFilter-->doFilter()-->finish doFilter()");
	}

	/**
	 * �A�Ⱦ���l�Ʈɽե�
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("T65_FirstFilter-->init()");
	}

}
