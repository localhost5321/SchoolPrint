package com.schoolo2o.dao.impl;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.schoolo2o.dao.DocInfoDao;
import com.schoolo2o.pojo.Docinfo;
/*
 * @author zhaolong
 * haha
 */

//增加一个文档
public class DocInfoDaoImpl extends HibernateDaoSupport implements DocInfoDao {

	@Override
	public Docinfo add(Docinfo doc) {           //有问题，doc主键无法取到
		if(doc!=null){
			try{
				this.getHibernateTemplate().save(doc);
				doc.setDocId(2L);                          //问题，中午改
				return doc;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	//删除一个文档
	@Override
	public boolean delete(Long id) {
		try{
			String hql="from Docinfo where docId="+id;
			List<Docinfo> list=this.getHibernateTemplate().find(hql);
			Iterator it=list.iterator();
			Docinfo di=(Docinfo) it.next();
			this.getHibernateTemplate().delete(di);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	//更新一份文档
	@Override
	public boolean update(Docinfo doc) {
		try{
			this.getHibernateTemplate().update(doc);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Docinfo> search(Long userId) {
		try{
			String hql="from Docinfo where userId="+userId;
			List<Docinfo> list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
