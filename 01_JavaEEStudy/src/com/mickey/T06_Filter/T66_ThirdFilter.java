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

/**
 * ¨Ï¥ÎµùÄÀ³]¸mfilter
 */
@WebFilter(
		urlPatterns = { "/65_test.do" }, 
		initParams = { 
				@WebInitParam(name = "66_02_filter", value = "66_02_filter")
		})
public class T66_ThirdFilter implements Filter {
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("T66_ThirdFilter-->doFilter()");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}
}
