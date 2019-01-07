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
作用：監聽作用域對象request、session、appllication的創建、銷毀和內容的改變
使用：
	創建一個實現了指定接口的java類
		監聽request，ServletRequestListener
			requestDestroyed(ServletRequestEvent arg0)//初始化
			requestInitialized(ServletRequestEvent arg0)//銷毀
		監聽request，ServletRequestAttributeListener
			attributeAdded(ServletRequestAttributeEvent arg0)//監聽request作用域的添加
			attributeRemoved(ServletRequestAttributeEvent arg0)//監聽request作用域的刪除
			attributeReplaced(ServletRequestAttributeEvent arg0)監聽request作用域的刪除
			注意：形參可以獲取被監聽的request數據，getName()、getValue()、getServletRequest()
		監聽session，HttpSessionListener
			sessionCreated(HttpSessionEvent arg0)//初始化
			sessionDestroyed(HttpSessionEvent arg0)//銷毀
			注意：形參可以獲取被監聽的session對象，getSession()
		監聽session，HttpSessionAttributeListener
			attributeAdded(HttpSessionBindingEvent arg0)
			attributeRemoved(HttpSessionBindingEvent arg0)
			attributeReplaced(HttpSessionBindingEvent arg0)
			注意：形參可以獲取被監聽的Session數據，getName()、getValue()
		監聽application，ServletContextListener
			contextDestroyed(ServletContextEvent arg0)//初始化，服務器開啟
			contextInitialized(ServletContextEvent arg0)//銷毀，服務器關閉
			注意：形參可以獲取被監聽的ServletContext對象
		監聽application，ServletContextAttributeListener
			attributeAdded(ServletContextAttributeEvent arg0)
			attributeRemoved(ServletContextAttributeEvent arg0)
			attributeReplaced(ServletContextAttributeEvent arg0)
			注意：形參可以獲取被監聽的ServletContext數據，getName()、getValue()
	在web.xml中配置監聽器類
		<listener>
			<listener-class>com.mickey.T07_Listener.T68_FirstListener</listener-class>
		</listener>
	案例：統計當前在線人數、統計網頁流瀏次數…

 */
public class T68_FirstListener implements 
		ServletRequestListener, ServletRequestAttributeListener, 
		HttpSessionListener, HttpSessionAttributeListener,
		ServletContextListener, ServletContextAttributeListener{
	//ServletRequestListener
	/**
	 * 銷毀時調用
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("T68_FirstListener-->requestDestroyed()");
	}
	
	/**
	 * 創建時調用
	 */
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("T68_FirstListener-->requestInitialized()");
	}

	//ServletRequestAttributeListener
	/**
	 * 監聽request作用域的添加
	 */
	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("T68_FirstListener-->ADD a new Attribute: " + arg0.getName() + "--" + arg0.getValue());
	}

	/**
	 * 監聽request作用域的刪除
	 */
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("T68_FirstListener-->REMOVE a new Attribute: " + arg0.getName() + "--" + arg0.getValue());
	}
	
	/**
	 * 監聽request作用域的修改
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
