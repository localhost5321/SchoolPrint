package com.schoolo2o.pojo;

import java.io.Serializable;

/**
 * 临时存储店家注册时所填写的 价格列表 K为类别名称 V为对应的价格
 * @author 恒毅
 *
 */
public class PriceKV implements Serializable{
	
	private String priceK;
	private String priceV;
	
	public PriceKV(){
		
	}
	
	public PriceKV(String priceK, String priceV) {
		super();
		this.priceK = priceK;
		this.priceV = priceV;
	}

	public String getPriceK() {
		return priceK;
	}
	public void setPriceK(String priceK) {
		this.priceK = priceK;
	}
	public String getPriceV() {
		return priceV;
	}
	public void setPriceV(String priceV) {
		this.priceV = priceV;
	}
}
