package com.schoolo2o.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.schoolo2o.dao.OrderInfoDao;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Orderitem;
import com.schoolo2o.pojo.Orderstatus;
import com.schoolo2o.pojo.Shopinfo;
import com.schoolo2o.pojo.Userinfo;

public class TestOrderInfoDao {
	
	private OrderInfoDao orderInfo = null;
	
	public OrderInfoDao getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfoDao orderInfo) {
		this.orderInfo = orderInfo;
	}

	public static void main(String[] args){
		Orderinfo order = new Orderinfo();
		order.setAddressId(1L);
		order.setPayType(1);
		order.setSendType(1);
		order.setTotalCost(12.3);
		Set<Orderitem> itemSet = new HashSet<Orderitem>();
		Orderitem item = new Orderitem();
		item.setFileName("文档1");
		item.setFileCount(3);
		item.setFilePrice(4.1);
		item.setPageNumber(41);
		item.setOrderinfo(order);
		itemSet.add(item);
		item = new Orderitem();
		item.setFileName("文档2");
		item.setFileCount(3);
		item.setFilePrice(4.1);
		item.setPageNumber(41);
		item.setOrderinfo(order);
		itemSet.add(item);
		order.setOrderitems(itemSet);
		Orderstatus status = new Orderstatus();
		status.setOrderinfo(order);
		status.setChangeTime(new Date());
		status.setStatus(1);
		status.setIsCurrent(1);
		order.getOrderstatuses().add(status);
		Shopinfo shop = new Shopinfo();
		shop.setShopId(9L);
		shop.setShopName("huazai");
		shop.setShopPwd("123456");
		shop.setShopNick("华仔打印店");
		shop.setShopAddress("洪辰六栋420");
		shop.setShopPic("/shop/picture/201412212207.jpg");
		shop.setShopDesc("我们是洪辰最好的打印店");
		shop.setDelivery(2.5);
		order.setShopinfo(shop);
		Userinfo user = new Userinfo();
		user.setUserId(1L);
		user.setUserName("huazai");
		user.setEmail("penghua234@163.com");
		user.setRegTime(new Date());
		order.setUserinfo(user);
		ApplicationContext context = new ClassPathXmlApplicationContext
				("applicationContext.xml");
		TestOrderInfoDao  test = (TestOrderInfoDao) context.getBean("TestOrderInfoDao");
		//System.out.println(test.orderInfo.addOrder(order));
//		status.setStatus(3);
//		status.setChangeTime(new Date());
//		System.out.println(test.orderInfo.updateStatus(3L, status));
		List<Orderinfo> orderList = test.orderInfo.userSearch(shop.getShopName());
		System.out.println(orderList.size());
	}
	
}
