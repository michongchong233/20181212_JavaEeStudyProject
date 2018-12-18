package com.mickey.T01_serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
Response對象學習
作用：用來響應數據到瀏覽器的一個對象
使用：設置響應頭、設置喀應實體
service請求處理代碼流程：設置響應編碼格式-->獲取請求數據-->處理請求數據-->響應處理結果
 */
@WebServlet(
		urlPatterns = { "/13_test" }, 
		initParams = { 
				@WebInitParam(name = "13_test", value = "13_test")
		})
public class T13_ResponseClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//響應處理結果，設置啁應信息
		response.setHeader("mouse", "Mickey");//同鍵會覆蓋
		//響應處理結果，添加響應信息
		response.addHeader("keybaord", "Microsoft");
		response.addHeader("keybaord", "XiaoMi");
		//設定編碼格式，若不設定的話中文會顯示亂碼
		response.setContentType("text/xml;charset=utf-8");//表示普通文本
		response.setContentType("text/plain;charset=utf-8");//表示普通文本
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		//設置響應狀態碼
		response.sendError(404,"Sorry");
		//設置響應實體
		response.getWriter().write("<b>print some message in website</b><br>");
		response.getWriter().write("輸入中文會有亂碼，應該在http響應頭寫響應編碼");
	}
}
