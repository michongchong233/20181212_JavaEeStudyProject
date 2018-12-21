package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����t�@��Servlet���ServletContext��H
 */
@WebServlet(
		urlPatterns = { "/28_02_test" }, 
		initParams = { 
				@WebInitParam(name = "28_02_test", value = "28_02_test")
		})
public class T28_02_OtherServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String logLocation = this.getClass().getName();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ServletContext
		ServletContext sc = this.getServletContext();
		if(sc.getAttribute("studyNote") != null)//�קK������ƾڤ��s�b��^null
			System.out.println(logLocation + " || ServletContext:studyNote=" + sc.getAttribute("studyNote"));

	}

}
