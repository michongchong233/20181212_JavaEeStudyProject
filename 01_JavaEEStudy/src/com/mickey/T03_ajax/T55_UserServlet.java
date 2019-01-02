package com.mickey.T03_ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mickey.T03_pojo.T55_User;
import com.mickey.T03_service.T55_UserService;
import com.mickey.T03_serviceImpl.T55_UserServiceImpl;

/**
 * ajax for string & json��ݬ����B�z
 */
@WebServlet(
		urlPatterns = { "/55_test" }, 
		initParams = { 
				@WebInitParam(name = "55_test", value = "55_test")
		})
public class T55_UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�M�T���s�X�榡
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//����ШD�H��
		String name = request.getParameter("name");
		System.out.println("�Τ�ШD�H���� --> " + name);
		//�B�z�ШD�H��
		T55_UserService us = new T55_UserServiceImpl();//����~�ȼh��H
		T55_User u = us.getUserInfoService(name);//�B�z�~��
		if(u != null) {
			System.out.println(u.toString());
		}
		//�T���B�z���G(�Φr�Ŧ����)�A ���I�G�p�G�ƾڪ��ǧ��ܤ]�n��(�����@)�A�ӥB�b��x�ө�js��H(���K�N�X�\Ū)
		String responseText = "var u={};u.uid="+u.getUid()+";u.uname='"+u.getUname()+"';u.price="+u.getPrice()+";";
		responseText = "{uname:'mickey',price:123}";//�Φr�Ŧ����json�榡
		responseText = new Gson().toJson(u);//�ϥ�gson��json�榡
		System.out.println(responseText);
		response.getWriter().write(responseText);
	}

}
