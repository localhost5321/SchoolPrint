package com.schoolo2o.action;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.MyJSONObject;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Priceinfo;
import com.schoolo2o.pojo.ShopComment;
import com.schoolo2o.pojo.Shopinfo;
import com.schoolo2o.service.OrderService;
import com.schoolo2o.service.ShopService;

public class ShopAction extends ActionSupport {
	private ShopService shopService;
	private OrderService orderService;
	private MyJSONObject jsonObject=new MyJSONObject();
	private HttpServletResponse response=ServletActionContext.getResponse();
	private HttpServletRequest request = ServletActionContext.getRequest();
	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
	
	
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * 获取商店列表
	 * @throws IOException
	 */
	public  String getAllShops() throws IOException{
		List<Shopinfo> list=shopService.searchShop();
		response.setContentType("text/plain");
		request.setCharacterEncoding("utf-8");
		if(list!=null&&!list.isEmpty()){
			String str=list.iterator().next().getShopDesc();
			System.out.println(str);
			jsonObject.setStatus("1");
			jsonObject.setMessage("null");
			jsonObject.setData(list);
			String jsonStr=JSON.toJSONString(jsonObject);
			System.out.println(jsonStr);
			response.getWriter().write(jsonStr);
			return null;
		}else{
			jsonObject.setStatus("0");
			jsonObject.setMessage(" 请求错误");
			jsonObject.setData(null);
			String jsonStr=JSON.toJSONString(jsonObject);
			response.getWriter().write(jsonStr);
			return null;
		}
	}
	
	/**
	 * 由商店名获取商店详情
	 * @param shopName
	 * @return
	 * @throws IOException
	 */
	public String getShopByName() throws IOException{
		String shopName=request.getParameter("userName");
		Shopinfo shop=shopService.search(shopName);
		if(shop!=null){
			List<ShopComment> comment=shopService.getComments(shopName);
//			List <Priceinfo> priceType=shopService.getTypePrice(shopName);
			List<Orderinfo> orders=orderService.shopSearch(shopName);
//			shop.setOrderinfos(new HashSet(orders));
//			shop.setPriceinfos(new HashSet(priceType));
			shop.setShopComments(new HashSet(comment));
//			System.out.println(shop.getShopName());
			jsonObject.setStatus("1");
			jsonObject.setMessage("null");
			jsonObject.setData(shop);
			String jsonStr=JSON.toJSONString(jsonObject);
			response.getWriter().write(jsonStr);//
			
		}else{
			jsonObject.setStatus("0");
			jsonObject.setMessage(" 请求错误");
			jsonObject.setData(null);
			String jsonStr=JSON.toJSONString(jsonObject);
			response.getWriter().write(jsonStr);//
			
		}
		return null;
	}
	

}
