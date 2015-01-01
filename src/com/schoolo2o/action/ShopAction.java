package com.schoolo2o.action;

import java.io.IOException;
import java.util.ArrayList;
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
import com.schoolo2o.pojo.send.OrderinfoSend;
import com.schoolo2o.pojo.send.ShopCommentSend;
import com.schoolo2o.pojo.send.ShopinfoSend;
import com.schoolo2o.service.OrderService;
import com.schoolo2o.service.ShopService;
import com.schoolo2o.utils.ListChange;

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
			List<ShopinfoSend> listSend=ListChange.ParaseShops(list);
			System.out.println(listSend.size());
			jsonObject.setStatus("1");
			jsonObject.setMessage("null");
			jsonObject.setData(listSend);
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
		String shopName=request.getParameter("shopName");
		Shopinfo shop=shopService.search(shopName);
		if(shop!=null){
			ShopinfoSend shopinfoSend=new ShopinfoSend(shop);
			List<ShopComment> comments=shopService.getCommentsSplit(shopName, 0, 10);
			List<Orderinfo> orders=shopService.getOrdersSplit(shopName, 0, 10);
			List<OrderinfoSend> orderSends=ListChange.ParaseOrders(orders);
			List<ShopCommentSend>commentsSend=ListChange.ParaseComments(comments);
			shopinfoSend.setComments(commentsSend);
			shopinfoSend.setOrders(orderSends);
			request.setAttribute("shop", shopinfoSend);
			
			jsonObject.setStatus("1");
			jsonObject.setMessage("null");
			jsonObject.setData(shopinfoSend);
			String jsonStr=JSON.toJSONString(jsonObject);
			response.getWriter().write(jsonStr);
			return SUCCESS;
			
			
		}else{
			jsonObject.setStatus("0");
			jsonObject.setMessage(" 请求错误");
			jsonObject.setData(null);
			String jsonStr=JSON.toJSONString(jsonObject);
			response.getWriter().write(jsonStr);//
			return null;
		}
		
	}
	

}
