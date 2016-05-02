package com.schoolo2o.pojo.send;

public class OrderSend {
	String userName;
	String shopName;
	Long[] docId;
	Integer[] pageCount;
	double[] price;
	Integer[] fileCount;
	String[] printRequire;
	String[] fileName;
	Long addressId;
	Integer payType;
	Integer sendType;
	double[] itemPrice;   /*每一项的价格*/
	double total;         /*总价*/
	
	
	public OrderSend(String userName, String shopName, Long[] docId,
			Integer[] pageCount, double[] price, Integer[] fileCount,
			String[] printRequire, Long addressId, Integer payType,
			Integer sendType, double[] itemPrice, double total,String[] fileName) {
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
		this.fileName=fileName;
	}
	
	
	public String[] getFileName() {
		return fileName;
	}


	public void setFileName(String[] fileName) {
		this.fileName = fileName;
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

	public double[] getPrice() {
		return price;
	}

	public void setPrice(double[] price) {
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
	
	/**
	 * 单个条目总价保存
	 * @param itemPrice
	 * @param i
	 */
	public void setItemPrice(double itemPrice, int  i){
		this.itemPrice[i] = itemPrice;
	}
}
