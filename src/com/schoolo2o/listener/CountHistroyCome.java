package com.schoolo2o.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
@WebListener("统计历史访问量")
public class CountHistroyCome implements ServletRequestListener {
	private int history=0;
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		history++;
		System.out.println("到目前为止，本网站点击率已经突破"+history+"人次");
		int onLine=(int) arg0.getServletContext().getAttribute("countOnLine");
		System.out.println("当前在线人数为:"+onLine);
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		
	}

}
