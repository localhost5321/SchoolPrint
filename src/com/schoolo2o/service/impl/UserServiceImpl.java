package com.schoolo2o.service.impl;

import java.util.List;

import com.schoolo2o.dao.UserinfoDao;
import com.schoolo2o.pojo.Addressinfo;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.service.UserService;
/*
 * @zhaolong
 * UserService 的实现
 */
public class UserServiceImpl implements UserService {
	UserinfoDao userinfoDao;
	public UserinfoDao getUserinfoDao() {
		return userinfoDao;
	}
	public void setUserinfoDao(UserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}
	@Override
	public boolean addUser(Userinfo user) {
		return userinfoDao.addUser(user);
	}

	@Override
	public boolean updateUser(Userinfo user) {
		return userinfoDao.updateUser(user);
	}

	@Override
	public Userinfo searchUser(String userName) {
		return userinfoDao.searchUser(userName);
	}

	public boolean checkEmail(String email) {
		return userinfoDao.checkEmail(email);
	}

	public boolean addAddress(Addressinfo address) {
		return userinfoDao.addAddress(address);
	}

	public boolean updateAddress(Addressinfo address) {
		return userinfoDao.updateAddress(address);
	}

	
	public boolean deleteAddress(Addressinfo address) {
		return userinfoDao.deleteAddress(address);
	}

	
	public List<Addressinfo> searchAddress(Long userid) {
		return userinfoDao.searchAddress(userid);
	}


	public List<Docinfo> searchDocs(Long userId) {
		return userinfoDao.searchDocs(userId);
	}


	public List<Orderinfo> getOrders(Long userId) {
		return userinfoDao.getOrders(userId);
	}

}
