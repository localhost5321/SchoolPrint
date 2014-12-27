package com.schoolo2o.service.impl;

import java.util.List;

import com.schoolo2o.dao.ShopinfoDao;
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
	@Override
	public boolean add(Shopinfo shopinfo) {
		return shopinfoDao.add(shopinfo);
	}

	/**
	 * @author herozhao 
	 * @param shopinfo
	 * @return boolean
	 */
	@Override
	public boolean update(Shopinfo shopinfo) {
		return shopinfoDao.update(shopinfo);
	}

	/**
	 * @author herozhao
	 * @param null
	 * @return List
	 */
	@Override
	public List<Shopinfo> searchShop() {
		return shopinfoDao.searchShop();
	}

	/**
	 * @author herozhao
	 * @param shopinfo
	 * @return boolean
	 */
	@Override
	public boolean deleteShop(Shopinfo shopinfo) {
		return shopinfoDao.deleteShop(shopinfo);
	}

	/**
	 * @author herozhao
	 * @param shopName
	 * @return shopinfo
	 */
	@Override
	public Shopinfo search(String name) {
		// TODO Auto-generated method stub
		return shopinfoDao.search(name);
	}

	/**
	 * @author herozhao
	 * @param shopId
	 * @return list of Comments
	 */
	@Override
	public List<ShopComment> getComments(Long shopId) {
		return shopinfoDao.getComments(shopId);
	}

	/**
	 * @author herozhao
	 * @param shopname
	 * @return list of Comments
	 */
	@Override
	public List<ShopComment> getComments(String shopName) {
		return shopinfoDao.getComments(shopName);
	}
	/**
	 * @author herozhao
	 * @param comment ShopName
	 * @return boolean 
	 */
	@Override
	public boolean addComment(ShopComment comment, String ShopName) {
		return shopinfoDao.addComment(comment, ShopName);
	}

	/**
	 * @author herozhao
	 * @param comment comment shopname
	 * @return boolean
	 */
	@Override
	public boolean updateComment(ShopComment comment, String ShopName) {
		return shopinfoDao.updateComment(comment, ShopName);
	}

	/**
	 * @author herozhao
	 * @param commentId
	 * @return boolean
	 */
	@Override
	public boolean daleteComment(Long commentId) {
		return shopinfoDao.daleteComment(commentId);
	}

	/**
	 * @author herozhao
	 * @param shopname
	 * @return list
	 */
	@Override
	public List<Priceinfo> getTypePrice(String shopName) {
		return shopinfoDao.getTypePrice(shopName);
	}

	/**
	 * @author herozhao
	 * @param priceinfo shopName
	 * @return boolean
	 */
	@Override
	public boolean addTypePrice(Priceinfo priceinfo, String shopName) {
		return shopinfoDao.addTypePrice(priceinfo, shopName);
	}
	/**
	 * @author herozhao
	 * @param priceId
	 * @return boolean
	 */

	@Override
	public boolean deleteTypePrice(Long priceId) {
		return shopinfoDao.deleteTypePrice(priceId);
	}

	/**
	 * @author herozhao
	 * @param priceinfo shopname
	 * @return boolean
	 */
	@Override
	public boolean updateTypePrice(Priceinfo priceinfo, String shopName) {
		return shopinfoDao.updateTypePrice(priceinfo, shopName);
	}

}
