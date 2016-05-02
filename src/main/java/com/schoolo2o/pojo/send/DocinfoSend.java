package com.schoolo2o.pojo.send;

import com.schoolo2o.pojo.Docinfo;

/**
 * Docinfo entity. @author MyEclipse Persistence Tools
 */

public class DocinfoSend implements java.io.Serializable {

	// Fields

	private Long docId;
	private String userName;
	private String fileName;
	private String filePath;
	private Integer isShare;
	private Long downNum;
	private Long browseNum;

	// Constructors

	/** default constructor */
	public DocinfoSend(Docinfo di) {
		this.docId=di.getDocId();
		this.userName = di.getUserinfo().getUserName();
		this.fileName = di.getFileName();
		this.filePath =di.getFilePath();
		this.isShare = di.getIsShare();
		this.downNum = di.getDownNum();
		this.browseNum = di.getBrowseNum();
	}

	

}