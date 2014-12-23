package com.schoolo2o.pojo;

/**
 * Docinfo entity. @author MyEclipse Persistence Tools
 */

public class Docinfo implements java.io.Serializable {

	// Fields

	private Long docId;
	private Userinfo userinfo;
	private String fileName;
	private String filePath;
	private Integer isShare;
	private Long downNum;
	private Long browseNum;

	// Constructors

	/** default constructor */
	public Docinfo() {
	}

	/** full constructor */
	public Docinfo(Userinfo userinfo, String fileName, String filePath,
			Integer isShare, Long downNum, Long browseNum) {
		this.userinfo = userinfo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.isShare = isShare;
		this.downNum = downNum;
		this.browseNum = browseNum;
	}

	// Property accessors

	public Long getDocId() {
		return this.docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getIsShare() {
		return this.isShare;
	}

	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}

	public Long getDownNum() {
		return this.downNum;
	}

	public void setDownNum(Long downNum) {
		this.downNum = downNum;
	}

	public Long getBrowseNum() {
		return this.browseNum;
	}

	public void setBrowseNum(Long browseNum) {
		this.browseNum = browseNum;
	}

}