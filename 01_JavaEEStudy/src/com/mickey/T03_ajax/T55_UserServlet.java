package com.mickey.T03_ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.T03_pojo.T55_User;
import com.mickey.T03_service.T55_UserService;
import com.mickey.T03_serviceImpl.T55_UserServiceImpl;

/**
 * Servlet implementation class T55_UserServlet
 */
@WebServlet(
		urlPatterns = { "/55_test" }, 
		initParams = { 
				@WebInitParam(name = "55_test", value = "55_test")
		})
public class T55_UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求和響應編碼格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//獲取請求信息
		String name = request.getParameter("name");
		System.out.println("用戶請求信息為 --> " + name);
		//處理請求信息
		T55_UserService us = new T55_UserServiceImpl();//獲取業務層對象
		T55_User u = us.getUserInfoService(name);//處理業務
		//響應處理結果
	}

}
