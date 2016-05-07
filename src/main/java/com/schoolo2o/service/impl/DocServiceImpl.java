package com.schoolo2o.service.impl;

import java.math.BigInteger;
import java.util.List;

import com.schoolo2o.dao.DocInfoDao;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.service.DocService;

public class DocServiceImpl implements DocService{
	DocInfoDao docInfoDao;
	public DocInfoDao getDocInfoDao() {
		return docInfoDao;
	}

	public void setDocInfoDao(DocInfoDao docInfoDao) {
		this.docInfoDao = docInfoDao;
	}

	public Docinfo add(Docinfo doc, Userinfo user) {
		doc.setUserinfo(user);
		return docInfoDao.add(doc);
	}

	public boolean update(Docinfo doc) {
		return docInfoDao.update(doc);
	}

	public List<Docinfo> search(Long userId) {
		return docInfoDao.search(userId);
	}

	public boolean delete(Long id) {
		return docInfoDao.delete(id);
	}


}
