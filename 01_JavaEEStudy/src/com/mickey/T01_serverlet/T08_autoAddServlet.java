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
		//從覆寫的service方法進入父類的service方法，在service方法處理完後，會再次根據請求方式響應doGet和doPost方法，所以一般情況下不會覆寫service中調用super.service(req, resp)，以避免出現405錯誤
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
