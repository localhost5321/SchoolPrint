package com.schoolo2o.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.schoolo2o.dao.DocInfoDao;
import com.schoolo2o.dao.OrderInfoDao;
import com.schoolo2o.dao.ShopinfoDao;
import com.schoolo2o.dao.UserinfoDao;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Orderitem;
import com.schoolo2o.pojo.Orderstatus;
import com.schoolo2o.pojo.Shopinfo;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.pojo.send.OrderSend;
import com.schoolo2o.service.OrderService;
/**
 * @对于订单操作的服务层实现
 * @author herozhao
 *
 */

public class OrderServiceImpl implements OrderService {
	private OrderInfoDao orderInfoDao;//依赖注入一个
	private UserinfoDao userInfoDao;
	private ShopinfoDao shopInfoDao;
	private DocInfoDao docInfoDao;
	
	public OrderInfoDao getOrderInfoDao() {
		return orderInfoDao;
	}

	public void setOrderInfoDao(OrderInfoDao orderInfoDao) {
		this.orderInfoDao = orderInfoDao;
	}
	
	public UserinfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserinfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public ShopinfoDao getShopInfoDao() {
		return shopInfoDao;
	}

	public void setShopInfoDao(ShopinfoDao shopInfoDao) {
		this.shopInfoDao = shopInfoDao;
	}
	
	public DocInfoDao getDocInfoDao() {
		return docInfoDao;
	}

	public void setDocInfoDao(DocInfoDao docInfoDao) {
		this.docInfoDao = docInfoDao;
	}

	/**
	 * 计算一个临时订单的价格信息
	 *@author herozhao
	 *@param order(订单信息)
	 *@return boolean （是否成功）
	 *
	 */
	@Override
	public OrderSend getOrderPrice(OrderSend Osend) {
		for(int i=0; i<Osend.getDocId().length; i++){
			double price=Osend.getPageCount()[i] * Osend.getPrice()[i]*Osend.getFileCount()[i];
			BigDecimal bg = new BigDecimal(price);
	        double newPrice = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	        Osend.setItemPrice(newPrice, i);
	        Osend.setTotal(Osend.getTotal()+newPrice);
		}
		 System.out.println(Osend.getTotal()+"!!!!!~~~~~~~~~~~!!!!!!!!!!!!!");
		return Osend;
	}

	/**
	 * 更新一个订单
	 * @author herozhao
	 * ＠param 订单id ,订单状态
	 * ＠return boolean 是否成功
	 */
	@Override
	public boolean updateStatus(Long orderId, Integer status) {
		Orderstatus ot = new Orderstatus();
		ot.setIsCurrent(1);
		ot.setChangeTime(new Timestamp(new Date().getTime()));
		ot.setStatus(status);
		return orderInfoDao.updateStatus(orderId, ot);
	}

	/**
	 * 通过用户名查找订单列表
	 * @author herozhao
	 * ＠param　用户名
	 * @return List订单列表
	 * 
	 */
	@Override
	public List<Orderinfo> userSearch(String userName) {
		return orderInfoDao.userSearch(userName);
	}

	/**
	 * 通过商店名查找用户列表
	 * @param　商店名
	 * ＠return List订单列表 
	 */
	@Override
	public List<Orderinfo> shopSearch(String shopName) {
		return orderInfoDao.shopSearch(shopName);
	}

	@Override
	public OrderSend addOrder(OrderSend Osend) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
