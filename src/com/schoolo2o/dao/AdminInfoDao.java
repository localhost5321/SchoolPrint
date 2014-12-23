package com.schoolo2o.dao;

import java.util.List;

import com.schoolo2o.pojo.Admininfo;
/**
 * 管理员信息表的操作
 * @author hua
 *
 */

public interface AdminInfoDao {
	//test
	public  boolean add(Admininfo admin);        /*增添管理员*/
	public boolean update(Admininfo admin);      /*更新管理员信息*/
	public boolean delete(String adminName);      /*根据管理员的登录名删除管理员*/
	public List<Admininfo> search(Admininfo admin); /*查询是否有这个管理员*/
}
