package com.schoolo2o.pojo.send;

import java.sql.Timestamp;

import com.schoolo2o.pojo.Orderstatus;

/**
 * Orderstatus entity. @author MyEclipse Persistence Tools
 */

public class OrderstatusSend implements java.io.Serializable {

	// Fields

	private Long orderStatusId;
	private Long orderId ;
	private Integer status;
	private Timestamp changeTime;
	private Integer isCurrent;

	// Constructors

	/** default constructor */
	public OrderstatusSend(Orderstatus os) {
		this.orderId = os.getOrderinfo().getOrderId();
		this.status = os.getStatus();
		this.changeTime = os.getChangeTime();
		this.isCurrent = os.getIsCurrent();
		this.orderStatusId=os.getOrderStatusId();
	}



}