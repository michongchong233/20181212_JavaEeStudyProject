package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
ServletConfig
作用：獲取在web.xml中給每個Servlet單獨配置的數據
使用：
	使用ServletConfig對象
	獲取web.xml中的配置數據

 */
public class T30_ServletConfigTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	Class myClass = this.getClass();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllUseUtil.setRequestResponseEcoding(request, response);//設置請求、響應編碼格式
		//獲取ServletConfig對象
		ServletConfig sc = this.getServletConfig();
		//獲取web.xml中的配置數據
		String tryConfig = sc.getInitParameter("tryConfig");
		AllUseUtil.getLogger(myClass, "tryConfig=" + tryConfig);
	}

}
