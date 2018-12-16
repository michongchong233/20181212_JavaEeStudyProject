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
		 * 從第一次調用到服務器關閉 如果在web.xml的servlet中配置了load-on-sartup，生命周期就是從服務器啟動到服務器關閉
		 */
		System.out.println("servlet初始化完成");
	}

	@Override
	public void destroy() {
		System.out.println("服務器關閉時執行");
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
