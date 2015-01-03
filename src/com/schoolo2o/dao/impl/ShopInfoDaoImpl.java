package com.schoolo2o.dao.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schoolo2o.dao.ShopinfoDao;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Priceinfo;
import com.schoolo2o.pojo.ShopComment;
import com.schoolo2o.pojo.Shopinfo;

/**
 * 我做的 shopInfo接口的实现
 * 
 * @author hua
 * 
 */
public class ShopInfoDaoImpl extends HibernateDaoSupport implements ShopinfoDao {

	private static final Logger log = Logger.getLogger(ShopInfoDaoImpl.class);
	@Override
	public boolean add(Shopinfo shopinfo) {   //添加一个商店
		if (shopinfo != null) {
			try {
				this.getHibernateTemplate().save(shopinfo);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else
			return false;
	}

	@Override
	public boolean update(Shopinfo shopinfo) {  //更新商店信息
		if (shopinfo != null) {
			try {
				this.getHibernateTemplate().update(shopinfo);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else
			return false;
	}

	@Override
	public List<Shopinfo> searchShop() { //查找所有商店,返回List
		String hql = " from Shopinfo";
		Session session=this.getSessionFactory().openSession();
		List<Shopinfo> shopList=null;
		try {
			Query q=session.createQuery(hql);
			shopList=q.list();
			System.out.print("come in");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return shopList;
	}

	@Override
	public boolean deleteShop(Shopinfo shopinfo) {  //删除一个商店
		if(shopinfo.getShopId() == null){
			String hql = "from Shopinfo where shopName =  '"+shopinfo.getShopName()+"' ";
			List<Shopinfo> shopList = this.getHibernateTemplate().find(hql);
			Iterator<Shopinfo> it = shopList.iterator();
			Shopinfo shop = it.next();
			shopinfo.setShopId(shop.getShopId());
		}
		try {
			this.getHibernateTemplate().delete(shopinfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Shopinfo search(String name) {   //根据商店名查询商店是否存在,若存在,返回商店bean,不存在,返回null
		Shopinfo shop = null;
		Session session=this.getSessionFactory().openSession();
		Query q=null;
		try{
		q=session.createQuery( "from Shopinfo where shopName =  '"+ name +"'");
		List <Shopinfo> shopList=q.list();
		Iterator<Shopinfo> it = shopList.iterator();
		if(it.hasNext())
			shop  = it.next();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			return shop;
		}
		
	}

	@Override
	public List<ShopComment> getComments(Long shopId) { //根据本店id获取所有评论
		String hql = "from ShopComment where shopinfo.shopId = '" +shopId+"' ";
		List<ShopComment> commentList = this.getHibernateTemplate().find(hql); 
		return commentList;
	}
	
	@Override
	public List<ShopComment> getComments(String shopName) {//获取店铺所有评论
		String hql = "from ShopComment where shopinfo.shopName = '" +shopName+"' ";
		List<ShopComment> commentList = this.getHibernateTemplate().find(hql); 
		return commentList;
	}
	/*添加评论*/
	@Override
	public boolean addComment(ShopComment comment ,String ShopName) { 
		try {
			String hql = "from Shopinfo where shopName = " +
				"'"+ShopName+"'";
			List<Shopinfo> shopList = this.getHibernateTemplate().find(hql);
			if( !shopList.isEmpty()){
				Shopinfo shop = shopList.get(0);
				comment.setShopinfo(shop);
				this.getHibernateTemplate().save(comment);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateComment(ShopComment comment, String ShopName) { //更新评论信息
		try {
			String hql = "from Shopinfo where shopName = " +
					"'"+ShopName+"'";
			List<Shopinfo> shopList = this.getHibernateTemplate().find(hql);
			comment.setShopinfo(shopList.get(0));
			this.getHibernateTemplate().update(comment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*删除评论信息*/
	@Override
	public boolean daleteComment(Long commentId) {
		try {
			String hql = " from ShopComment where commentId = '"+commentId+"'";
			List<ShopComment>  commentList = this.getHibernateTemplate().find(hql);
			this.getHibernateTemplate().delete(commentList.get(0));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/*获取一个商店所有的打印类型*/
	@Override
	public List<Priceinfo> getTypePrice(String shopName) {
		try {
			String hql = "from Priceinfo where shopinfo.shopName = '"+shopName+"'";
			List<Priceinfo> priceList = this.getHibernateTemplate().find(hql);
			return priceList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*添加一个商店的类目*/
	@Override
	public boolean addTypePrice(Priceinfo priceinfo, String shopName) {
		try {
			String hql = "from Shopinfo where shopName = " +
					"'"+shopName+"'";
			List<Shopinfo> priceList = this.getHibernateTemplate().find(hql);
			if(!priceList.isEmpty()){
				priceinfo.setShopinfo(priceList.get(0));
				this.getHibernateTemplate().save(priceinfo);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteTypePrice(Long priceId) {
		try {
			String hql = "from Priceinfo where priceId = '"+priceId+"'";
			List<Priceinfo> priceList =  this.getHibernateTemplate().find(hql);
			if(!priceList.isEmpty()){
				this.getHibernateTemplate().delete(priceList.get(0));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*更新商店价格信息表,需要更新内容和店铺名字*/
	@Override
	public boolean updateTypePrice(Priceinfo priceinfo, String shopName) {
		try {
			String hql = "from Shopinfo where shopName = '"+shopName+"' ";
			List<Shopinfo> shopList = this.getHibernateTemplate().find(hql);
			if(!shopList.isEmpty()){
				priceinfo.setShopinfo(shopList.get(0));
				this.getHibernateTemplate().update(priceinfo);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ShopComment> getCommentsSplit(String shopName, int current,
			int step) {
		List<ShopComment> list=null;
		Session session=this.getSessionFactory().openSession();
		Query q=null;
		try{
			q=session.createQuery("from ShopComment where shopinfo.shopName = '" +shopName+"' ");
			q.setFirstResult(current);
			q.setMaxResults(step);
		list= q.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			return list;
		}
	}

	@Override
	public List<Orderinfo> getOrdersSplit(String shopName, int current, int step) {
		List<Orderinfo> list=null;
		Session session=this.getSessionFactory().openSession();
		Query q=null;
		try{
			q=session.createQuery("from Orderinfo where shopinfo.shopName = '" +shopName+"' ");
			q.setFirstResult(current);
			q.setMaxResults(step);
			list=q.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			return list;
		}
	}

	@Override
	public double getPrice(String type, String shopName) {
		try {
			String hql = "from Priceinfo where shopinfo.shopName = '"+shopName+"' and " +
					"printType = '"+type+"'";
			List<Priceinfo> priceList = this.getHibernateTemplate().find(hql);
			if( !priceList.isEmpty()){
				Iterator<Priceinfo> it = priceList.iterator();
				Priceinfo price = it.next();
				return price.getPrice();
			}
		} catch (Exception e) {
		}
		return 0;
	}
}
