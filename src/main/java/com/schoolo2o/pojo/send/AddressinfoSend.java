package com.schoolo2o.pojo.send;

import com.schoolo2o.pojo.Addressinfo;

/**
 * Addressinfo entity. @author MyEclipse Persistence Tools
 */

public class AddressinfoSend implements java.io.Serializable {

	// Fields

	private String userName;
	private Long addressId;
	private String contactor;
	private String sendAddress;
	private String callPhone;
	private String secPhone;
	private Integer isDefault;

	// Constructors

	/** default constructor */
	public AddressinfoSend(Addressinfo address) {
		this.addressId=address.getAddressId();
		this.contactor = address.getContactor();
		this.sendAddress = address.getSendAddress();
		this.callPhone = address.getCallPhone();
		this.secPhone = address.getSecPhone();
		this.isDefault = address.getIsDefault();
		this.userName=address.getUserinfo().getUserName();
	}


}