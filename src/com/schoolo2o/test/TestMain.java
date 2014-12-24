package com.schoolo2o.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.schoolo2o.pojo.Priceinfo;
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
		comment.setCommentId(2L);
		comment.setCommentContent("这个打印店很好");
		comment.setCommentDate(new Date());
		comment.setCommentUser("huazai");
		comment.setShopScore(5);
		ApplicationContext context = new ClassPathXmlApplicationContext
				("applicationContext.xml");
		
		TestHiberate test = (TestHiberate) context.getBean("TestHiberate");
		comment.setShopReply("你好");
		Priceinfo pf = new Priceinfo();
		pf.setPrintType("双面打印");
		pf.setPrice(0.3);
//		test.testAddPriceType(pf, shop.getShopName());
//		test.testgetTypePrice(shop.getShopName());
//		pf.setPriceId(1L);
//		test.testUpdateTypePrice(pf, shop.getShopName());
		test.testDeleteTypePrice(2L);
	}

}
