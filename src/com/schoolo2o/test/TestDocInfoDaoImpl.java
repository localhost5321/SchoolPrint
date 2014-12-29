package com.schoolo2o.test;

import java.math.BigInteger;
import java.util.List;

import com.schoolo2o.dao.DocInfoDao;
import com.schoolo2o.pojo.Docinfo;

public class TestDocInfoDaoImpl {
	DocInfoDao docInfoDao;
	public DocInfoDao getDocInfoDao() {
		return docInfoDao;
	}
	public void setDocInfoDao(DocInfoDao docInfoDao) {
		this.docInfoDao = docInfoDao;
	}
	public Docinfo addTest(Docinfo doc){
		return docInfoDao.add(doc);
	}     /*添加文档*/
	public boolean deleteTest(Long id){
		return docInfoDao.delete(id);
	} /*根据文档ID删除文档*/
	public boolean updateTest(Docinfo doc){
		return docInfoDao.update(doc);
	} /*修改文档信息*/
	public List<Docinfo> searchTest(Long userId){
		return docInfoDao.search(userId);
	}/*根据用户ID来查询文档*/
}
