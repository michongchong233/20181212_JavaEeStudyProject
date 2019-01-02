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
 * ajax for XML後端相關處理
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
		//設置請求和響應編碼格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml;charset=UTF-8");
		//獲取請求信息
		String name = request.getParameter("name");
		System.out.println("用戶請求信息為 --> " + name);
		//處理請求信息
		T55_UserService us = new T55_UserServiceImpl();//獲取業務層對象
		T55_User u = us.getUserInfoService(name);//處理業務
		if(u != null) {
			System.out.println(u.toString());
		}
		//響應處理結果，用字符串拼xml，也可以用jsp寫xml，用EL取得對象，拼和取都沒有比json快速，而且若數據庫有改動也需要修改(json是有什麼取什麼)
		String responseText = "<person><user><uid>"+u.getUid()+"</uid><uname>"+u.getUname()+"</uname><price>"+u.getPrice()+"</price><loc>"+u.getLoc()+"</loc><desc>"+u.getDesc()+"</desc></user></person>";//使用xml格式
		System.out.println(responseText);
		response.getWriter().write(responseText);
	}
}
