package com.schoolo2o.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Long userId;
	private String userName;
	private String userPwd;
	private String email;
	private Date regTime;
	private Set addressinfos = new HashSet(0);
	private Set orderinfos = new HashSet(0);
	private Set docinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String userName, String userPwd, String email, Date regTime) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
		this.regTime = regTime;
	}

	/** full constructor */
	public Userinfo(String userName, String userPwd, String email,
			Date regTime, Set addressinfos, Set orderinfos, Set docinfos) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
		this.regTime = regTime;
		this.addressinfos = addressinfos;
		this.orderinfos = orderinfos;
		this.docinfos = docinfos;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Set getAddressinfos() {
		return this.addressinfos;
	}

	public void setAddressinfos(Set addressinfos) {
		this.addressinfos = addressinfos;
	}

	public Set getOrderinfos() {
		return this.orderinfos;
	}

	public void setOrderinfos(Set orderinfos) {
		this.orderinfos = orderinfos;
	}

	public Set getDocinfos() {
		return this.docinfos;
	}

	public void setDocinfos(Set docinfos) {
		this.docinfos = docinfos;
	}

	@Override
	public String toString() {
		return "Userinfo [userId=" + userId + ", userName=" + userName
				+ ", userPwd=" + userPwd + ", email=" + email + ", regTime="
				+ regTime + ", addressinfos=" + addressinfos + ", orderinfos="
				+ orderinfos + ", docinfos=" + docinfos + "]";
	}
	
}