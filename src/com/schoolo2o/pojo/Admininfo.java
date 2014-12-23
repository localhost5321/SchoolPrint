package com.schoolo2o.pojo;

/**
 * Admininfo entity. @author MyEclipse Persistence Tools
 */

public class Admininfo implements java.io.Serializable {

	// Fields

	private Long adminId;
	private String adminName;
	private String adminPwd;

	// Constructors

	/** default constructor */
	public Admininfo() {
	}

	/** full constructor */
	public Admininfo(String adminName, String adminPwd) {
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}

	// Property accessors

	public Long getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return this.adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

}