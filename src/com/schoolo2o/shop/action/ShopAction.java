package com.schoolo2o.shop.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.Shopinfo;
import com.schoolo2o.service.ShopService;

/**
 * 商店端的操作
 * @author hua
 *
 */
public class ShopAction extends ActionSupport{
	private ShopService shopService ;
	public ShopService getShopService() {
		return shopService;
	}
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	private Shopinfo shopInfo;
	private Map<String, Object> session = ServletActionContext.getContext().getSession();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	public Shopinfo getShopInfo() {
		return shopInfo;
	}
	public void setShopInfo(Shopinfo shopInfo) {
		this.shopInfo = shopInfo;
	}
	
	public String shopLogin() throws IOException{
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf8");
		System.out.println("shopInfo = "+shopInfo);
		System.out.println("shopInfo.shopName = "+shopInfo.getShopName());
		System.out.println("shopPwd = "+shopInfo.getShopPwd());
		System.out.println("this = "+this);
		System.out.println("this.shopService = "+this.shopService);//null
		System.out.println("shop = "+this.shopService.search(shopInfo.getShopName()));
		Shopinfo shop = this.shopService.search(shopInfo.getShopName());
		
		if(shop == null){
			response.getWriter().write("{\"status\":\"0\",\"message\":\"商店不存在\"}");
			return null;
		}
		else if(shop.getShopPwd().equals(shopInfo.getShopPwd())){
			session.put("shopInfo", shop);
			response.getWriter().write("{\"status\":\"1\",\"message\":\""+shop+"\"}");
			return null;
		}
		else{
			response.getWriter().write("{\"status\":\"0\",\"message\":\"密码错误\"}");
			return null;
		}
	}
}
