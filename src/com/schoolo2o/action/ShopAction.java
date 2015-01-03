package com.schoolo2o.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
import com.schoolo2o.pojo.send.PriceinfoSend;
import com.schoolo2o.pojo.send.ShopCommentSend;
import com.schoolo2o.pojo.send.ShopinfoSend;
import com.schoolo2o.service.OrderService;
import com.schoolo2o.service.ShopService;
import com.schoolo2o.utils.ListChange;
import com.schoolo2o.utils.Sender;
public class ShopAction extends BaseAction {
	private ShopService shopService;
	private OrderService orderService;

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
		System.out.println("enter!");
		List<Shopinfo> list=shopService.searchShop();
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		if(list!=null&&!list.isEmpty()){
			List<ShopinfoSend> listSend=ListChange.ParaseShops(list);
			System.out.println(listSend.size());
			Sender.sendOk(listSend, response);
			return null;
		}else{
			Sender.sendError("请求错误", response);
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
			List<Priceinfo> prices=shopService.getTypePrice(shopName);
			List<OrderinfoSend> orderSends=ListChange.ParaseOrders(orders);
			List<ShopCommentSend>commentsSend=ListChange.ParaseComments(comments);
			List<PriceinfoSend> pricesSend=ListChange.ParasePrices(prices);
			shopinfoSend.setPriceinfos(pricesSend);
			shopinfoSend.setComments(commentsSend);
			shopinfoSend.setOrders(orderSends);
			request.setAttribute("shop", shopinfoSend);
			Sender.sendOk(shopinfoSend, response);
			return SUCCESS;
		}else{
			Sender.sendError("不要着急哦", response);
			return null;
		}
		
	}
	
	

}
