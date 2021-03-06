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
 * 關於用戶的所有servlet
 * 根據不同操作符調用不同的方法
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
		System.out.println(oper);
		if(oper.equals("signIn")) {//登入
			checkUserSignIn(request, response);
		}else if(oper.equals("out")) {//退出
			userOut(request, response);
		}else if(oper.equals("allUser")) {//查調所有用戶資料
			getAllUser(request, response);
		}else if(oper.equals("changePwd")) {//修改密碼
			changePassword(request, response);
		}else if(oper.equals("reg")) {//注冊
			addAccount(request, response);
		}else {
			System.out.println("沒有找到對應的操作符：" + oper);
		}
	}
	
	/**
	 * 處理注冊用戶請求
	 */
	private void addAccount(HttpServletRequest request, HttpServletResponse response) {
		UserDTO user = new UserDTO();
		user.setUname(request.getParameter("uname"));
		user.setPassword(request.getParameter("password"));
		user.setGender(Byte.parseByte(request.getParameter("gender")));
		int age = 0;
		if(request.getParameter("age")!=null && request.getParameter("age")!="") {
			age = Integer.parseInt(request.getParameter("age"));
		}
		user.setAge(age);
		String birth = request.getParameter("birth");//06/18/1969
		if(birth != "" && birth != null) {
			String[] births = birth.split("/");
			for(int i = 0; i <= births.length-1; i++) {
				System.out.println(births[i]);
			}
			String newBirth = births[2] + "-" + births[0] + "-" + births[1];
			user.setBirth(newBirth);
		}
		System.out.println(user.toString());
		UserService addAccount = new UserServiceImpl();
		if(addAccount.signUpAccount(user) > 0) {
			System.out.println("新增戶成功");
		} else {
			System.out.println("新增戶失敗");
		}
	}
	
	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		String newPassword = request.getParameter("newPassword");
		int uid = ((UserDTO)request.getSession().getAttribute("user")).getUid();
		System.out.println(newPassword);
		UserService changePassword = new UserServiceImpl();
		int updateNum = changePassword.changePassword(uid, newPassword);
		if(updateNum > 0) {
			System.out.println("修改密碼成功");
			request.setAttribute("successMessage", "success");
			try {
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("修改密碼失敗");
		}
	}
	
	/**
	 * 處理獲取所有用戶信息請求
	 */
	private void getAllUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("search all user");
		UserService getAllUser = new UserServiceImpl();
		//將全部的用戶信息放到請求中
		request.setAttribute("users", getAllUser.getAllUser());	
		try {
			//轉發請求
			request.getRequestDispatcher("AllUserInformation.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
