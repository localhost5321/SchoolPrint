package com.schoolo2o.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Orderinfo entity. @author MyEclipse Persistence Tools
 */

public class Orderinfo implements java.io.Serializable {

	// Fields

	private Long orderId;
	private Shopinfo shopinfo;
	private Userinfo userinfo;
	private Long addressId;
	private Double totalCost;
	private Integer payType;//支付方式，1代表在线支付，2代表货到付款
	private Integer sendType;//送货方式，1代表配送到家，2代表上门自取
	private Set orderitems = new HashSet(0);
	private Set orderstatuses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orderinfo() {
	}

	/** minimal constructor */
	public Orderinfo(Shopinfo shopinfo, Userinfo userinfo, Long addressId,
			Double totalCost, Integer payType, Integer sendType) {
		this.shopinfo = shopinfo;
		this.userinfo = userinfo;
		this.addressId = addressId;
		this.totalCost = totalCost;
		this.payType = payType;
		this.sendType = sendType;
	}

	/** full constructor */
	public Orderinfo(Shopinfo shopinfo, Userinfo userinfo, Long addressId,
			Double totalCost, Integer payType, Integer sendType,
			Set orderitems, Set orderstatuses) {
		this.shopinfo = shopinfo;
		this.userinfo = userinfo;
		this.addressId = addressId;
		this.totalCost = totalCost;
		this.payType = payType;
		this.sendType = sendType;
		this.orderitems = orderitems;
		this.orderstatuses = orderstatuses;
	}

	// Property accessors

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Shopinfo getShopinfo() {
		return this.shopinfo;
	}

	public void setShopinfo(Shopinfo shopinfo) {
		this.shopinfo = shopinfo;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Double getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getPayType() {
		return this.payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getSendType() {
		return this.sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

	public Set getOrderstatuses() {
		return this.orderstatuses;
	}

	public void setOrderstatuses(Set orderstatuses) {
		this.orderstatuses = orderstatuses;
	}

}