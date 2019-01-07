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
 * �Τ@�s�X�]�m�BSession�޲z
 */
@WebFilter(
		urlPatterns = { "/65_test.do" }, 
		initParams = { 
				@WebInitParam(name = "67_filter", value = "67_filter")
		})
public class T67_SessionFilter implements Filter {
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//�]�m�ШD�s�X�榡
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���s�X�榡
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//�P�_session
		HttpSession hs = ((HttpServletRequest)request).getSession();
		if(((HttpServletRequest)request).getAttribute("user") == null) {//�Y�Lsession�h���w�V
			((HttpServletResponse)response).sendRedirect("T06_Filter/T67_SessionIsNull.jsp");
		}else {
			System.out.println("T67_SessionFilter-->doFilter()");
			chain.doFilter(request, response);//�Y��session�h�~�����	
		}
		System.out.println("T67_SessionFilter-->doFilter()-->finish doFilter()");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}
}
