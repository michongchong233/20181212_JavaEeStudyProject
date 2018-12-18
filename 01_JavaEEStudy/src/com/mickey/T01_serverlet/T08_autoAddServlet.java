package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T08_autoAddServlet
 */
@WebServlet(urlPatterns = { "/08_test" }, initParams = { @WebInitParam(name = "08_test", value = "try auto add") })
public class T08_autoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String printStr = "i'm server method!!";
		System.out.println(printStr);
//		super.service(req, resp);
		//�q�мg��service��k�i�J������service��k�A�bservice��k�B�z����A�|�A���ھڽШD�覡�T��doGet�MdoPost��k�A�ҥH�@�뱡�p�U���|�мgservice���ե�super.service(req, resp)�A�H�קK�X�{405���~
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("I'm doGet method!!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("I'm doPost method!!");
	}
}
