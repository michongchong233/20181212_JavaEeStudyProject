package com.mickey.T05_JSTL;

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

@WebServlet(
		urlPatterns = { "/63_test" }, 
		initParams = { 
				@WebInitParam(name = "63_test", value = "63_test")
		})
public class T63_TryJSTLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<String>
		List<String> list_01 = new ArrayList<String>();
		list_01.add("Mickey");
		list_01.add("Mike");
		list_01.add("Ann");
		list_01.add("Florance");
		request.setAttribute("list_01", list_01);
		//Map<Integer, String>
		Map<String, String> map_01 = new HashMap<String, String>();
		map_01.put("x", "Tsai");
		map_01.put("y", "Wang");
		map_01.put("z", "Zhang");
		request.setAttribute("map_01", map_01);
		//請求轉發
		request.getRequestDispatcher("T05_JSTL/T61_TryFirstJSTL.jsp").forward(request, response);
	}

}
