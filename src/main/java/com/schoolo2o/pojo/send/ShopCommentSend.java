package com.schoolo2o.pojo.send;

import java.sql.Timestamp;

import com.schoolo2o.pojo.ShopComment;

/**
 * ShopComment entity. @author MyEclipse Persistence Tools
 */

public class ShopCommentSend{

	// Fields

	private Long commentId;
	private String commentUser;
	private String commentContent;
	private Timestamp commentDate;
	private Integer shopScore;
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public Integer getShopScore() {
		return shopScore;
	}

	public void setShopScore(Integer shopScore) {
		this.shopScore = shopScore;
	}

	public String getShopReply() {
		return shopReply;
	}

	public void setShopReply(String shopReply) {
		this.shopReply = shopReply;
	}

	private String shopReply;

	// Constructors

	/** default constructor */
	public ShopCommentSend(ShopComment sc) {
		this.commentId=sc.getCommentId();
		this.commentUser = sc.getCommentUser();
		this.commentContent = sc.getCommentContent();
		this.commentDate = sc.getCommentDate();
		this.shopScore = sc.getShopScore();
	}

	

}