package com.schoolo2o.pojo;

/**
 * Addressinfo entity. @author MyEclipse Persistence Tools
 */

public class Addressinfo implements java.io.Serializable {

	// Fields

	private Long addressId;
	private Userinfo userinfo;
	private String contactor;
	private String sendAddress;
	private String callPhone;
	private String secPhone;
	private Integer isDefault;

	// Constructors

	/** default constructor */
	public Addressinfo() {
	}

	/** minimal constructor */
	public Addressinfo(Userinfo userinfo, String contactor, String sendAddress,
			String callPhone, Integer isDefault) {
		this.userinfo = userinfo;
		this.contactor = contactor;
		this.sendAddress = sendAddress;
		this.callPhone = callPhone;
		this.isDefault = isDefault;
	}

	/** full constructor */
	public Addressinfo(Userinfo userinfo, String contactor, String sendAddress,
			String callPhone, String secPhone, Integer isDefault) {
		this.userinfo = userinfo;
		this.contactor = contactor;
		this.sendAddress = sendAddress;
		this.callPhone = callPhone;
		this.secPhone = secPhone;
		this.isDefault = isDefault;
	}

	// Property accessors

	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getContactor() {
		return this.contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public String getSendAddress() {
		return this.sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getCallPhone() {
		return this.callPhone;
	}

	public void setCallPhone(String callPhone) {
		this.callPhone = callPhone;
	}

	public String getSecPhone() {
		return this.secPhone;
	}

	public void setSecPhone(String secPhone) {
		this.secPhone = secPhone;
	}

	public Integer getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

}