package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
Cookie�ǲߡG
�s�����ݪ��ƾڦs�x�޳N
�@�ΡG�ѨM�F���P�ШD���ƾڦ@�ɰ��D
�ϥΡG
	1.�Ы�Cookie��H
		Cookie c = new Cookie("computer", "thinkpad");
	2.�]�mCookie
		�]�m���Ĵ��Gc2.setMaxAge(3*24*3600);//3��
		�]�m���ĸ��|�Gc2.setPath("/01_JavaEEStudy/21_test");//http://localhost:8080/01_JavaEEStudy/21_test
	3.�T��Cookie�H�������
		response.addCookie(c);
	4.���Cookie�H���Ʋ�
		Cookie[] cookies = request.getCookies();
	�`�N�G�@��cookie��H�x�s�@����ȹ�
�S�I�G
	�s�����ݪ��ƾڦs�x�޳N
	�s�x���ƾ��n���b�A�Ⱦ���
	�q�{�OCookie�H���C���ШD���|���a�A���D�]�m���ĸ��|
	�{�ɦs�x�G�s�x�b�s�������B�椺�s���A�s���������Y����
	�w�ɦs�x�G�]�m�FCookie�����Ĵ��A�s�x�b�s�����ݪ����v�ƾڤ��A�b���Ĵ����ŦX���|�n�D���ШD���|���a�ӫH��
 */
/**
 *Cookie�]�m
 */
@WebServlet(
		urlPatterns = { "/20_test" }, 
		initParams = { 
				@WebInitParam(name = "20_test", value = "20_test")
		})
public class T20_CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�s�X�榡
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���s�X�榡
		response.setContentType("text/html;charset=utf-8");
		//����T���ƾ�
		//�B�z�T���ƾ�
		
		//�Ы�Cookie��H
		Cookie c = new Cookie("computer", "thinkpad");
		Cookie c2 = new Cookie("keyboard", "ASUS");
		//�]�mCookie���Ĵ�(��)�A�_�h�q�{Cookie�s���������Y����
		c2.setMaxAge(3*24*3600);//3��
		//�]�m���ĸ��|
		c2.setPath("/01_JavaEEStudy/21_test");//http://localhost:8080/01_JavaEEStudy/21_test
		//�T��Cookie�H��
		response.addCookie(c);
		response.addCookie(c2);
		//�T���B�z���G
		
	}
}
