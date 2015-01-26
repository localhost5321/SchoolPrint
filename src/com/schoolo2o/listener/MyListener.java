package com.schoolo2o.listener;

import java.util.Map;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.schoolo2o.pojo.Userinfo;
@WebListener("监听session的动态")
public class MyListener implements HttpSessionListener{
	private int countOnLine=0;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session create");
		countOnLine++;
		System.out.println("当前在线人数~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+countOnLine);
		se.getSession().getServletContext().setAttribute("countOnLine", countOnLine);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session destroy");
		countOnLine--;
		System.out.println("当前在线人数~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+countOnLine);
		Map userOnLine=(Map) se.getSession().getServletContext().getAttribute("userName");
		Userinfo localUser=(Userinfo) se.getSession().getAttribute("user");
		if(userOnLine!=null&&localUser!=null){
			userOnLine.remove(localUser.getUserName());
			System.out.println("用户"+localUser.getUserName()+"已经退出");
		}
		se.getSession().getServletContext().setAttribute("countOnLine", countOnLine);
	}

}
