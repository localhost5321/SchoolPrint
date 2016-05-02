package com.schoolo2o.service;

import java.util.List;

import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Priceinfo;
import com.schoolo2o.pojo.ShopComment;
import com.schoolo2o.pojo.Shopinfo;

public interface ShopService {
	public boolean add(Shopinfo shopinfo);//用于添加shop信息
	public boolean update(Shopinfo shopinfo);//更新shop信息
	public List<Shopinfo> searchShop();//查找所有商店
	public boolean deleteShop(Shopinfo shopinfo);//删除一个商店
	public Shopinfo search(String name); //根据商店名查询商店
	public List<Orderinfo> getOrdersSplit(String shopName,int current,int step);//分页获取店铺订单
	public List<ShopComment> getComments(Long shopId);//根据本店id获取所有评论
	public List<ShopComment> getComments(String shopName);//根据本店用户名获取所有评论
	public boolean addComment(ShopComment comment,String ShopName);//添加一条评论
	public boolean updateComment(ShopComment comment, String ShopName);//更新一条评论
	public boolean daleteComment(Long commentId);//删除一条评论
	public List<ShopComment> getCommentsSplit(String shopName,int current,int step);//分页获取店铺评论
	public List<Priceinfo> getTypePrice(String shopName);//获得所有打印类型以及价格
	public boolean addTypePrice(Priceinfo priceinfo, String shopName);//添加一种打印类型以及价格
	public boolean deleteTypePrice(Long priceId);//删除一种打印类型以及价格
	public boolean updateTypePrice(Priceinfo priceinfo, String shopName);//更新一种打印类型以及价格
	
	/**
	 * 根据打印类型和商店名获取打印价格
	 * @param type 打印类型
	 * @param shopName 商店名
	 * @return
	 */
	public double getPrice(String type, String shopName);
}
