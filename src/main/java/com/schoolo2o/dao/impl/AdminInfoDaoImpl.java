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

	//增加一个管理员，添加成功返回true,添加失败返回false
	@Override
	public boolean add(Admininfo admin) {
		if(admin!=null){
			try{
				this.getHibernateTemplate().save(admin);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}else{
			return false;
		}
	}
	//更新一个管理员信息，更新成功返回
	@Override
	public boolean update(Admininfo admin) {
		if(admin==null)
			return false;
		Admininfo myAdmin=search(admin.getAdminName());
		if(myAdmin != null){
			try{
				admin.setAdminId(myAdmin.getAdminId());
				this.getHibernateTemplate().update(admin);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}else{
			return false;
		}
	}

	//删除一个管理元信息
	@Override
	public boolean delete(String adminName) {
		Admininfo admin=search(adminName);
		if(admin!=null){
			try{
				this.getHibernateTemplate().delete(admin);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}else{
			return false;
		}
	}

	//检查管理员名是否存在，如果不存在返回null.如果存在返回一个管理员
		@Override
		public Admininfo search(String adminName) {
			if(adminName!=null){
				String hql="from Admininfo where adminName='"+adminName+"'";
				try{
					System.out.println(this.getHibernateTemplate());
					List<Admininfo> list=(List<Admininfo>) this.getHibernateTemplate().find(hql);
					if(!list.isEmpty()){
						Admininfo admin=list.iterator().next();
						return admin;
					}else{
						return null;
					}
				}catch(Exception e){
					e.printStackTrace();
					return null;
				}
			}else{
				return null;
			}
		}
	
}
