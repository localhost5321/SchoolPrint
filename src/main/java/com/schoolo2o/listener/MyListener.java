package com.schoolo2o.listener;

import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.utils.Console;
@WebListener("监听session的动态")
public class MyListener implements HttpSessionListener{
	private int countOnLine=0;
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session create");
		countOnLine++;
		Console.LOG(getClass(), "当前在线人数~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+countOnLine);
		se.getSession().getServletContext().setAttribute("countOnLine", countOnLine);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session destroy");
		countOnLine--;
		Console.LOG(getClass(), "当前在线人数~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+countOnLine);
		Map userOnLine=(Map) se.getSession().getServletContext().getAttribute("userName");
		Userinfo localUser=(Userinfo) se.getSession().getAttribute("user");
		if(userOnLine!=null&&localUser!=null){
			userOnLine.remove(localUser.getUserName());
			Console.LOG(getClass(), "用户"+localUser.getUserName()+"已经退出");
		}
		se.getSession().getServletContext().setAttribute("countOnLine", countOnLine);
	}

}
