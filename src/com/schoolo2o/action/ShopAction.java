package com.schoolo2o.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.PriceKV;
import com.schoolo2o.pojo.Priceinfo;
import com.schoolo2o.pojo.ShopComment;
import com.schoolo2o.pojo.Shopinfo;
import com.schoolo2o.pojo.send.OrderinfoSend;
import com.schoolo2o.pojo.send.PriceinfoSend;
import com.schoolo2o.pojo.send.ShopCommentSend;
import com.schoolo2o.pojo.send.ShopinfoSend;
import com.schoolo2o.service.OrderService;
import com.schoolo2o.service.ShopService;
import com.schoolo2o.utils.Console;
import com.schoolo2o.utils.ListChange;
import com.schoolo2o.utils.MD5;
import com.schoolo2o.utils.Sender;

/**
 * 商店端的操作
 * @author hua
 *
 */
public class ShopAction extends ActionSupport{
	
	private ShopService shopService ;
	private OrderService orderService;
	private Shopinfo shopInfo;
	private Map<String, Object> session = ServletActionContext.getContext().getSession();
	private HttpServletResponse response = ServletActionContext.getResponse();
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
	
	public Shopinfo getShopInfo() {
		return shopInfo;
	}
	
	public void setShopInfo(Shopinfo shopInfo) {
		this.shopInfo = shopInfo;
	}
	
	/**
	 * 获取商店列表
	 * 
	 * @throws IOException
	 */
	public String getAllShops() {
		try {
			List<Shopinfo> list = shopService.searchShop();
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			if (list != null && !list.isEmpty()) {
				List<ShopinfoSend> listSend = ListChange.ParaseShops(list);
				Console.LOG(getClass(), listSend.size());
				Sender.sendOk(listSend, response);
			} else {
				Sender.sendError("请求错误", response);
			}
		} catch (Exception e) {
			Sender.sendError("服务器有点问题", response);
			e.printStackTrace();
		} finally {
			return null;
		}
	}
	
	
	/**
	 * 由商店名获取商店详情
	 * 
	 * @param shopName
	 * @return
	 * @throws IOException
	 */
	public String getShopByName() throws IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String shopName = request.getParameter("shopName");
		Shopinfo shop = shopService.search(shopName);
		try {
			if (shop != null) {
				ShopinfoSend shopinfoSend = new ShopinfoSend(shop);
				List<ShopComment> comments = shopService.getCommentsSplit(
						shopName, 0, 10);
				List<Orderinfo> orders = shopService.getOrdersSplit(shopName,
						0, 10);
				List<Priceinfo> prices = shopService.getTypePrice(shopName);
				List<OrderinfoSend> orderSends = ListChange
						.ParaseOrders(orders);
				List<ShopCommentSend> commentsSend = ListChange
						.ParaseComments(comments);
				List<PriceinfoSend> pricesSend = ListChange
						.ParasePrices(prices);
				shopinfoSend.setPriceinfos(pricesSend);
				shopinfoSend.setComments(commentsSend);
				shopinfoSend.setOrders(orderSends);
				request.setAttribute("shop", shopinfoSend);
				Sender.sendOk(shopinfoSend, response);
				return null;
			} else {
				Sender.sendError("参数有错误", response);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Sender.sendError("服务器错误", response);
			return null;
		}

	}
	
	/**
	 * 店家登录
	 * @return
	 * @throws IOException
	 */
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
		Console.LOG(getClass(), shop.getShopPwd());
		
		if(shop == null){
			response.getWriter().write("{\"status\":\"0\",\"message\":\"商店不存在\"}");
			return null;
		}
		else if(shop.getShopPwd().equals(shopInfo.getShopPwd())){
			session.put("shopInfo", shop);
			response.getWriter().write("{\"status\":\"1\",\"message\":\"\",\"shop\":"+ shop +"}");
			return null;
		}
		else{
			response.getWriter().write("{\"status\":\"0\",\"message\":\"密码错误\"}");
			return null;
		}
	}
	
	
	/**
	 * 店家注册
	 * @return
	 * @throws IOException 
	 */
	public String shopRegist() throws IOException{
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		shopInfo.setShopPwd(MD5.md5(shopInfo.getShopPwd().getBytes()));
		String priceKVs = request.getParameter("priceKV");
		boolean addSucc = shopService.add(shopInfo);
		
		if(addSucc){
			//反序列化价格列表的JSON，依次重组并添加到对应店铺
			if(!priceKVs .equals("null")){
				ArrayList<PriceKV> priceList = (ArrayList<PriceKV>) JSON.parseArray(priceKVs, PriceKV.class);
				for(PriceKV p : priceList){
					Priceinfo pi = new Priceinfo(shopService.search(shopInfo.getShopName()),
							p.getPriceK(), Double.parseDouble(p.getPriceV()));
					shopService.addTypePrice(pi, shopInfo.getShopName());
				}
			}
			
			response.getWriter().write("{\"status\":\"1\",\"message\":\"\"}");
			return null;
		}
		response.getWriter().write("{\"status\":\"0\",\"message\":\"注册失败\"}");
		return null;
	}
}
