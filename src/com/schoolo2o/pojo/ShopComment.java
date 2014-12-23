package com.schoolo2o.pojo;

import java.util.Date;

/**
 * ShopComment entity. @author MyEclipse Persistence Tools
 */

public class ShopComment implements java.io.Serializable {

	// Fields

	private Long commentId;
	private Shopinfo shopinfo;
	private String commentUser;
	private String commentContent;
	private Date commentDate;
	private Integer shopScore;
	private String shopReply;

	// Constructors

	/** default constructor */
	public ShopComment() {
	}

	/** minimal constructor */
	public ShopComment(Shopinfo shopinfo, String commentUser,
			String commentContent, Date commentDate, Integer shopScore) {
		this.shopinfo = shopinfo;
		this.commentUser = commentUser;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.shopScore = shopScore;
	}

	/** full constructor */
	public ShopComment(Shopinfo shopinfo, String commentUser,
			String commentContent, Date commentDate, Integer shopScore,
			String shopReply) {
		this.shopinfo = shopinfo;
		this.commentUser = commentUser;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.shopScore = shopScore;
		this.shopReply = shopReply;
	}

	// Property accessors

	public Long getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Shopinfo getShopinfo() {
		return this.shopinfo;
	}

	public void setShopinfo(Shopinfo shopinfo) {
		this.shopinfo = shopinfo;
	}

	public String getCommentUser() {
		return this.commentUser;
	}

	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Integer getShopScore() {
		return this.shopScore;
	}

	public void setShopScore(Integer shopScore) {
		this.shopScore = shopScore;
	}

	public String getShopReply() {
		return this.shopReply;
	}

	public void setShopReply(String shopReply) {
		this.shopReply = shopReply;
	}

}