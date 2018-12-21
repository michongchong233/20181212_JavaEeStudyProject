package com.mickey.T01_serverlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
ServletContext
作用：解決不同用戶不同請求的數據共享問題
特點：服務器創建、用戶共享
作用域：整個項目內
生命周期：服務器啟動到服務器關閉
使用：
	1.獲取ServletContext對象
		ServletContext sc1 = this.getServletContext();
		ServletContext sc2 = this.getServletConfig().getServletContext();
		ServletContext sc3 = request.getSession().getServletContext();
	2.使用ServletContext對象完成數據共享
		數據存儲：sc1.setAttribute("studyNote", this.getClass().getName());
		數據獲取：sc.getAttribute("studyNote");
		注意：不同的用戶可以給ServletContext對象進行數據的存儲
			獲取的數據不存在返回null
	3.獲取項目中web.xml文件中的全局配置數據
		Enumeration<String> paramerters = sc1.getInitParameterNames();
		注意：獲取的數據不存在返回null
	
	在web.xml中配置全局數據
	<context-param>
		<param-name>myTestProgramName</param-name>
		<param-value>01_JavaEEStudy</param-value>
	</context-param>
	作用：
		將靜態數據和代碼進行解耦
		動態獲取項目webroot下的資源的絕對路徑；參數為項目根目錄的路徑(WebContent)
			String path = sc1.getRealPath("T01_servlet/T11_RequestClass.jsp");
		獲取webroot下的資源的流對象；參數為項目根目錄的路徑(WebContent)
			InputStream streamPath = sc1.getResourceAsStream("T01_servlet/T11_RequestClass.jsp");
			注意：只能獲取項目根目錄下的資源流對象，class文件的流對象需要使用類加載器獲取

 */
@WebServlet(
		urlPatterns = { "/28_01_test" }, 
		initParams = { 
				@WebInitParam(name = "28_01_test", value = "28_01_test")
		})
public class T28_01_ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String logLocation = this.getClass().getName() + " || ";

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置請求編碼格式
		request.setCharacterEncoding("UTF-8");
		//設置響應編碼格式
		response.setContentType("text/html;charset=utf-8");
		//獲取ServletContext對象
		ServletContext sc1 = this.getServletContext();
		ServletContext sc2 = this.getServletConfig().getServletContext();
		ServletContext sc3 = request.getSession().getServletContext();
		if(sc1==sc2 && sc2==sc3) System.out.println(logLocation + "sc1==sc2==sc3");
		//使用ServletContext對象完成數據共享
		sc1.setAttribute("studyNote", this.getClass().getName());
		System.out.println(logLocation + "ServletContext:studyNote=" + sc1.getAttribute("studyNote"));
		//獲取項目web.xml全局配置數據
		String str = sc1.getInitParameter("myTestProgramName");
		System.out.println(logLocation + "web.xml context-param value=" + str);
		//遍歷web.xml全局配置數據
		Enumeration<String> paramerters = sc1.getInitParameterNames();
		if(paramerters != null) {
			while(paramerters.hasMoreElements()) {
				String paramName = paramerters.nextElement();
				System.out.println(logLocation + "param-name=" + paramName + " || param-value=" + sc1.getInitParameter(paramName));
			}
		}
		//動態獲取項目webroot下的資源的絕對路徑
		String path = sc1.getRealPath("T01_servlet/T11_RequestClass.jsp");
		System.out.println(logLocation + "getRealPath=" + path);
		//獲取webroot下的資源的流對象
		InputStream streamPath = sc1.getResourceAsStream("T01_servlet/T11_RequestClass.jsp");
		System.out.println(logLocation + "getResourceAsStream=" + streamPath.getClass());
		
		//獲取請求數據
		//處理請求數據
		//響應處理結果

	}
}
