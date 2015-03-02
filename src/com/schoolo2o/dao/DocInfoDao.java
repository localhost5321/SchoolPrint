package com.schoolo2o.dao;

import java.math.BigInteger;
import java.util.List;

import com.schoolo2o.pojo.Docinfo;

public interface DocInfoDao {
	
	public Docinfo add(Docinfo doc);     /*添加文档*/
	public boolean delete(Long id);  /*根据文档ID删除文档*/
	public boolean update(Docinfo doc);  /*修改文档信息*/
	public List<Docinfo> search(Long userId);  /*根据用户ID来查询文档*/
	
	/**
	 * 根据文档ID来查询一个文档
	 * @param docId 文档ID
	 * @return
	 */
	public Docinfo searchDoc(Long docId);
}
