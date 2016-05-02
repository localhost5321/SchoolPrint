package com.schoolo2o.pojo;

/**
 * Priceinfo entity. @author MyEclipse Persistence Tools
 */

public class Priceinfo implements java.io.Serializable {

	// Fields

	private Long priceId;
	private Shopinfo shopinfo;
	private String printType;
	private Double price;

	// Constructors

	/** default constructor */
	public Priceinfo() {
	}

	/** full constructor */
	public Priceinfo(Shopinfo shopinfo, String printType, Double price) {
		this.shopinfo = shopinfo;
		this.printType = printType;
		this.price = price;
	}

	// Property accessors

	public Long getPriceId() {
		return this.priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public Shopinfo getShopinfo() {
		return this.shopinfo;
	}

	public void setShopinfo(Shopinfo shopinfo) {
		this.shopinfo = shopinfo;
	}

	public String getPrintType() {
		return this.printType;
	}

	public void setPrintType(String printType) {
		this.printType = printType;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}