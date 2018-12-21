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

import com.mickey.T01_service.T15_01_LoginService;
import com.mickey.T01pojo.T15_02_LoginUser;
import com.mickey.serverImp.T15_03_LoginServiceImpl;

/**
 * �w��Cookie�H��������A�Y�����Τ�h���εn�J(�i�J�[�ﭶ��)�A�Ϥ��i�J�n�J����
 */
@WebServlet(
		urlPatterns = { "/22_test" }, 
		initParams = { 
				@WebInitParam(name = "22_test", value = "22_test")
		})
public class T22_LoginCheckCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	Class myClass = this.getClass();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginPageUri = "14_01_test";
		String wellcomePageUri = "19_test";

		AllUseUtil.setRequestResponseEcoding(request, response);//�]�m�ШD�B�T���s�X�榡
		//����ШD�H���G���oCookie
		Cookie[] cookies = request.getCookies();
		//�B�z�ШD�H��
		//�T���B�z���G
		if(cookies != null) {
			for(Cookie cookie:cookies) {//�M���M��cookie�O�_��uid
				String uid = "";
				if(cookie.getName().equals("uid")) {
					uid = uid + cookie.getValue();

					AllUseUtil.getLogger(myClass, "cookie.getName()"+cookie.getName(), "uid="+uid);
					//�}�l����uid�H���b�ƾڮw�O�_�s�b
					T15_01_LoginService ls = new T15_03_LoginServiceImpl();
					T15_02_LoginUser user = ls.checkUidService(cookie.getValue());
					if(user != null) {
						//�B�z�Y�Τ������s�������S�Mcookie���n�J����
						//�YSession�٦b�A�h�N�ƾڮw���Τ�H����s��Session�A�Ϥ��h�إ�Session�é�J�ƾڮw���Τ�H��
						HttpSession session = request.getSession();
						session.setMaxInactiveInterval(10);
						session.setAttribute("uid", user.getUid());
						session.setAttribute("uname", user.getUname());
						session.setAttribute("password", user.getPassword());
						AllUseUtil.getLogger(myClass, "JSESSIONID="+session.getId(), user.toString(), "wellcome back");
						
						//�qCookie�ۼW�������p�ƾ��ۼW
						ServletContext sc = this.getServletContext();
						int nums = (sc.getAttribute("nums") != null)?(int)(sc.getAttribute("nums"))+1:1;
						sc.setAttribute("nums", nums);
						
						//cookie��uid�åB��uid�b�ƾڮw�]�s�b�ɶi�J�w�ﭶ��
						response.sendRedirect(wellcomePageUri);
					}else {
						AllUseUtil.getLogger(myClass, "�d�L���Τ�A�n���s�n�J");
						response.sendRedirect(loginPageUri);
					}
				}
			}
		}else {
			AllUseUtil.getLogger(myClass, "�����n�J");
			response.sendRedirect(loginPageUri);
		}
	}
}
