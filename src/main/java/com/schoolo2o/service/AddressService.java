package com.schoolo2o.service;

import java.util.List;

import com.schoolo2o.pojo.Addressinfo;

public interface AddressService {
	/**
	 * 增加或者修改一条地址信息
	 * @return
	 */
	public boolean addOrUpdateAddress(Addressinfo address );
	/**
	 * 删除一个地址信息
	 * @param address
	 * @return
	 */
	public boolean deleteAddress(long id);
	
	/**
	 * 获得一个地址列表
	 * @param userId
	 * @return
	 */
	public List<Addressinfo> getAddresses(long userId);
	
	
	//修改默认地址
	public boolean changeTypes(long oldId,long newId);
	
	
	

}
