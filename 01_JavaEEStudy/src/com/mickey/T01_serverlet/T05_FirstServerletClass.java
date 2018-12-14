package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T05_FirstServerletClass extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String printStr = "get a new request!!";
		resp.getWriter().write(printStr);
		System.out.println(printStr);
	}
}