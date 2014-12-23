package com.schoolo2o.pojo;

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */

public class Orderitem implements java.io.Serializable {

	// Fields

	private Long itemId;
	private Orderinfo orderinfo;
	private String fileName;
	private Integer fileCount;
	private Integer pageNumber;
	private Double filePrice;
	private String printRequire;

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** minimal constructor */
	public Orderitem(Orderinfo orderinfo, String fileName, Integer fileCount,
			Integer pageNumber, Double filePrice) {
		this.orderinfo = orderinfo;
		this.fileName = fileName;
		this.fileCount = fileCount;
		this.pageNumber = pageNumber;
		this.filePrice = filePrice;
	}

	/** full constructor */
	public Orderitem(Orderinfo orderinfo, String fileName, Integer fileCount,
			Integer pageNumber, Double filePrice, String printRequire) {
		this.orderinfo = orderinfo;
		this.fileName = fileName;
		this.fileCount = fileCount;
		this.pageNumber = pageNumber;
		this.filePrice = filePrice;
		this.printRequire = printRequire;
	}

	// Property accessors

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Orderinfo getOrderinfo() {
		return this.orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getFileCount() {
		return this.fileCount;
	}

	public void setFileCount(Integer fileCount) {
		this.fileCount = fileCount;
	}

	public Integer getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Double getFilePrice() {
		return this.filePrice;
	}

	public void setFilePrice(Double filePrice) {
		this.filePrice = filePrice;
	}

	public String getPrintRequire() {
		return this.printRequire;
	}

	public void setPrintRequire(String printRequire) {
		this.printRequire = printRequire;
	}

}