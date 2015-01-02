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
import com.schoolo2o.pojo.send.OrderstatusSend;
import com.schoolo2o.pojo.send.ShopCommentSend;
import com.schoolo2o.pojo.send.ShopinfoSend;
import com.schoolo2o.service.OrderService;
import com.schoolo2o.service.ShopService;
import com.schoolo2o.utils.ListChange;
public class OrderAction extends ActionSupport {
	private ShopService shopService;
	private OrderService orderService;
	private Map<String, Object> session = ServletActionContext.getContext().getSession();
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
	 * 计算订单价格
	 * 需要计算出每一份价格以及总价
	 */
	public String showOrder(){
		String jsonStr=request.getParameter("");
		try{
			if(jsonStr!=null&&!jsonStr.equals("null")){
				OrderinfoSend order=JSON.parseObject(jsonStr,OrderinfoSend.class);
				//调用服务层计费方式，待完成
				jsonObject.setMessage("null");
				jsonObject.setData(order);
				jsonStr=JSON.toJSONString(jsonObject);
				response.getWriter().write(jsonStr);
			}else{
				jsonObject.setMessage("参数为空");
				jsonObject.setData(null);
				jsonStr=JSON.toJSONString(jsonObject);
				response.getWriter().write(jsonStr);
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.setStatus("0");
			jsonObject.setMessage("服务器出现异常");
			jsonStr=JSON.toJSONString(jsonObject);
			response.getWriter().write(jsonStr);
		}finally{
			return null;
		}
	}
	
	/**
	 * 存储订单
	 * 需要传递订单信息
	 */
	public String saveOrder(){
		String jsonStr=request.getParameter("hh");
		try{
			System.out.println(jsonStr);
			response.setCharacterEncoding("utf-8");
			if(jsonStr!=null&&!jsonStr.equals("")){
				OrderinfoSend order=JSON.parseObject(jsonStr,OrderinfoSend.class);
				//调用服务层计费 保存
				jsonObject.setMessage("null");
				jsonObject.setData(order);
				jsonStr=JSON.toJSONString(jsonObject);
				response.getWriter().write(jsonStr);
			}else{
				jsonObject.setMessage("参数为空");
				jsonObject.setData(null);
				jsonStr=JSON.toJSONString(jsonObject);
				response.getWriter().write(jsonStr);
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.setStatus("0");
			jsonObject.setMessage("服务器出现异常");
			jsonStr=JSON.toJSONString(jsonObject);
			response.getWriter().write(jsonStr);
		}finally{
			return null;
		}
	}
	
	/**
	 * 修改订单状态
	 * 需要获取新状态，以及原有状态信息
	 */
	public String editOrderStatus(){
		String oldStatusIdStr=request.getParameter("");
		String jsonStr=request.getParameter("jsonStr");
		try{
			if(oldStatusIdStr!=null&&jsonStr!=null){
				long oldStatusId=Long.parseLong(oldStatusIdStr);
				OrderstatusSend statu=JSON.
						parseObject(jsonStr, OrderstatusSend.class);
				//调用服务层修改，待完成
				jsonObject.setMessage("订单状态修改完毕");
				jsonObject.setData(null);
				jsonStr=JSON.toJSONString(jsonObject);
				response.getWriter().write(jsonStr);
			}else{
				jsonObject.setMessage("参数有错误");
				jsonObject.setData(null);
				jsonStr=JSON.toJSONString(jsonObject);
				response.getWriter().write(jsonStr);
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.setMessage("服务器出现异常");
			jsonObject.setData(null);
			jsonStr=JSON.toJSONString(jsonObject);
			response.getWriter().write(jsonStr);
		}finally{
			return null;
		}
	}

}
