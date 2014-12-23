package com.schoolo2o.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schoolo2o.dao.AdminInfoDao;
import com.schoolo2o.pojo.Admininfo;
/*
 * @author zhaolong
 * 
 */

public class AdminInfoDaoImpl extends HibernateDaoSupport implements AdminInfoDao {

	//增加一个管理员，当查找不存在此管理员时，进行增加
	@Override
	public boolean add(Admininfo admin) {
		if(search(admin.getAdminName())==null){
			try{
				this.getHibernateTemplate().save(admin);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}else{
			System.out.println("此管理员经存在");
			return false;
		}
	}
	//更新一个管理员信息，更新成功返回
	@Override
	public boolean update(Admininfo admin) {
		List <Admininfo> adminList=search(admin.getAdminName());
		if(adminList!=null){
			try{
				for(Admininfo a:adminList){
					if(a.getAdminName().equals(admin.getAdminName())){
						admin.setAdminId(a.getAdminId());
						this.getHibernateTemplate().update(admin);
						return true;
					}
				}
				return false;//循环走完没有找到
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}else{
			System.out.println("此管理员不存在");
			return false;
		}
	}

	//删除一个管理元信息
	@Override
	public boolean delete(String adminName) {
		List <Admininfo> adminList=search(adminName);
		if(adminList!=null){
			try{
				for(Admininfo a:adminList){
					if(a.getAdminName().equals(adminName)){
						this.getHibernateTemplate().update(a);
						return true;
					}
				}
				return false;//循环走完没有找到
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}else{
			System.out.println("此管理员不存在");
			return false;
		}
	}

	//检查管理员名是否存在，如果不存在返回null.如果存在返回一个用此名的管理员列表
		@Override
		public List<Admininfo> search(String adminName) {
			if(adminName!=null){
				String hql="from Admininfo where adminName=?";
				try{
					List<Admininfo> list=this.getHibernateTemplate().find(hql,new String[]{adminName});
					return list;
				}catch(Exception e){
					e.printStackTrace();
					return null;
				}
			}else{
				return null;
			}
		}
	
}
