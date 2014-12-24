package com.schoolo2o.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schoolo2o.dao.OrderInfoDao;
import com.schoolo2o.pojo.Orderinfo;
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
	public boolean updateStatus(Long orderId) {
		return false;
	}

	/*根据用户ID来获取用户订单*/
	@Override
	public List<Orderinfo> userSearch(Long userId) {
		return null;
	}

	/*根据商店Id来获取商店订单*/
	@Override
	public List<Orderinfo> shopSearch(Long shopId) {
		return null;
	}

}
