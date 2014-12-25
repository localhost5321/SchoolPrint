package com.schoolo2o.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.schoolo2o.pojo.Admininfo;

public class TestAdminInfoDaoMain {

	public static void main(String[] args) {
		Admininfo ai=new Admininfo();
		ai.setAdminName("zhaolong");
		ai.setAdminPwd("1014187702");
		ApplicationContext context = new ClassPathXmlApplicationContext
				("applicationContext.xml");
		TestAdmininfoDaoImpl tid=(TestAdmininfoDaoImpl) context.getBean("TestAdminInfoDaoImpl");
		//测试添加
		//		tid.addTest(ai);
		
		//测试查询
//		List<Admininfo>list=tid.searchTest("wangli");
//		System.out.println(list.iterator().next().getAdminName());
		
		//测试删除
//		boolean flag=tid.deleteTest("wanlgi");
//		System.out.print(flag);
		
		//测试更新
//		boolean flag=tid.updateTest(ai);
//		System.out.print(flag);
		
		
		
	}

}
