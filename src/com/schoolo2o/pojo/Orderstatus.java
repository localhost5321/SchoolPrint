package com.schoolo2o.pojo;

import java.sql.Timestamp;

/**
 * Orderstatus entity. @author MyEclipse Persistence Tools
 */

public class Orderstatus implements java.io.Serializable {

	// Fields

	private Long orderStatusId;
	private Orderinfo orderinfo;
	private Integer status;
	private Timestamp changeTime;
	private Integer isCurrent;

	// Constructors

	/** default constructor */
	public Orderstatus() {
	}

	/** full constructor */
	public Orderstatus(Orderinfo orderinfo, Integer status,
			Timestamp changeTime, Integer isCurrent) {
		this.orderinfo = orderinfo;
		this.status = status;
		this.changeTime = changeTime;
		this.isCurrent = isCurrent;
	}

	// Property accessors

	public Long getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(Long orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public Orderinfo getOrderinfo() {
		return this.orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Timestamp changeTime) {
		this.changeTime = changeTime;
	}

	public Integer getIsCurrent() {
		return this.isCurrent;
	}

	public void setIsCurrent(Integer isCurrent) {
		this.isCurrent = isCurrent;
	}

}