package com.schoolo2o.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.schoolo2o.pojo.Priceinfo;
import com.schoolo2o.pojo.ShopComment;
import com.schoolo2o.pojo.Shopinfo;
import com.schoolo2o.service.ShopService;

public class TestMain {
	public static void main(String[] args){
		Shopinfo shop = new Shopinfo();
		shop.setShopName("zhangsan0007");
		shop.setShopPwd("123456");
		shop.setShopNick("华仔打印店");
		shop.setShopAddress("洪辰六栋420");
		shop.setShopPhone("15575462341");
		shop.setShopPic("/shop/picture/201412212207.jpg");
		shop.setShopDesc("我们是洪辰最好的打印店");
		shop.setShopPhone("2143434324");
		shop.setDelivery(2.5);
		ShopComment comment = new ShopComment();
		comment.setCommentId(8l);
		comment.setCommentContent("这个打印店很好");
		comment.setCommentDate(new Timestamp(new Date().getTime()));
		comment.setCommentUser("huazai");
		comment.setShopScore(5);
		ApplicationContext context = new ClassPathXmlApplicationContext
				("applicationContext.xml");
//		Set set=new HashSet();
//		set.add(comment);listSend
//		shop.setShopComments(set);
		ShopService test = (ShopService) context.getBean("shopService");
		test.add(shop);
		test.addComment(comment,"zhangsan00");
//		test.testAddComment(comment);
//		test.testSearchComment(shop.getShopName());
	//	comment.setShopReply("谢谢");
//		comment.setCommentId(1L);
//		test.testUpdateComment(comment);
//		comment.setShopReply("你好");
//		Priceinfo pf = new Priceinfo();
//		pf.setPrintType("双面打印");
//		pf.setPrice(0.3);
//		test.testAddPriceType(pf, shop.getShopName());
//		test.testgetTypePrice(shop.getShopName());
//		pf.setPriceId(1L);
//		test.testUpdateTypePrice(pf, shop.getShopName());
//		test.testDeleteTypePrice(2L);
	}

}
