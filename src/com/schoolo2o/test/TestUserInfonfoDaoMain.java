package com.schoolo2o.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.schoolo2o.pojo.Addressinfo;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Userinfo;
/*
 * test UserInfoDao's implement
 *@zhaolong
 */

public class TestUserInfonfoDaoMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext
				("applicationContext.xml");
		TestUserInfoDaoImpl tid=(TestUserInfoDaoImpl ) context.getBean("TestUserInfoDaoImpl");
//		test add
		//		System.out.println(tid);
//		Userinfo user=new Userinfo();
//		user.setEmail("10145@qqrew.com");
//		user.setRegTime(new Date());
//		user.setUserName("zhaolong");
//		user.setUserPwd("1212434343");
//		user.setUserId(1l);
		//System.out.print(tid.addUser(user));
	
		
		//test update
		//System.out.print(tid.updateUser(user));
		
		//test dalete
//		String userName=user.getUserName();
//		Userinfo myuser=(Userinfo) tid.searchUser(userName);
//		Set<Docinfo>  docs=myuser.getDocinfos();
//		Iterator it=docs.iterator();
//		Docinfo doc=(Docinfo) it.next();
//		System.out.println(doc.getFileName());
		
		
		//test addAdressinfo
//		Addressinfo ai=new Addressinfo();
//		ai.setCallPhone("110324");
//		ai.setContactor("435436546");
//		ai.setIsDefault(1);
//		ai.setSecPhone("35434523");
//		ai.setSendAddress("nanhua");
//		ai.setUserinfo(user);
//		ai.setAddressId(2l);
//		System.out.println(tid.addAddress(ai));
//		
		
		//test searchAddressinfo
//		List<Addressinfo> list=(List) tid.searchAddress(1l);
//		
//		Addressinfo ai2=list.iterator().next();
//		System.out.println(ai2.getSecPhone());
		
		//test deleteAddressinfo
//		System.out.println(tid.deleteAddress(ai));
		
		//test searchDocinfo
//		List<Docinfo> list=tid.searchDocs(2l);
//		System.out.println(list.size());
//		Docinfo doc=list.iterator().next();
//		System.out.println(doc.getFilePath());
		
		//test checkEmail
		System.out.println(tid.checkEmail("10145@qq.com"));

	}

}
