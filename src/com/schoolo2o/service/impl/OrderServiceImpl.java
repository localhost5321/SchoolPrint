package com.schoolo2o.service.impl;

import java.util.List;

import com.schoolo2o.dao.OrderInfoDao;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Orderstatus;
import com.schoolo2o.service.OrderService;
/**
 * @对于订单操作的服务层实现
 * @author herozhao
 *
 */

public class OrderServiceImpl implements OrderService {
	private OrderInfoDao orderInfoDao;//依赖注入一个
	
	
	public OrderInfoDao getOrderInfoDao() {
		return orderInfoDao;
	}

	public void setOrderInfoDao(OrderInfoDao orderInfoDao) {
		this.orderInfoDao = orderInfoDao;
	}

	/**
	 * 添加一个订单
	 *@author herozhao
	 *@param order(订单信息)
	 *@return boolean （是否成功）
	 *
	 */
	@Override
	public boolean addOrder(Orderinfo order) {
		return orderInfoDao.addOrder(order);
	}

	/**
	 * 更新一个订单
	 * @author herozhao
	 * ＠param 订单id ,订单状态
	 * ＠return boolean 是否成功
	 */
	@Override
	public boolean updateStatus(Long orderId, Orderstatus status) {
		return orderInfoDao.updateStatus(orderId, status);
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

}
