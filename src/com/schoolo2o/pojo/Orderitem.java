package com.schoolo2o.pojo;

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */

public class Orderitem implements java.io.Serializable {

	// Fields

	private Long itemId;
	private Modelfile modelfile;
	private Orderinfo orderinfo;
	private Long docId;
	private Integer fileCount;
	private Integer pageNumber;
	private Double filePrice;
	private String printRequire;

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** minimal constructor */
	public Orderitem(Orderinfo orderinfo, Long docId, Integer fileCount,
			Integer pageNumber, Double filePrice, String printRequire) {
		this.orderinfo = orderinfo;
		this.docId = docId;
		this.fileCount = fileCount;
		this.pageNumber = pageNumber;
		this.filePrice = filePrice;
		this.printRequire = printRequire;
	}

	/** full constructor */
	public Orderitem(Modelfile modelfile, Orderinfo orderinfo, Long docId,
			Integer fileCount, Integer pageNumber, Double filePrice,
			String printRequire) {
		this.modelfile = modelfile;
		this.orderinfo = orderinfo;
		this.docId = docId;
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

	public Modelfile getModelfile() {
		return this.modelfile;
	}

	public void setModelfile(Modelfile modelfile) {
		this.modelfile = modelfile;
	}

	public Orderinfo getOrderinfo() {
		return this.orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public Long getDocId() {
		return this.docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
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