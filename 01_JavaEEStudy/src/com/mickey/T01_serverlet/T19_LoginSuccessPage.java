package com.mickey.T01_serverlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��ܵn�J���\����
 */
@WebServlet(
		urlPatterns = { "/19_test" }, 
		initParams = { 
				@WebInitParam(name = "19_test", value = "19_test")
		})
public class T19_LoginSuccessPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	Class myClass = this.getClass();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllUseUtil.setRequestResponseEcoding(request, response);//�]�m�ШD�B�T���s�X�榡
		//����ШD�H���A�L�׽֨ӳ�������X�n�J����(�����T��)�A�G���������L
		//�B�z�ШD�H���A�L�׽֨ӳ�������X�n�J����(�����T��)�A�G���������L
		//���request�@�ΰ�ƾ�
		String user = (String)request.getAttribute("loginUser");
		
		Cookie[] cookies = request.getCookies();
		String oldSession = "";
		if(cookies != null) for(Cookie cookie : cookies) if(cookie.getName().equals("JSESSIONID")) oldSession = cookie.getValue();
		//���Session��H�ƾ�
		HttpSession session = request.getSession();
		if(!session.getId().equals(oldSession)) {//�Y��Session����, ��^�n�J����
			AllUseUtil.getLogger(myClass, "oldSession"+oldSession, "session.getId()="+session.getId(), "NOT EQUALS");
			response.sendRedirect("/01_JavaEEStudy/14_01_test");
			return;
		}
		String uname = (String) session.getAttribute("uname");
		
		//����p�ƾ�
		ServletContext sc = this.getServletContext();
		//TODO
		int nums = (sc.getAttribute("nums")!=null)?(int)sc.getAttribute("nums"):0;
		
		//�T���B�z���G
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		if(user != null)response.getWriter().write("<h3>Hello! "+ user +" Wellcome come back!!</h3>");
		if(uname != null)response.getWriter().write("<h3>Hello! "+ uname +" Wellcome come back!!</h3>");
		response.getWriter().write("<hr>");
		response.getWriter().write("<p>�s���p�ƾ��G" + nums + "</p>");		
		response.getWriter().write("<form action='27_test'>" + 
				"<input type='submit' value='Show Session'>" + 
				"</form>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
	}
}
