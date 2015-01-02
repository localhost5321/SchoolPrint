package com.schoolo2o.pojo.send;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.schoolo2o.pojo.Orderinfo;

/**
 * Orderinfo entity. @author MyEclipse Persistence Tools
 */

public class OrderinfoSend implements java.io.Serializable {

	// Fields

	private Long orderId;
	private String shopName;
	private String  userName;
	private Long addressId;
	private Double totalCost;
	private Integer payType;
	private Integer sendType;
	private List <OrderitemSend> items;
	private OrderstatusSend status;;

	// Constructors
	public OrderinfoSend(){
	}

	/** default constructor */
	public OrderinfoSend(Orderinfo order) {
		this.orderId=order.getOrderId();
		this.shopName=order.getShopinfo().getShopName();
		this.userName=order.getUserinfo().getUserName();
		this.addressId=order.getAddressId();
		this.totalCost=order.getTotalCost();
		this.payType=order.getPayType();
		this.sendType=order.getSendType();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public List<OrderitemSend> getItems() {
		return items;
	}

	public void setItems(List<OrderitemSend> items) {
		this.items = items;
	}

	public OrderstatusSend getStatus() {
		return status;
	}

	public void setStatus(OrderstatusSend status) {
		this.status = status;
	}


}