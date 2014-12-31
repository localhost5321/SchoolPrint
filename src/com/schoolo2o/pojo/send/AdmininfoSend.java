package com.schoolo2o.pojo.send;

import com.schoolo2o.pojo.Admininfo;

/**
 * Admininfo entity. @author MyEclipse Persistence Tools
 */

public class AdmininfoSend implements java.io.Serializable {

	// Fields

	private Long adminId;
	private String adminName;
	private String adminPwd;

	// Constructors

	/** default constructor */
	public AdmininfoSend(Admininfo admin){
		this.adminId=admin.getAdminId();
		this.adminName=admin.getAdminName();
		this.adminPwd=admin.getAdminPwd();
	}

	

}