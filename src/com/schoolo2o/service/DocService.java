package com.schoolo2o.service;

import java.util.List;

import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Userinfo;

public interface DocService {
	
	/**
	 * 文档保存的接口，文档信息保存到数据库里面，同时文档保存到相对应的路径下面，并对文档进行重命名
	 * @param doc　获取文档
	 * @param user　当前操作用户
	 * @return
	 */
	public boolean add(Docinfo doc, Userinfo user);
	
	/**
	 * 根据用户ＩＤ删除用户所上传的文档
	 * @param id　用户ＩＤ
	 * @return 如果删除成功则返回true;否则返回false
	 */
	public boolean delete(Long id); 
	
	/**
	 * 修改文档信息
	 * @param doc
	 * @return 如果修改成功则返回true;否则返回false
	 */
	public boolean update(Docinfo doc); 
	/**
	 * 根据用户ＩＤ获取用户所有上传的文档信息
	 * @param userId　用户ＩＤ
	 * @return　如果查询成功则返回一个文档列表;否则返回null
	 */
	public List<Docinfo> search(Long userId); 
}
