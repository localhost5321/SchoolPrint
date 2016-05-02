package com.schoolo2o.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schoolo2o.dao.OrderInfoDao;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Orderstatus;
import com.schoolo2o.pojo.Shopinfo;
/**
 * 我做的
 * @author hua
 *
 */
public class OrderInfoDaoImpl extends HibernateDaoSupport implements OrderInfoDao {

	/*增加一条订单*/
	@Override
	public boolean addOrder(Orderinfo order) {
		try {
			if(!order.getOrderstatuses().isEmpty() && !order.getOrderitems().isEmpty()){
				this.getHibernateTemplate().save(order);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/*更新订单状态*/
	@Override
	public boolean updateStatus(Long orderId, Orderstatus status) {
		try {
			String hql = "from Orderstatus where orderinfo.orderId = '"+orderId+"'";
			List<Orderstatus> statusList = (List<Orderstatus>) this.getHibernateTemplate().find(hql);
			Iterator<Orderstatus> it = statusList.iterator();
			while(it.hasNext()){
				Orderstatus ot = it.next();
				if(ot.getIsCurrent() == 1){
					ot.setIsCurrent(0);
					status.setIsCurrent(1);
					status.setOrderinfo(ot.getOrderinfo());
					this.getHibernateTemplate().update(ot);
					this.getHibernateTemplate().save(status);
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*根据用户名来获取用户订单*/
	@Override
	public List<Orderinfo> userSearch(String userName) {
		List<Orderinfo> orderList = null;
		try {
			String hql = "from Orderinfo where userinfo.userName = '"+userName+"'";
			orderList = (List<Orderinfo>) this.getHibernateTemplate().find(hql);
			return orderList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}

	/*根据商店名来获取商店订单*/
	@Override
	public List<Orderinfo> shopSearch(String shopName) {
		List<Orderinfo> shopList = null;
		try {
			String hql = "from Orderinfo where shopinfo.shopName = '"+shopName+"' ";
			shopList = (List<Orderinfo>) this.getHibernateTemplate().find(hql);
			return shopList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shopList;
	}

}
