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

	public boolean addOrUpdateAddress(Addressinfo address) {
		return addressDao.addOrUpdateAddress(address);
	}

	public boolean deleteAddress(long addId) {
		return addressDao.deleteAddress(addId);
	}

	public List<Addressinfo> getAddresses(long userId) {
		return addressDao.getAddresses(userId);
	}

	public boolean changeTypes(long oldId, long newId) {

		try {
			if (oldId == -1) {
				Addressinfo newDeAddress = addressDao.getAddressById(newId);
				if (newDeAddress != null) {
					newDeAddress.setIsDefault(1);
					return addressDao.addOrUpdateAddress(newDeAddress);
				} else {
					return false;
				}
			}
			Addressinfo newDeAddress = addressDao.getAddressById(newId);
			Addressinfo oldDeAddress = addressDao.getAddressById(oldId);
			if (newDeAddress != null && oldDeAddress != null) {
				newDeAddress.setIsDefault(1);
				oldDeAddress.setIsDefault(0);
				return addressDao.addOrUpdateAddress(oldDeAddress)
						&& addressDao.addOrUpdateAddress(newDeAddress);
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
