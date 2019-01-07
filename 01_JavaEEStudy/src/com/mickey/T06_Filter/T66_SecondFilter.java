package com.mickey.T06_Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class T66_SecondFilter implements Filter {
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("T66_SecondFilter-->doFilter()");
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {}

}
