package com.mickey.T06_Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
Filter，過濾器
作用：對服務器接受的請求資源和響應給瀏覽器的資源進行管理，保護servlet
使用：
	創建一個實現了Filter接口的普通java類
	覆寫接口方法init()、doFilter()、destory()
	在web.xml中配置過濾器
		<filter>
		  <filter-name>65_filter</filter-name>
		  <filter-class>com.mickey.T06_Filter.T65_FirstFilter</filter-class><!-- filter的url -->
		</filter>
		<filter-mapping>
		  <filter-name>65_filter</filter-name>
		  <url-pattern>/*</url-pattern><!-- 代表所有的servlet都要攔截 -->
		</filter-mapping>
		注意：url-pattern：/*，表示攔截所有請求
			url-pattern：*.do，表示所有以.do結尾的請求，一般用來進行模塊攔截處理
			url-pattern：/test，表示攔截指定url的請求，針對某個servlet請求進行攔截，保護servlet
過濾器的生命周期：服務器啟動到服務器關閉
總結：過濾器程序員聲明和配置，服務器根據請求中的uri信息調用
執行：瀏覽器發起請求到服務器，服務器接收到請求後，根據uri信息在web.xml中找到對應的過濾器執行doFilter()，該方法對此次請求進行處理後如果符合要求則被執行，執行後如果還有符合要求的過濾器則繼進行過濾，找到執行對應的servlet進行請求處理，servlet對請求處理完畢後，也就是service()結束，還需要繼續返回相應的doFilter()繼執行
案例：統一編碼格式設置、session管理、權限管理、資源管理(統一水印、和諧詞匯…)

 */
public class T65_FirstFilter implements Filter {
	/**
	 * 服務器關閉時調用
	 */
	public void destroy() {
		System.out.println("T65_FirstFilter-->destroy()");
	}

	/**
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("T65_FirstFilter-->doFilter()");
		chain.doFilter(request, response);
		System.out.println("T65_FirstFilter-->doFilter()-->finish doFilter()");
	}

	/**
	 * 服務器初始化時調用
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("T65_FirstFilter-->init()");
	}

}
