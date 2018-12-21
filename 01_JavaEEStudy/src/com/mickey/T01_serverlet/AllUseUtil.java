package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllUseUtil {
	
	public static void setRequestResponseEcoding(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllUseUtil.getLogger(AllUseUtil.class, "setRequestResponseEcoding");
		//�]�m�ШD�s�X�榡(post��)�A�b��o�ШD�H���e��s�X�榡
		request.setCharacterEncoding("UTF-8");
		//�]�m�T���s�X�榡
		response.setContentType("text/html;charset=utf-8");
	}
	
	//���LLogger
	@SuppressWarnings("rawtypes")
	public static void getLogger(Class myClass, String... messages) {
		String loggerClass = myClass.getName();
		String splitStr = " || ";
		StringBuffer loggerMessage = new StringBuffer().append(loggerClass);
		for(String message : messages) loggerMessage.append(splitStr).append(message);
		System.out.println(loggerMessage);
	}
	
}
