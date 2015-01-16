package com.schoolo2o.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schoolo2o.dao.AddressDao;
import com.schoolo2o.pojo.Addressinfo;

/**
 * 添加或者更新一个地址信息
 * @author zhaolong
 *
 */
public class AddressDaoImpl extends HibernateDaoSupport implements AddressDao {

	@Override
	public boolean addOrUpdateAddress(Addressinfo address) {
		try{
			this.getHibernateTemplate().saveOrUpdate(address);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * 删除一个地址信息
	 */
	@Override
	public boolean deleteAddress(long id) {
		try{
			Addressinfo ai=this.getAddressById(id);
			if(ai!=null){
				this.getHibernateTemplate().delete(ai);
				return true;
			}else{
				System.out.println("当前地址不存在");
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 获得所有的地址信息
	 */
	@Override
	public List<Addressinfo> getAddresses(long userId) {
		try{
			String hql="from Addressinfo where userinfo.userId='"+userId+"'";
			List<Addressinfo> list=this.getHibernateTemplate().find(hql);
			if(list!=null&&!list.isEmpty()){
				return list;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Addressinfo getAddressById(long addressId) {
		try{
			String hql="from Addressinfo where addressId='"+addressId+"'";
			List<Addressinfo> list=this.getHibernateTemplate().find(hql);
			if(list!=null&&!list.isEmpty()){
				return list.iterator().next();
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	

}
