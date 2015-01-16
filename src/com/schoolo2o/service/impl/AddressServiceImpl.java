package com.schoolo2o.service.impl;

import java.util.List;

import com.schoolo2o.dao.AddressDao;
import com.schoolo2o.pojo.Addressinfo;
import com.schoolo2o.service.AddressService;

public class AddressServiceImpl implements AddressService {
	private AddressDao addressDao;
	
	

	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public boolean addOrUpdateAddress(Addressinfo address) {
		return addressDao.addOrUpdateAddress(address);
	}

	@Override
	public boolean deleteAddress(long addId) {
		return addressDao.deleteAddress(addId);
	}

	@Override
	public List<Addressinfo> getAddresses(long userId) {
		return addressDao.getAddresses(userId);
	}

}
