package com.mickey.T04_EL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
EL學習
問題：在servlet進行請求處理後，使用作用域對象作四數據流轉的載體，將數據流轉給對應的jsp文件，那麼在jsp中獲取作用或中的數據呢？
使用：
	傳統方式：在jsp頁面中使用java腳本段語句

 */
@WebServlet(
		urlPatterns = { "/57_test" }, 
		initParams = { 
				@WebInitParam(name = "57_test", value = "57_test")
		})
public class T57_FirstELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//localhost:8080/01_JavaEEStudy/57_test?uname=mickey&pwd=233
		//設置請求和響應編碼格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//獲取請求信息
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		//處理請求信息
		System.out.println(uname + "--" + pwd);
		//響應處理結果
		request.setAttribute("str", "Study EL class");//使用request作用域進行數據流流轉
		//Object
		//請求轉發
		request.getRequestDispatcher("T04_EL/T57_TryFirstEL.jsp").forward(request, response);
		
	}

}
