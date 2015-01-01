package com.schoolo2o.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Shopinfo entity. @author MyEclipse Persistence Tools
 */

public class Shopinfo implements java.io.Serializable {

	// Fields

	private Long shopId;
	private String shopName;
	private String shopPwd;
	private String shopNick;
	private String shopPhone;
	private String shopAddress;
	private String shopPic;
	private String shopDesc;
	private Double delivery;
	private Set orderinfos = new HashSet(0);
	private Set priceinfos = new HashSet(0);
	private Set shopComments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shopinfo() {
	}

	/** minimal constructor */
	public Shopinfo(String shopName, String shopPwd, String shopNick,
			String shopPhone, String shopAddress, Double delivery) {
		this.shopName = shopName;
		this.shopPwd = shopPwd;
		this.shopNick = shopNick;
		this.shopPhone = shopPhone;
		this.shopAddress = shopAddress;
		this.delivery = delivery;
	}

	/** full constructor */
	public Shopinfo(String shopName, String shopPwd, String shopNick,
			String shopPhone, String shopAddress, String shopPic,
			String shopDesc, Double delivery, Set orderinfos, Set priceinfos,
			Set shopComments) {
		this.shopName = shopName;
		this.shopPwd = shopPwd;
		this.shopNick = shopNick;
		this.shopPhone = shopPhone;
		this.shopAddress = shopAddress;
		this.shopPic = shopPic;
		this.shopDesc = shopDesc;
		this.delivery = delivery;
		this.orderinfos = orderinfos;
		this.priceinfos = priceinfos;
		this.shopComments = shopComments;
	}

	// Property accessors

	public Long getShopId() {
		return this.shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopPwd() {
		return this.shopPwd;
	}

	public void setShopPwd(String shopPwd) {
		this.shopPwd = shopPwd;
	}

	public String getShopNick() {
		return this.shopNick;
	}

	public void setShopNick(String shopNick) {
		this.shopNick = shopNick;
	}

	public String getShopPhone() {
		return this.shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	public String getShopAddress() {
		return this.shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopPic() {
		return this.shopPic;
	}

	public void setShopPic(String shopPic) {
		this.shopPic = shopPic;
	}

	public String getShopDesc() {
		return this.shopDesc;
	}

	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}

	public Double getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Double delivery) {
		this.delivery = delivery;
	}

	public Set getOrderinfos() {
		System.out.println("come in");
		return this.orderinfos;
	}

	public void setOrderinfos(Set orderinfos) {
		this.orderinfos = orderinfos;
	}

	public Set getPriceinfos() {
		return this.priceinfos;
	}

	public void setPriceinfos(Set priceinfos) {
		this.priceinfos = priceinfos;
	}

	public Set getShopComments() {
		return this.shopComments;
	}

	public void setShopComments(Set shopComments) {
		this.shopComments = shopComments;
	}

}