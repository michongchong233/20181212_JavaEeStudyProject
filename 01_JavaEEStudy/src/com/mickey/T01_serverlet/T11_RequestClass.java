package com.mickey.T01_serverlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
request對象
服務器收到瀏覽器的請求後，會創建一個Request對象，對象中存儲了此次請求和相關的請求數據，服務器在調用Servlet時會得到創建的Request對象作為實參傳運Servlet的方法
request對象中封存了當前請求的所有請求數據
request對象是由tomcat服務器創建，并作為實參傳遞給servlet的service方法

 */
@WebServlet(
		urlPatterns = { "/11_test" }, 
		initParams = { 
				@WebInitParam(name = "11_test", value = "/11_test")
		})
public class T11_RequestClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//請求頭數據，請求方式，GET
		System.out.println("request.getMethod : " + request.getMethod());
		//請求頭數據，請求URL，http://localhost:8080/01_JavaEEStudy/11_test
		System.out.println("request.getRequestURL : " + request.getRequestURL());
		//請求頭數據，請求URI，/01_JavaEEStudy/11_test
		System.out.println("request.getRequestURI : " + request.getRequestURI());
		//請求頭數據，請求協議，http
		System.out.println("request.getScheme : " + request.getScheme());
		
		//指定請求行數據，Mozilla/5.0 (Windows NT 10.0; Win64; x64; Trident/7.0; rv:11.0) like Gecko
		System.out.println(request.getHeader("User-Agent"));
		//獲取請求行的所有鍵的數據
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()) {
			String headerKey = (String)e.nextElement();
			String headerValue = request.getHeader(headerKey);
			System.out.println(headerKey + "-->" + headerValue);
		}
		
		//獲取用戶數據，若返回的值是null代表getParameter的參數寫錯了
		System.out.println("uname : " + request.getParameter("uname"));
		System.out.println("pwd : " + request.getParameter("pwd"));
		
//		System.out.println("fav : " + request.getParameter("fav"));//針整同鍵不同值會有問題
		String[] favValues = request.getParameterValues("fav");//獲取用戶數據(同鍵不同值，如：多選)
		if(favValues != null) {//避免沒有選擇而出現空指針異常
			for(String favValue: favValues) {
				System.out.println("fav : " + favValue);
			}			
		}
		//獲取用戶數據的鍵的枚舉的集合
		Enumeration<String> eParameter = request.getParameterNames();
		while(eParameter.hasMoreElements()) {
			String parameterKey = (String)eParameter.nextElement();
			String[] parameterValues = request.getParameterValues(parameterKey);
			for(String parameterValue : parameterValues) {
				if(parameterValues != null) {
					System.out.println(parameterKey + " --> " + parameterValue);
				}
			}
		}
	}

}
