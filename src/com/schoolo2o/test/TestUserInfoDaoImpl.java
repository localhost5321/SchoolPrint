package com.schoolo2o.test;

import java.util.List;

import com.schoolo2o.dao.UserinfoDao;
import com.schoolo2o.pojo.Addressinfo;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Userinfo;


public class TestUserInfoDaoImpl {
	UserinfoDao userinfoDao;

	
	public UserinfoDao getUserinfoDao() {
		return userinfoDao;
	}
	public void setUserinfoDao(UserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}
	public boolean addUser(Userinfo user){
		return userinfoDao.addUser(user);
	}//添加一个user
	public boolean updateUser(Userinfo user){
		return userinfoDao.updateUser(user);
	}//更新一个user
	public Userinfo searchUser(String userName){
		return userinfoDao.searchUser(userName);
	}//验证登陆，返回查找对象，如果没有找到就返回空
	
	public boolean addAddress(Addressinfo address){
		return userinfoDao.addAddress(address);
	}  //添加地址信息
	public boolean updateAddress(Addressinfo address){
		return userinfoDao.updateAddress(address);
	} //更新地址信息
	public boolean deleteAddress(Addressinfo address){
		return userinfoDao.deleteAddress(address);
	} //删除地址信息
	
	public List<Addressinfo> searchAddress(Long userid){
		return userinfoDao.searchAddress(userid);
	} //根据用户ID查询地址信息
	public List<Docinfo> searchDocs(Long userId){
		return userinfoDao.searchDocs(userId);
	}//根据userId获取其上传的所有文档
	public List<Orderinfo> getOrders(Long userId){
		return userinfoDao.getOrders(userId);
	}//根据userId获取其所有订单信息
	public boolean checkEmail(String email){
		return userinfoDao.checkEmail(email);
	}//check the user's email used or not;return true is used,false is not used

}
