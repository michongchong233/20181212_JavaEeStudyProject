package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.dto.UserDTO;
import com.mickey.service.UserService;
import com.mickey.service.impl.UserServiceImpl;

/**
 * 
 */
@WebServlet(
		urlPatterns = { "/SignIn" }, 
		initParams = { 
				@WebInitParam(name = "SignIn", value = "SignIn")
		})
public class SignInServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;

	@Override
	void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//獲取請求信息
		String uname = (String)request.getParameter("uname");
		String password = (String)request.getParameter("password");
		//處理請求信息
		UserService checkSignIn = new UserServiceImpl();
		UserDTO user = checkSignIn.checkUserSignIn(uname, password);
		if (user != null) {
			//如果有勾選Remenber Me就將uid存儲至Cookie中
			String remenberMe = request.getParameter("remenberMe");
			if(remenberMe != null && remenberMe.equals("remenberMe")) {
				Cookie userCookie = new Cookie("uid", Integer.toString(user.getUid()));
				userCookie.setMaxAge(3*24*3600);//設置Cookie有效期限
				response.addCookie(userCookie);
			}
			System.out.println(user.toString() + " --> success to sign in");
		}else{
			System.out.println("failed to sign in");
		}
		
	}

	
}
