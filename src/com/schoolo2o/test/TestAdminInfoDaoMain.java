package com.schoolo2o.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.schoolo2o.pojo.Admininfo;

public class TestAdminInfoDaoMain {

	public static void main(String[] args) {
		Admininfo ai=new Admininfo();
		ai.setAdminName("zhaolong4");
		ai.setAdminPwd("1234");
		ApplicationContext context = new ClassPathXmlApplicationContext
				("applicationContext.xml");
		TestAdmininfoDaoImpl tid=(TestAdmininfoDaoImpl) context.getBean("TestAdminInfoDaoImpl");
		tid.addTest(ai);
		List<Admininfo>list=tid.searchTest("zhaolong4");
		System.out.println(list.iterator().next().getAdminName());
		
	}

}
