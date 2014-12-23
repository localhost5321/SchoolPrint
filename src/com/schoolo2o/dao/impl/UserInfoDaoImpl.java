package com.schoolo2o.dao.impl;

import java.util.List;

import com.schoolo2o.dao.UserinfoDao;
import com.schoolo2o.pojo.Addressinfo;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Userinfo;

public class UserInfoDaoImpl implements UserinfoDao {

	@Override
	public boolean addUser(Userinfo user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(Userinfo user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Userinfo searchUser(Userinfo user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAddress(Addressinfo address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAddress(Addressinfo address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAddress(Addressinfo address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Addressinfo> searchAddress(Long userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docinfo> searchDocs(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orderinfo> getOrders(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
