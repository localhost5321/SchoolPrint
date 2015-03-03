package com.schoolo2o.service;

import java.util.List;

import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Orderstatus;
import com.schoolo2o.pojo.send.OrderSend;

public interface OrderService {
	
	/**
	 * 生成一个订单
	 * @param Osend 订单对象
	 * @return
	 */
	public OrderSend addOrder(OrderSend Osend);
	/**
	 * 更新订单状态
	 * @param orderId 订单ID
	 * @param status 订单状态
	 * @return
	 */
	public boolean updateStatus(Long orderId, Integer status);
	
	/**
	 * 根据用户名查询用户订单
	 * @param userName 用户名
	 * @return
	 */
	public List<Orderinfo> userSearch(String userName);
	/**
	 * 根据商店名查询商店订单
	 * @param shopName
	 * @return
	 */
	public List<Orderinfo> shopSearch(String shopName);
	
	/**
	 * 根据一个临时订单计算订单价格信息
	 * @param order
	 * @return
	 */
	public OrderSend getOrderPrice(OrderSend order);

}
