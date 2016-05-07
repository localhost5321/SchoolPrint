package com.schoolo2o.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import com.schoolo2o.utils.Console;

@WebListener("统计历史访问量")
public class CountHistroyCome implements ServletRequestListener {
	private int history = 0;

	public void requestDestroyed(ServletRequestEvent arg0) {
		history++;
		Console.LOG(getClass(), "到目前为止，本网站点击率已经突破" + history + "人次");
//		if(arg0 != null && arg0.getServletContext() != null)
//		{
//			int onLine = (int) arg0.getServletContext().getAttribute("countOnLine");
//			Console.LOG(getClass(), "当前在线人数为:" + onLine);
//		}
	}

	public void requestInitialized(ServletRequestEvent arg0) {

	}

}
