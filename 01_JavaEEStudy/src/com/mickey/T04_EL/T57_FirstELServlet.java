package com.mickey.T04_EL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.T04_pojo.Address;
import com.mickey.T04_pojo.T04_User;

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
		//使用request作用域進行數據流流轉
		request.setAttribute("str", "Study EL class");
		//Object
		request.setAttribute("user_01", new T04_User(5, "Amy", new Address("台灣", "新北市", "中山路")));
		//List<String>
		List<String> list_01 = new ArrayList<String>();
		list_01.add("Mickey");
		list_01.add("Mike");
		list_01.add("Ann");
		list_01.add("Florance");
		request.setAttribute("list_01", list_01);
		//List<T04_User>
		List<T04_User> list_02 = new ArrayList<T04_User>();
		list_02.add(new T04_User(1, "Sherry", new Address("台灣", "台北市", "忠孝東路")));
		list_02.add(new T04_User(1, "Danny", new Address("中國", "福建省", "四川路")));
		list_02.add(new T04_User(1, "Mini", new Address("美國", "紐約", "華爾街")));
		request.setAttribute("list_02", list_02);
		//Map<Integer, String>
		Map<String, String> map_01 = new HashMap<String, String>();
		map_01.put("x", "Tsai");
		map_01.put("y", "Wang");
		map_01.put("z", "Zhang");
		request.setAttribute("map_01", map_01);
		//Map<String, T04_User>
		Map<String, T04_User> map_02 = new HashMap<String, T04_User>();
		map_02.put("a", new T04_User(1, "Xu", new Address("台灣", "台中市", "福興街")));
		map_02.put("b", new T04_User(2, "Zhou", new Address("日本", "北海道", "新秀路")));
		map_02.put("c", new T04_User(3, "Chen", new Address("台灣", "高雄市", "泉全街")));
		request.setAttribute("map_02", map_02);
		//請求轉發
		request.getRequestDispatcher("T04_EL/T57_TryFirstEL.jsp").forward(request, response);
		
	}

}
