package com.schoolo2o.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.schoolo2o.pojo.ShopComment;
import com.schoolo2o.pojo.Shopinfo;

public class TestMain {
	public static void main(String[] args){
		Shopinfo shop = new Shopinfo();
		shop.setShopName("huazai");
		shop.setShopPwd("123456");
		shop.setShopNick("华仔打印店");
		shop.setShopAddress("洪辰六栋420");
		shop.setShopPic("/shop/picture/201412212207.jpg");
		shop.setShopDesc("我们是洪辰最好的打印店");
		shop.setDelivery(2.5);
		ShopComment comment = new ShopComment();
		comment.setCommentContent("这个打印店很好");
		comment.setCommentDate(new Date());
		comment.setCommentUser("huazai");
		comment.setShopScore(5);
		comment.setShopinfo(shop);
		ApplicationContext context = new ClassPathXmlApplicationContext
				("applicationContext.xml");
		
		TestHiberate test = (TestHiberate) context.getBean("TestHiberate");
//		test.TestAdd(shop);
//		test.testAddComment(comment);
//		test.testSearchComment(shop.getShopName());
		comment.setShopReply("谢谢");
//		comment.setCommentId(1L);
		test.testUpdateComment(comment);
	}

}
