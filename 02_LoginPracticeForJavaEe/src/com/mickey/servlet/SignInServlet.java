package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//獲取操作符
		String oper = request.getParameter("oper");
		if(oper.equals("signIn")) {//登入
			checkUserSignIn(request, response);
		}else if(oper.equals("out")) {//退出
			userOut(request, response);
		}else if(oper.equals("reg")) {//注冊
			
		}else {
			System.out.println("沒有找到對應的操作符：" + oper);
		}
		
	}
	
	/**
	 * 退出請求處理
	 */
	private void userOut(HttpServletRequest request, HttpServletResponse response) {
		//獲取Session對象
		HttpSession hs = request.getSession();
		//強制銷毀Session
		hs.invalidate();
		try {
			response.sendRedirect("SignIn.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 登入請求處理
	 */
	private void checkUserSignIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			//獲取Session
			HttpSession hs = request.getSession();
			//將用戶信息寫入Session中
			hs.setAttribute("user", user);
			
			//登入成功，重定向至dashboard
			response.sendRedirect("DashBoard.jsp");
		}else{
			request.setAttribute("errorMessage", "error");
			request.getRequestDispatcher("SignIn.jsp").forward(request, response);
		}
	}
}
