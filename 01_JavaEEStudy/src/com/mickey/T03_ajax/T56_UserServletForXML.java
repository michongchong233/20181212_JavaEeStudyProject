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
 * ajax for XML��ݬ����B�z
 * 
 */
@WebServlet(
		urlPatterns = { "/56_test" }, 
		initParams = { 
				@WebInitParam(name = "56_test", value = "56_test")
		})
public class T56_UserServletForXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�m�ШD�M�T���s�X�榡
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml;charset=UTF-8");
		//����ШD�H��
		String name = request.getParameter("name");
		System.out.println("�Τ�ШD�H���� --> " + name);
		//�B�z�ШD�H��
		T55_UserService us = new T55_UserServiceImpl();//����~�ȼh��H
		T55_User u = us.getUserInfoService(name);//�B�z�~��
		if(u != null) {
			System.out.println(u.toString());
		}
		//�T���B�z���G�A�Φr�Ŧ��xml�A�]�i�H��jsp�gxml�A��EL���o��H�A���M�����S����json�ֳt�A�ӥB�Y�ƾڮw����ʤ]�ݭn�ק�(json�O�����������)
		String responseText = "<person><user><uid>"+u.getUid()+"</uid><uname>"+u.getUname()+"</uname><price>"+u.getPrice()+"</price><loc>"+u.getLoc()+"</loc><desc>"+u.getDesc()+"</desc></user></person>";//�ϥ�xml�榡
		System.out.println(responseText);
		response.getWriter().write(responseText);
	}
}
