package com.mickey.T07_Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
Listener
�@�ΡG��ť�@�ΰ��Hrequest�Bsession�Bappllication���ЫءB�P���M���e������
�ϥΡG
	�Ыؤ@�ӹ�{�F���w���f��java��
		��ťrequest�AServletRequestListener
			requestDestroyed(ServletRequestEvent arg0)//��l��
			requestInitialized(ServletRequestEvent arg0)//�P��
		��ťrequest�AServletRequestAttributeListener
			attributeAdded(ServletRequestAttributeEvent arg0)//��ťrequest�@�ΰ쪺�K�[
			attributeRemoved(ServletRequestAttributeEvent arg0)//��ťrequest�@�ΰ쪺�R��
			attributeReplaced(ServletRequestAttributeEvent arg0)��ťrequest�@�ΰ쪺�R��
			�`�N�G�ΰѥi�H����Q��ť��request�ƾڡAgetName()�BgetValue()�BgetServletRequest()
		��ťsession�AHttpSessionListener
			sessionCreated(HttpSessionEvent arg0)//��l��
			sessionDestroyed(HttpSessionEvent arg0)//�P��
			�`�N�G�ΰѥi�H����Q��ť��session��H�AgetSession()
		��ťsession�AHttpSessionAttributeListener
			attributeAdded(HttpSessionBindingEvent arg0)
			attributeRemoved(HttpSessionBindingEvent arg0)
			attributeReplaced(HttpSessionBindingEvent arg0)
			�`�N�G�ΰѥi�H����Q��ť��Session�ƾڡAgetName()�BgetValue()
		��ťapplication�AServletContextListener
			contextDestroyed(ServletContextEvent arg0)//��l�ơA�A�Ⱦ��}��
			contextInitialized(ServletContextEvent arg0)//�P���A�A�Ⱦ�����
			�`�N�G�ΰѥi�H����Q��ť��ServletContext��H
		��ťapplication�AServletContextAttributeListener
			attributeAdded(ServletContextAttributeEvent arg0)
			attributeRemoved(ServletContextAttributeEvent arg0)
			attributeReplaced(ServletContextAttributeEvent arg0)
			�`�N�G�ΰѥi�H����Q��ť��ServletContext�ƾڡAgetName()�BgetValue()
	�bweb.xml���t�m��ť����
		<listener>
			<listener-class>com.mickey.T07_Listener.T68_FirstListener</listener-class>
		</listener>
	�רҡG�έp��e�b�u�H�ơB�έp�����y�s���ơK

 */
public class T68_FirstListener implements 
		ServletRequestListener, ServletRequestAttributeListener, 
		HttpSessionListener, HttpSessionAttributeListener,
		ServletContextListener, ServletContextAttributeListener{
	//ServletRequestListener
	/**
	 * �P���ɽե�
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("T68_FirstListener-->requestDestroyed()");
	}
	
	/**
	 * �Ыخɽե�
	 */
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("T68_FirstListener-->requestInitialized()");
	}

	//ServletRequestAttributeListener
	/**
	 * ��ťrequest�@�ΰ쪺�K�[
	 */
	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("T68_FirstListener-->ADD a new Attribute: " + arg0.getName() + "--" + arg0.getValue());
	}

	/**
	 * ��ťrequest�@�ΰ쪺�R��
	 */
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("T68_FirstListener-->REMOVE a new Attribute: " + arg0.getName() + "--" + arg0.getValue());
	}
	
	/**
	 * ��ťrequest�@�ΰ쪺�ק�
	 */
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("T68_FirstListener-->UPDATE a new Attribute: " + arg0.getName() + "--" + arg0.getValue());
	}

	//HttpSessionListener
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("T68_FirstListener-->CREATE A NEW SESSION: " + arg0.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("T68_FirstListener-->DESTORY A NEW SESSION: " + arg0.getSession());
	}

	//HttpSessionAttributeListener
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("T68_FirstListener-->ADD A NEW SESSION: " + arg0.getName() + "--" + arg0.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("T68_FirstListener-->REMOVE A NEW SESSION: " + arg0.getName() + "--" + arg0.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("T68_FirstListener-->UPDATE A NEW SESSION: " + arg0.getName() + "--" + arg0.getValue());
	}

	//ServletContextListener
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("T68_FirstListener-->contextDestroyed()" + arg0.getServletContext());
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("T68_FirstListener-->contextInitialized()" + arg0.getServletContext());
	}

	//ServletContextAttributeListener
	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("T68_FirstListener-->ADD a new ServletContext: " + arg0.getName() + "--" + arg0.getValue());
		}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("T68_FirstListener-->REMOVE a new ServletContext: " + arg0.getName() + "--" + arg0.getValue());
		}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("T68_FirstListener-->UPDATE a new ServletContext: " + arg0.getName() + "--" + arg0.getValue());
	}
}
