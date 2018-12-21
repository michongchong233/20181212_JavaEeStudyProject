package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
ServletConfig
�@�ΡG����bweb.xml�����C��Servlet��W�t�m���ƾ�
�ϥΡG
	�ϥ�ServletConfig��H
	���web.xml�����t�m�ƾ�

 */
public class T30_ServletConfigTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	Class myClass = this.getClass();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllUseUtil.setRequestResponseEcoding(request, response);//�]�m�ШD�B�T���s�X�榡
		//���ServletConfig��H
		ServletConfig sc = this.getServletConfig();
		//���web.xml�����t�m�ƾ�
		String tryConfig = sc.getInitParameter("tryConfig");
		AllUseUtil.getLogger(myClass, "tryConfig=" + tryConfig);
	}

}
