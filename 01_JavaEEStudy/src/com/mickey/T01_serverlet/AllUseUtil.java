package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllUseUtil {
	
	public static void setRequestResponseEcoding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllUseUtil.getLogger(AllUseUtil.class, "setRequestResponseEcoding");
		//設置請求編碼格式(post用)，在獲得請求信息前轉編碼格式
		request.setCharacterEncoding("UTF-8");
		//設置響應編碼格式
		response.setContentType("text/html;charset=utf-8");
	}
	
	//打印Logger
	@SuppressWarnings("rawtypes")
	public static void getLogger(Class myClass, String... messages) {
		String loggerClass = myClass.getName();
		String splitStr = " || ";
		StringBuffer loggerMessage = new StringBuffer().append(loggerClass);
		for(String message : messages) loggerMessage.append(splitStr).append(message);
		System.out.println(loggerMessage);
	}
	
}
