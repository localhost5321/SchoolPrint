package com.schoolo2o.dao;

import java.util.List;

import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Orderstatus;

public interface OrderInfoDao {
	public boolean addOrder(Orderinfo order);  /*添加订单*/
	public boolean updateStatus(Long orderId, Orderstatus status);/*更新订单状态*/
	public List<Orderinfo> userSearch(String userName); /*根据用户ID查询订单*/
	public List<Orderinfo> shopSearch(String shopName); /*根据商店名查询订单*/
}
