package com.schoolo2o.service.impl;


import com.schoolo2o.dao.AdminInfoDao;
import com.schoolo2o.pojo.Admininfo;
import com.schoolo2o.service.AdminService;
/*
 * @zhaolong
 * AdminService 接口的实现
 */
public class AdminServiceImpl implements AdminService{
	AdminInfoDao adminInfoDao;

	public AdminInfoDao getAdminInfoDao() {
		return adminInfoDao;
	}
	public void setAdminInfoDao(AdminInfoDao adminInfoDao) {
		this.adminInfoDao = adminInfoDao;
	}
	
	@Override
	public boolean add(Admininfo admin) {
		return adminInfoDao.add(admin);
	}
	@Override
	public boolean update(Admininfo admin) {
		return adminInfoDao.update(admin);
	}
	@Override
	public boolean delete(String adminName) {
		return adminInfoDao.delete(adminName);
	}
	@Override
	public Admininfo search(String adminName) {
		return adminInfoDao.search(adminName);
	}
}
