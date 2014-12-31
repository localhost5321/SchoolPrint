package com.schoolo2o.pojo.send;


import java.util.List;

import com.schoolo2o.pojo.ShopComment;
import com.schoolo2o.pojo.Shopinfo;

/**
 * Shopinfo entity. @author MyEclipse Persistence Tools
 */

public class ShopinfoSend{

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
	private List<ShopCommentSend> comments;
	private List<OrderinfoSend> orders;
	
	

	
	// Constructors

	public List<ShopCommentSend> getComments() {
		return comments;
	}

	public void setComments(List<ShopCommentSend> comments) {
		this.comments = comments;
	}

	/** default constructor */
	public ShopinfoSend(Shopinfo sf) {
		this.shopId=sf.getShopId();
		this.shopName =sf.getShopName(); 
		this.shopPwd = sf.getShopPwd();
		this.shopNick = sf.getShopNick();
		this.shopPhone = sf.getShopPhone();
		this.shopAddress = sf.getShopAddress();
		this.delivery = sf.getDelivery();
		this.shopDesc=sf.getShopDesc();
		this.shopPic=sf.getShopPic();
	}

	public void setSelf(Shopinfo sf) {
		this.shopId=sf.getShopId();
		this.shopName =sf.getShopName(); 
		this.shopPwd = sf.getShopPwd();
		this.shopNick = sf.getShopNick();
		this.shopPhone = sf.getShopPhone();
		this.shopAddress = sf.getShopAddress();
		this.delivery = sf.getDelivery();
		this.shopDesc=sf.getShopDesc();
		this.shopPic=sf.getShopPic();
	}

	public Long getShopId() {
		return shopId;
	}


	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}


	public String getShopName() {
		return shopName;
	}


	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public String getShopPwd() {
		return shopPwd;
	}


	public void setShopPwd(String shopPwd) {
		this.shopPwd = shopPwd;
	}


	public String getShopNick() {
		return shopNick;
	}


	public void setShopNick(String shopNick) {
		this.shopNick = shopNick;
	}


	public String getShopPhone() {
		return shopPhone;
	}


	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}


	public String getShopAddress() {
		return shopAddress;
	}


	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}


	public String getShopPic() {
		return shopPic;
	}


	public void setShopPic(String shopPic) {
		this.shopPic = shopPic;
	}


	public String getShopDesc() {
		return shopDesc;
	}


	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}


	public Double getDelivery() {
		return delivery;
	}


	public void setDelivery(Double delivery) {
		this.delivery = delivery;
	}



}