package com.schoolo2o.dao;

import java.util.List;

import com.schoolo2o.pojo.Orderinfo;

public interface OrderInfoDao {
	public boolean addOrder(Orderinfo order);  /*添加订单*/
	public boolean updateStatus(Long orderId);/*更新订单状态*/
	public List<Orderinfo> userSearch(Long userId); /*根据用户ID查询订单*/
	public List<Orderinfo> shopSearch(Long shopId); /*根据商店ID查询订单*/
}
