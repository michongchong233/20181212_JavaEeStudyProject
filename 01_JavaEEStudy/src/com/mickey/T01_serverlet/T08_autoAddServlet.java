package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T02_autoAddServlet
 */
@WebServlet(urlPatterns = { "/08_test" }, initParams = { @WebInitParam(name = "08_test", value = "try auto add") })
public class T08_autoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public T08_autoAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		/*
		 * �q�Ĥ@���եΨ�A�Ⱦ����� �p�G�bweb.xml��servlet���t�m�Fload-on-sartup�A�ͩR�P���N�O�q�A�Ⱦ��Ұʨ�A�Ⱦ�����
		 */
		System.out.println("servlet��l�Ƨ���");
	}

	@Override
	public void destroy() {
		System.out.println("�A�Ⱦ������ɰ���");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
