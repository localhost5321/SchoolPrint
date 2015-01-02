package com.schoolo2o.service;

import java.util.List;

import com.schoolo2o.pojo.Addressinfo;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Userinfo;
/**
 * 用户服务层的一些接口
 */

public interface UserService {
	/**
	 * 添加一个用户
	 * @param user　UserInfo的对象
	 * @return　添加成功，则为true,否则为False
	 */
	public boolean addUser(Userinfo user);
	/**
	 * 用户信息更新
	 * @param user　Userinfo的对象
	 * @return　更新成功，为true,否则为false
	 */
	public boolean updateUser(Userinfo user);
	/**
	 * 用户登陆验证和验证用户名是否已经使用过
	 * @param userName　用户名
	 * @return　一个Userinfo 的对象
	 */
	public Userinfo searchUser(String userName);
	/**
	 * 检查用户的eamil是否已经使用刚，若使用过，则返回false;
	 * @param email 用户注册的email
	 * @return 已经注册过，返回false, 否则,.返回true
	 */
	public boolean checkEmail(String email);
	/**
	 * 添加一条地址信息
	 * @param userName 用户名
	 * @param contactor 联系人
	 * @param sendAddress 送货地址
	 * @param callPhone 联系电话
	 * @param secPhone 备用电话
	 * @param isDefault 是否为默认
	 * @return
	 */
	public boolean addAddress(String userName, String contactor, String sendAddress,
			String callPhone, String secPhone,Integer isDefault);
	/**
	 * 更新用户地址信息
	 * @param address　需要一个Addressinfo的对象，且addressId不能为空
	 * @return
	 */
	public boolean updateAddress(Addressinfo address);
	/**
	 * 删除用户地址信息
	 * @param address　　需要一个Addressinfo的对象，且AddressId不能为空
	 * @return　删除成功，为true,否则为false
	 */
	public boolean deleteAddress(Addressinfo address); 
	/**
	 *  //根据用户ID查询地址信息
	 * @param userid 需要一个用户ID
	 * @return 返回一个Addressinfo的List 对象
	 */
	public List<Addressinfo> searchAddress(Long userid); 
	/**
	 * 根据userId获取其上传的所有文档
	 * @param userId
	 * @return 返回一个Docinfo的List 对象
	 */
	public List<Docinfo> searchDocs(Long userId);
	/**
	 * 根据userId获取其所有订单信息
	 * @param userId 
	 * @return 返回一个Orderinfo的List 对象
	 */
	public List<Orderinfo> getOrders(Long userId);
	
}
