package com.mickey.T06_Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 統一編碼設置、Session管理
 */
@WebFilter(
		urlPatterns = { "/65_test.do" }, 
		initParams = { 
				@WebInitParam(name = "67_filter", value = "67_filter")
		})
public class T67_SessionFilter implements Filter {
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//設置請求編碼格式
		request.setCharacterEncoding("UTF-8");
		//設置響應編碼格式
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//判斷session
		HttpSession hs = ((HttpServletRequest)request).getSession();
		if(((HttpServletRequest)request).getAttribute("user") == null) {//若無session則重定向
			((HttpServletResponse)response).sendRedirect("T06_Filter/T67_SessionIsNull.jsp");
		}else {
			System.out.println("T67_SessionFilter-->doFilter()");
			chain.doFilter(request, response);//若有session則繼續執行	
		}
		System.out.println("T67_SessionFilter-->doFilter()-->finish doFilter()");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}
}
