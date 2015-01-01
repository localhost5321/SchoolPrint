package com.schoolo2o.pojo.send;

import com.schoolo2o.pojo.Priceinfo;

/**
 * Priceinfo entity. @author MyEclipse Persistence Tools
 */

public class PriceinfoSend implements java.io.Serializable {

	// Fields

	private Long priceId;
	private String shopName;
	private String printType;
	private Double price;

	// Constructors

	/** default constructor */
	public PriceinfoSend(Priceinfo priceInfo) {
		this.priceId=priceInfo.getPriceId();
		this.printType = priceInfo.getPrintType();
		this.price = priceInfo.getPrice();
		this.shopName=priceInfo.getShopinfo().getShopName();
	}


}