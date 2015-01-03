package com.schoolo2o.action;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.MyJSONObject;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.pojo.send.OrderSend;
import com.schoolo2o.pojo.send.OrderinfoSend;
import com.schoolo2o.pojo.send.OrderstatusSend;
import com.schoolo2o.service.OrderService;
import com.schoolo2o.service.ShopService;
import com.schoolo2o.utils.Sender;
public class OrderAction extends BaseAction {
	private ShopService shopService;
	private OrderService orderService;
	private String[] set;//用于保存打印原有设置的字符串，回传给浏览器
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
	 * 从浏览器传来的参数封装成一个order,
	 * 并且去服务层计算出每一项的价格，以及总价放在此order对象中
	 * @param jsonStr
	 * @return
	 */
	public OrderSend getOrderFromStr(String jsonStr){
		
		OrderSend order=new OrderSend();
		System.out.println(jsonStr);
		JSONObject orderObject=JSON.parseObject(jsonStr);
		String data=orderObject.getString("data");
		String shopName=orderObject.getString("shopName");
		JSONArray ja=JSON.parseArray(data);
		String userName;
		if (session.containsKey("user")) {
			Userinfo userinfo=(Userinfo) session.get("user");
			userName =userinfo.getUserName();
		}else{
			userName="herozhao";
		}
		order.setShopName(shopName);
		order.setPayType(1);
		order.setSendType(1);
		order.setUserName(userName);
		order.setDocId(new Long[ja.size()]);
		order.setFileCount(new Integer[ja.size()]);
		order.setItemPrice(new double[ja.size()]);
		order.setPageCount(new Integer[ja.size()]);
		order.setPrice(new double[ja.size()]);
		order.setPrintRequire(new String[ja.size()]);
		order.setFileName(new String[ja.size()]);
		set=new String[ja.size()];
		for(int i=0;i<ja.size();i++){
			JSONObject orderItem=ja.getJSONObject(i);
			System.out.println("~~~~~~~~~~~~~~~");
			System.out.print(orderItem.getString("docId"));
			long docId=Long.parseLong(orderItem.getString("docId"));
			Integer pageCounts=Integer.parseInt(orderItem.getString("pageCounts"));
			String setting=orderItem.getString("setting");
			set[i]=setting;
			String[] typeSet=setting.split("、");
			if(typeSet[0].equals("黑白")){
				typeSet[0]="BK";	
			}else{
				typeSet[0]="CR";
			}
			if(typeSet[1].equals("单面")){
				typeSet[1]="SL";
				System.out.println(typeSet[1]);
			}else{
				typeSet[1]="DL";
			}
			setting=new String();
			for(String str:typeSet){
				setting+=str;
			}
//			System.out.println(setting + "  " + shopName);
			double price=shopService.getPrice(setting, shopName);
			System.out.println(price);
			String printCounts=orderItem.getString("printCounts");
			Integer printCount=Integer.parseInt(printCounts);
			String fileName=orderItem.getString("fileName");
			order.getFileName()[i]=fileName;
			order.getPrice()[i]=price;
			order.getFileCount()[i]=printCount;
			order.getPageCount()[i]=pageCounts;
			order.getPrintRequire()[i]=setting;
			order.getDocId()[i]=docId;
		}
//		System.out.println(orderService);
		order=orderService.addOrder(order);
		return order;
	};
	
	/**
	 * 需要请求总价以及每一订单条目价格
	 * 其为相应应Action所对应的请求方法
	 */
	public String showOrder(){
		String jsonStr=request.getParameter("data");
		response.setCharacterEncoding("utf-8");
		try{
			if(jsonStr!=null&&!jsonStr.equals("null")){
				OrderSend order=getOrderFromStr(jsonStr);
				order.setPrintRequire(set);
				Sender.sendOk(order, response);
			}else{
				Sender.sendError("参数有误哦", response);
				System.out.print("!!!!!!!!!!!!!");
			}
		}catch(Exception e){
			e.printStackTrace();
			Sender.sendError("服务器异常", response);
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
