package com.schoolo2o.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schoolo2o.dao.UserinfoDao;
import com.schoolo2o.pojo.Addressinfo;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.utils.Console;
/*
 * for the UserInfoDao's implement
 * @zhaolong
 * 
 */

public class UserInfoDaoImpl extends HibernateDaoSupport implements UserinfoDao {

	//添加一个用户
	@Override
	public boolean addUser(Userinfo user) {
		Console.LOG(getClass(), user);
		if(user != null){
			try{
				this.getHibernateTemplate().save(user);
				return true;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}

	//更新一个用户信息
	@Override
	public boolean updateUser(Userinfo user) {
		if(user!=null){
			String hql="from Userinfo where userName='"+user.getUserName()+"'";
			try{
				List<Userinfo> list=this.getHibernateTemplate().find(hql);
				Iterator<Userinfo> it=list.iterator();
				if (!it.hasNext()){
					return false;
				}else{
					Userinfo myUser= it.next();
					user.setUserId(myUser.getUserId());
					this.getHibernateTemplate().update(user);
					return true;
				}
			}catch(Exception e){
				return false;
			}
		}
		return false;
	}
	//查找是否存在此用户
	@Override
	public Userinfo searchUser(String userName) {
		String hql="from Userinfo where userName='"+userName+"'";
		try{
			List<Userinfo> list=this.getHibernateTemplate().find(hql);
			if(!list.isEmpty()){
				Iterator<Userinfo> it=list.iterator();
				Userinfo user=it.next();
				return user;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//给用户增加地址信息
	@Override
	public boolean addAddress(Addressinfo address) {
		if(address!=null){
			try{
				this.getHibernateTemplate().save(address);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
		}
		return false;
	}
	//更新用户地址信息
	@Override
	public boolean updateAddress(Addressinfo address) {
		String hql="from Addressinfo where addressId='"+address.getAddressId()+"'";
		try{
			List<Addressinfo> list=this.getHibernateTemplate().find(hql);
			Iterator<Addressinfo> it=list.iterator();
			if(it.hasNext()){
				Addressinfo af= it.next();
				address.setAddressId(af.getAddressId());
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	//删除用户地址信息
	@Override
	public boolean deleteAddress(Addressinfo address) {
		if(address!=null){
			String hql="from Addressinfo where addressId="+address.getAddressId();
			try{
				this.getHibernateTemplate().delete(address);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}else
			return false;
		
	}
	//查找用户所有地址
	@Override
	public List<Addressinfo> searchAddress(Long userId) {
		String hql="from Addressinfo where userId="+userId;
		try{
			List<Addressinfo> list=this.getHibernateTemplate().find(hql);
			Iterator<Addressinfo> it = list.iterator();
			if(it.hasNext()){
				return list;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//查找当前用户所有地址
	@Override
	public List<Docinfo> searchDocs(Long userId) {
		try{
			String hql="from Docinfo where userId="+userId;
			List<Docinfo> list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//查找当前用户所有订单
	@Override
	public List<Orderinfo> getOrders(Long userId) {
		try{
			String hql="from Orderinfo where userId="+userId;
			List<Orderinfo> list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean checkEmail(String email) {
		if(email!=null){
			String hql="from Userinfo where email='"+email+"'";
			try{
				List<Userinfo> list=this.getHibernateTemplate().find(hql);
				if(!list.isEmpty()){
					return true;
				}else{
					return false;
				}
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

}
