package com.schoolo2o.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.schoolo2o.pojo.Admininfo;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Userinfo;

public class TestDocInfoDaoMain {

	public static void main(String[] args) {
		Userinfo user=new Userinfo();
		user.setEmail("10145@qqrew.com");
		user.setRegTime(new Timestamp(new Date().getTime()));
		user.setUserName("zhaolong");
		user.setUserPwd("1212434343");
		user.setUserId(2l);
		Docinfo di=new Docinfo();
		di.setBrowseNum(11L);
		di.setDownNum(20l);
		di.setFileName("test4.doc");
		di.setFilePath("F:/hh/tt");
		di.setIsShare(1);
		di.setUserinfo(user);
		ApplicationContext context = new ClassPathXmlApplicationContext
				("applicationContext.xml");
		TestDocInfoDaoImpl tid=(TestDocInfoDaoImpl) context.getBean("TestDocInfoDaoImpl");
		//测试添加
		System.out.println(tid.addTest(di));
		
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
