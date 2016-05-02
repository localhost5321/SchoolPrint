package com.schoolo2o.pojo.send;

import com.schoolo2o.pojo.Orderitem;

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */

public class OrderitemSend implements java.io.Serializable {

	// Fields

	private Long itemId;
	private Long  modelfileId;
	private Long docId;
	private Integer fileCount;
	private Integer pageNumber;
	private Double filePrice;
	private String printRequire;

	// Constructors

	/** default constructor */
	public OrderitemSend(Orderitem item) {
		this.itemId=item.getItemId();
		this.docId = item.getDocId();
		this.fileCount = item.getFileCount();
		this.pageNumber =item.getPageNumber();
		this.filePrice = item.getFilePrice();
		this.printRequire = item.getPrintRequire();
		this.modelfileId=item.getModelfile().getModelFileId();
	}


}