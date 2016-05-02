package com.schoolo2o.test;

import java.util.List;

import com.schoolo2o.dao.AdminInfoDao;
import com.schoolo2o.pojo.Admininfo;

public class TestAdmininfoDaoImpl {
	AdminInfoDao adminInfoDao;

	public AdminInfoDao getAdminInfoDao() {
		return adminInfoDao;
	}
	public void setAdminInfoDao(AdminInfoDao adminInfoDao) {
		this.adminInfoDao = adminInfoDao;
	}
	public  boolean addTest(Admininfo admin){
		return adminInfoDao.add(admin);
	}      
	public boolean updateTest(Admininfo admin){
		return adminInfoDao.update(admin);
	}    
	public boolean deleteTest(String adminName){
		return adminInfoDao.delete(adminName);
	}     
	public Admininfo searchTest(String adminName){
		return adminInfoDao.search(adminName);
	}
}
