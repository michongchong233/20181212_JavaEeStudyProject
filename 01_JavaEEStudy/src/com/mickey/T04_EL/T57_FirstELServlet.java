package com.mickey.T04_EL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.T04_pojo.Address;
import com.mickey.T04_pojo.T04_User;

/**
EL�ǲ�
���D�G�bservlet�i��ШD�B�z��A�ϥΧ@�ΰ��H�@�|�ƾڬy�઺����A�N�ƾڬy�൹������jsp���A����bjsp������@�ΩΤ����ƾکO�H
�ϥΡG
	�ǲΤ覡�G�bjsp�������ϥ�java�}���q�y�y

 */
@WebServlet(
		urlPatterns = { "/57_test" }, 
		initParams = { 
				@WebInitParam(name = "57_test", value = "57_test")
		})
public class T57_FirstELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//localhost:8080/01_JavaEEStudy/57_test?uname=mickey&pwd=233
		//�]�m�ШD�M�T���s�X�榡
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//����ШD�H��
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		//�B�z�ШD�H��
		System.out.println(uname + "--" + pwd);
		
		//�T���B�z���G
		//�ϥ�request�@�ΰ�i��ƾڬy�y��
		request.setAttribute("str", "Study EL class");
		//Object
		request.setAttribute("user_01", new T04_User(5, "Amy", new Address("�x�W", "�s�_��", "���s��")));
		//List<String>
		List<String> list_01 = new ArrayList<String>();
		list_01.add("Mickey");
		list_01.add("Mike");
		list_01.add("Ann");
		list_01.add("Florance");
		request.setAttribute("list_01", list_01);
		//List<T04_User>
		List<T04_User> list_02 = new ArrayList<T04_User>();
		list_02.add(new T04_User(1, "Sherry", new Address("�x�W", "�x�_��", "�����F��")));
		list_02.add(new T04_User(1, "Danny", new Address("����", "�֫ج�", "�|�t��")));
		list_02.add(new T04_User(1, "Mini", new Address("����", "�ì�", "�غ���")));
		request.setAttribute("list_02", list_02);
		//Map<Integer, String>
		Map<String, String> map_01 = new HashMap<String, String>();
		map_01.put("x", "Tsai");
		map_01.put("y", "Wang");
		map_01.put("z", "Zhang");
		request.setAttribute("map_01", map_01);
		//Map<String, T04_User>
		Map<String, T04_User> map_02 = new HashMap<String, T04_User>();
		map_02.put("a", new T04_User(1, "Xu", new Address("�x�W", "�x����", "�ֿ���")));
		map_02.put("b", new T04_User(2, "Zhou", new Address("�饻", "�_���D", "�s�q��")));
		map_02.put("c", new T04_User(3, "Chen", new Address("�x�W", "������", "�u����")));
		request.setAttribute("map_02", map_02);
		//�ШD��o
		request.getRequestDispatcher("T04_EL/T57_TryFirstEL.jsp").forward(request, response);
		
	}

}
