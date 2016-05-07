package com.schoolo2o.service.impl;

import java.util.List;

import com.schoolo2o.dao.ShopinfoDao;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Priceinfo;
import com.schoolo2o.pojo.ShopComment;
import com.schoolo2o.pojo.Shopinfo;
import com.schoolo2o.service.ShopService;

/**
 * @author herozhao
 * some service layer options about shop 
 */
public class ShopServiceImpl implements ShopService {

	private ShopinfoDao shopinfoDao;
	
	public ShopinfoDao getShopinfoDao() {
		return shopinfoDao;
	}

	public void setShopinfoDao(ShopinfoDao shopinfoDao) {
		this.shopinfoDao = shopinfoDao;
	}

	/**
	 * @author herozhao
	 * @param shopinfo
	 * @return boolean 
	 */
	public boolean add(Shopinfo shopinfo) {
		return shopinfoDao.add(shopinfo);
	}

	/**
	 * @author herozhao 
	 * @param shopinfo
	 * @return boolean
	 */
	public boolean update(Shopinfo shopinfo) {
		return shopinfoDao.update(shopinfo);
	}

	/**
	 * @author herozhao
	 * @param null
	 * @return List
	 */
	public List<Shopinfo> searchShop() {
		return shopinfoDao.searchShop();
	}

	/**
	 * @author herozhao
	 * @param shopinfo
	 * @return boolean
	 */
	public boolean deleteShop(Shopinfo shopinfo) {
		return shopinfoDao.deleteShop(shopinfo);
	}

	/**
	 * @author herozhao
	 * @param shopName
	 * @return shopinfo
	 */
	public Shopinfo search(String name) {
		// TODO Auto-generated method stub
		return shopinfoDao.search(name);
	}

	/**
	 * @author herozhao
	 * @param shopId
	 * @return list of Comments
	 */
	public List<ShopComment> getComments(Long shopId) {
		return shopinfoDao.getComments(shopId);
	}

	/**
	 * @author herozhao
	 * @param shopname
	 * @return list of Comments
	 */
	public List<ShopComment> getComments(String shopName) {
		return shopinfoDao.getComments(shopName);
	}
	/**
	 * @author herozhao
	 * @param comment ShopName
	 * @return boolean 
	 */
	public boolean addComment(ShopComment comment, String ShopName) {
		return shopinfoDao.addComment(comment, ShopName);
	}

	/**
	 * @author herozhao
	 * @param comment comment shopname
	 * @return boolean
	 */
	public boolean updateComment(ShopComment comment, String ShopName) {
		return shopinfoDao.updateComment(comment, ShopName);
	}

	/**
	 * @author herozhao
	 * @param commentId
	 * @return boolean
	 */
	public boolean daleteComment(Long commentId) {
		return shopinfoDao.daleteComment(commentId);
	}

	/**
	 * @author herozhao
	 * @param shopname
	 * @return list
	 */
	public List<Priceinfo> getTypePrice(String shopName) {
		return shopinfoDao.getTypePrice(shopName);
	}

	/**
	 * @author herozhao
	 * @param priceinfo shopName
	 * @return boolean
	 */
	public boolean addTypePrice(Priceinfo priceinfo, String shopName) {
		return shopinfoDao.addTypePrice(priceinfo, shopName);
	}
	/**
	 * @author herozhao
	 * @param priceId
	 * @return boolean
	 */

	public boolean deleteTypePrice(Long priceId) {
		return shopinfoDao.deleteTypePrice(priceId);
	}

	/**
	 * @author herozhao
	 * @param priceinfo shopname
	 * @return boolean
	 */
	public boolean updateTypePrice(Priceinfo priceinfo, String shopName) {
		return shopinfoDao.updateTypePrice(priceinfo, shopName);
	}

	public List<ShopComment> getCommentsSplit(String shopName, int current,
			int step) {
		return shopinfoDao.getCommentsSplit(shopName, current, step);
	}

	public List<Orderinfo> getOrdersSplit(String shopName, int current, int step) {
		return shopinfoDao.getOrdersSplit(shopName, current, step);
	}

	public double getPrice(String type, String shopName) {
		
		return this.getShopinfoDao().getPrice(type, shopName);
	}

}
