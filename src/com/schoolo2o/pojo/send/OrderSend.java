package com.schoolo2o.pojo.send;

public class OrderSend {
	String userName;
	String shopName;
	Long[] docId;
	Integer[] pageCount;
	Double[] price;
	Integer[] fileCount;
	String[] printRequire;
	Long addressId;
	Integer payType;
	Integer sendType;
	double[] itemPrice;
	double total;
	public OrderSend(String userName, String shopName, Long[] docId,
			Integer[] pageCount, Double[] price, Integer[] fileCount,
			String[] printRequire, Long addressId, Integer payType,
			Integer sendType, double[] itemPrice, double total) {
		super();
		this.userName = userName;
		this.shopName = shopName;
		this.docId = docId;
		this.pageCount = pageCount;
		this.price = price;
		this.fileCount = fileCount;
		this.printRequire = printRequire;
		this.addressId = addressId;
		this.payType = payType;
		this.sendType = sendType;
		this.itemPrice = itemPrice;
		this.total = total;
	}
	public double[] getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double[] itemPrice) {
		this.itemPrice = itemPrice;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public OrderSend(){
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long[] getDocId() {
		return docId;
	}

	public void setDocId(Long[] docId) {
		this.docId = docId;
	}

	public Integer[] getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer[] pageCount) {
		this.pageCount = pageCount;
	}

	public Double[] getPrice() {
		return price;
	}

	public void setPrice(Double[] price) {
		this.price = price;
	}

	public Integer[] getFileCount() {
		return fileCount;
	}

	public void setFileCount(Integer[] fileCount) {
		this.fileCount = fileCount;
	}

	public String[] getPrintRequire() {
		return printRequire;
	}

	public void setPrintRequire(String[] printRequire) {
		this.printRequire = printRequire;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}
	
	
}
