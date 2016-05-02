package com.schoolo2o.pojo.send;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.schoolo2o.pojo.Userinfo;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class UserinfoSend implements java.io.Serializable {

	// Fields

	private Long userId;
	private String userName;
	private String userPwd;
	private String email;
	private Timestamp regTime;
	private String userPhone;
	private Integer emailChecked;
	
	// Constructors

	/** default constructor */
	public UserinfoSend(Userinfo user) {
			this.userId=user.getUserId();
			this.userName = user.getUserName();
			this.userPwd = user.getUserPwd();
			this.email = user.getEmail();
			this.regTime = user.getRegTime();
			this.userPhone = user.getUserPhone();
			this.emailChecked = user.getEmailChecked();
	}



}