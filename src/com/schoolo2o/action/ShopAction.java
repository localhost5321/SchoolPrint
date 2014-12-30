package com.schoolo2o.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.MyJSONObject;
import com.schoolo2o.pojo.Shopinfo;
import com.schoolo2o.service.ShopService;

public class ShopAction extends ActionSupport {
	private ShopService shopService;
	private MyJSONObject jsonObject=new MyJSONObject();
	private HttpServletResponse response=ServletActionContext.getResponse();
	private HttpServletRequest request = ServletActionContext.getRequest();
	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
	/**
	 * 获取商店列表
	 * @throws IOException
	 */
	public  String getAllShops() throws IOException{
		List<Shopinfo> list=shopService.searchShop();
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		if(list!=null&&!list.isEmpty()){
			jsonObject.setStatus("1");
			jsonObject.setMessage("null");
			jsonObject.setData(list);
			String jsonStr=JSON.toJSONString(jsonObject);
			System.out.println("fhdsughfu");
			System.out.println(jsonStr);
			response.getWriter().write(jsonStr);// 此处没有写完，到时候用json转化后，返回json字符串
			return null;
		}else{
			jsonObject.setStatus("0");
			jsonObject.setMessage(" 请求错误");
			jsonObject.setData(null);
			String jsonStr=JSON.toJSONString(jsonObject);
			response.getWriter().write(jsonStr);//
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
			response.getWriter().write(shop.toString());
		}else{
			response.getWriter().write("null");//此处待完善
		}
		return null;
	}
	

}
