package com.schoolo2o.dao.impl;

import java.util.List;

import com.schoolo2o.dao.UserinfoDao;
import com.schoolo2o.pojo.Addressinfo;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Userinfo;

public class UserInfoDaoImpl implements UserinfoDao {

	//添加一个用户
	@Override
	public boolean addUser(Userinfo user) {
		if(user!=null){
			
		}
		return false;
	}

	//更新一个用户信息
	@Override
	public boolean updateUser(Userinfo user) {
		// TODO Auto-generated method stub
		return false;
	}
	//查找是否存在此用户
	@Override
	public Userinfo searchUser(Userinfo user) {
		// TODO Auto-generated method stub
		return null;
	}
	//给用户增加地址信息
	@Override
	public boolean addAddress(Addressinfo address) {
		// TODO Auto-generated method stub
		return false;
	}
	//更新用户地址信息
	@Override
	public boolean updateAddress(Addressinfo address) {
		// TODO Auto-generated method stub
		return false;
	}
	//删除用户地址信息
	@Override
	public boolean deleteAddress(Addressinfo address) {
		// TODO Auto-generated method stub
		return false;
	}
	//查找用户所有地址
	@Override
	public List<Addressinfo> searchAddress(Long userid) {
		// TODO Auto-generated method stub
		return null;
	}
	//查找当前用户所有地址
	@Override
	public List<Docinfo> searchDocs(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	//查找当前用户所有订单
	@Override
	public List<Orderinfo> getOrders(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
