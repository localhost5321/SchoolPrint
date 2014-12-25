package com.schoolo2o.dao;
/*
 * 用户信息的操作
 *@author 赵龙
 */
import java.util.List;

import com.schoolo2o.pojo.Addressinfo;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Userinfo;

public interface UserinfoDao {
	public boolean addUser(Userinfo user);//添加一个user
	public boolean updateUser(Userinfo user);//更新一个user
	public Userinfo searchUser(String userName);//验证登陆，返回查找对象，如果没有找到就返回空
	
	public boolean checkEmail(String email);//check the user's email used or not;return true is used,false is not used
	public boolean addAddress(Addressinfo address);  //添加地址信息
	public boolean updateAddress(Addressinfo address); //更新地址信息
	public boolean deleteAddress(Addressinfo address); //删除地址信息
	
	public List<Addressinfo> searchAddress(Long userid); //根据用户ID查询地址信息
	public List<Docinfo> searchDocs(Long userId);//根据userId获取其上传的所有文档
	public List<Orderinfo> getOrders(Long userId);//根据userId获取其所有订单信息
}
