package com.schoolo2o.service;

import java.util.List;

import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Orderstatus;

public interface OrderService {
	/**
	 * 增加一条订单
	 * @param userName 用户名
	 * @param shopName 商店名
	 * @param docId    文档ID
	 * @param pageCount 文档页数
	 * @param price    每页单价　
	 * @param fileCount 文件份数
	 * @param addressId 送货地址ID
	 * @param printRequire 打印要求
	 * @param payType 支付方式　　１线下支付　２线上支付
	 * @param sendType 送货方式　１
	 * @return 成功为 true,否则为false;
	 */
	public boolean addOrder(String userName,String shopName,Long[] docId, Integer[] pageCount,
			Double[] price, Integer[] fileCount, String[] printRequire, 
			Long addressId,Integer payType,Integer sendType);
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
	
}
