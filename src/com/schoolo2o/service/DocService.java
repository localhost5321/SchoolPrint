package com.schoolo2o.service;

import java.util.List;

import com.schoolo2o.pojo.Docinfo;

public interface DocService {
	
	public boolean add(Docinfo doc);     //添加文档*,如果添加成功则返回true;否则返回false
	public boolean delete(Long id);  /*根据文档ID删除文档,如果删除成功则返回true;否则返回false*/
	public boolean update(Docinfo doc);  /*修改文档信息，如果修改成功则返回true;否则返回false**/
	public List<Docinfo> search(Long userId);  /*根据用户ID来查询文档，如果查询成功则返回一个文档列表;否则返回null*/
}
