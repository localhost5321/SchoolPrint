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
	private  UserinfoDao userinfoDao = null;
	public UserinfoDao getUserinfoDao() {
		return userinfoDao;
	}
	public void setUserinfoDao(UserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}
	/*添加一个用户*/
	@Override
	public boolean addUser(Userinfo user) {
		return userinfoDao.addUser(user);
	}

	/*用户信息更新*/
	@Override
	public boolean updateUser(Userinfo user) {
		return userinfoDao.updateUser(user);
	}

	/*根据用户名查询用户是否存在*/
	@Override
	public Userinfo searchUser(String userName) {
		return userinfoDao.searchUser(userName);
	}
	/**
	 * 查询email是否已经使用
	 */
	public boolean checkEmail(String email) {
		return userinfoDao.checkEmail(email);
	}

	/**
	 * 用户添加地址信息
	 */
	public boolean addAddress(Addressinfo address) {
		return userinfoDao.addAddress(address);
	}
	/**
	 * 用户更新地址信息
	 */
	public boolean updateAddress(Addressinfo address) {
		return userinfoDao.updateAddress(address);
	}

	/**
	 * 用户删除地址信息
	 */
	public boolean deleteAddress(Addressinfo address) {
		return userinfoDao.deleteAddress(address);
	}

	/**
	 * 用户获取所有的地址信息
	 */
	public List<Addressinfo> searchAddress(Long userid) {
		return userinfoDao.searchAddress(userid);
	}

	/**
	 * 用户获取所有的文档信息
	 */
	public List<Docinfo> searchDocs(Long userId) {
		return userinfoDao.searchDocs(userId);
	}

	/**
	 * 用户获取所有的订单信息
	 */
	public List<Orderinfo> getOrders(Long userId) {
		return userinfoDao.getOrders(userId);
	}

}
