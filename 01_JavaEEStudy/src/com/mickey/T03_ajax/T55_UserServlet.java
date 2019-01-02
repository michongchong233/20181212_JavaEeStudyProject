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
 * ajax for string & json後端相關處理
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
		if(u != null) {
			System.out.println(u.toString());
		}
		//響應處理結果(用字符串顯示)， 缺點：如果數據表順序改變也要改(難維護)，而且在後台申明js對象(不便代碼閱讀)
		String responseText = "var u={};u.uid="+u.getUid()+";u.uname='"+u.getUname()+"';u.price="+u.getPrice()+";";
		responseText = "{uname:'mickey',price:123}";//用字符串拼成json格式
		responseText = new Gson().toJson(u);//使用gson拼json格式
		System.out.println(responseText);
		response.getWriter().write(responseText);
	}

}
