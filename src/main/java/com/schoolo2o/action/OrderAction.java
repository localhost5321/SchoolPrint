package com.schoolo2o.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.cglib.transform.impl.AddDelegateTransformer;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.Addressinfo;
import com.schoolo2o.pojo.MyJSONObject;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Orderitem;
import com.schoolo2o.pojo.Orderstatus;
import com.schoolo2o.pojo.Shopinfo;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.pojo.send.OrderSend;
import com.schoolo2o.pojo.send.OrderinfoSend;
import com.schoolo2o.pojo.send.OrderstatusSend;
import com.schoolo2o.service.AddressService;
import com.schoolo2o.service.OrderService;
import com.schoolo2o.service.ShopService;
import com.schoolo2o.utils.Console;
import com.schoolo2o.utils.Sender;

public class OrderAction extends BaseAction {
	private ShopService shopService;
	private OrderService orderService;
	private AddressService addressService;
	private String[] set;// 用于保存打印原有设置的字符串，回传给浏览器

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

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * 从浏览器传来的参数封装成一个order, 并且去服务层计算出每一项的价格，以及总价放在此order对象中
	 * 
	 * @param jsonStr
	 * @return
	 */
	public OrderSend getOrderFromStr(String jsonStr) {
		System.out.println(jsonStr);
		OrderSend order = new OrderSend();
		JSONObject orderObject = JSON.parseObject(jsonStr);
		String data = orderObject.getString("data");
		String shopName = orderObject.getString("shopName");
		JSONArray ja = JSON.parseArray(data);
		String userName;
		if (session.containsKey("user")) {
			Userinfo userinfo = (Userinfo) session.get("user");
			userName = userinfo.getUserName();
		} else {
			userName = "herozhao";
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
		set = new String[ja.size()];
		for (int i = 0; i < ja.size(); i++) {
			JSONObject orderItem = ja.getJSONObject(i);
			System.out.print(orderItem.getString("docId"));
			long docId = Long.parseLong(orderItem.getString("docId"));
			Integer pageCounts = Integer.parseInt(orderItem
					.getString("pageCounts"));
			String setting = orderItem.getString("setting");
			set[i] = setting;
			String[] typeSet = setting.split("、");
			if (typeSet[0].equals("黑白")) {
				typeSet[0] = "BK";
			} else {
				typeSet[0] = "CR";
			}
			if (typeSet[1].equals("单面")) {
				typeSet[1] = "SL";
				System.out.println(typeSet[1]);
			} else {
				typeSet[1] = "DL";
			}
			setting = new String();
			for (String str : typeSet) {
				setting += str;
			}
			System.out.println(setting + "  " + shopName);
			double price = shopService.getPrice(setting, shopName);
			String printCounts = orderItem.getString("printCounts");
			Integer printCount = Integer.parseInt(printCounts);
			String fileName = orderItem.getString("fileName");
			order.getFileName()[i] = fileName;
			order.getPrice()[i] = price;
			order.getFileCount()[i] = printCount;
			order.getPageCount()[i] = pageCounts;
			order.getPrintRequire()[i] = setting;
			order.getDocId()[i] = docId;
		}
		// System.out.println(orderService);
		order = orderService.getOrderPrice(order);
		// session.put("order", order);
		return order;
	};

	/**
	 * 需要请求总价以及每一订单条目价格 其为相应Action所对应的请求方法
	 */
	public String showOrder() {
		String jsonStr = request.getParameter("data");
		response.setCharacterEncoding("utf-8");
		try {
			if (jsonStr != null && !jsonStr.equals("null")) {
				OrderSend order = getOrderFromStr(jsonStr);
				order.setPrintRequire(set);
				Sender.sendOk(order, response);
			} else {
				Sender.sendError("参数有误", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Sender.sendError("服务器异常", response);
		} finally {
			return null;
		}
	}

	/**
	 * 返还所有的地址信息给浏览器
	 * 
	 * @return
	 */
	public String getAllAddress() {
		try {
			long userId;
			if (session.containsKey("user")) {
				Userinfo user = (Userinfo) session.get("user");
				System.out.println(user);

				userId = user.getUserId();
			} else {
				userId = 44L;
			}
			List<Addressinfo> list = addressService.getAddresses(userId);
			if (list != null) {
				for (Addressinfo as : list) {
					as.setUserinfo(null);
				}
				Sender.sendOk(list, response);
			} else {
				Sender.sendError("当前没有地址信息", response);
			}
		} catch (Exception e) {
			Sender.sendError("服务器异常", response);
			e.printStackTrace();
		} finally {
			return null;
		}
	}

	/**
	 * 接受一个要删除的地址Id 删除一个地址信息
	 * 
	 * @return
	 */
	public String deleteAddressinfo() {
		response.setCharacterEncoding("gbk");
		try {
			String strAddId = request.getParameter("addId");
			if (strAddId == null || strAddId.equals("")) {
				Sender.sendError("参数为空", response);
				return null;
			}
			long addId = Long.parseLong(strAddId);
			boolean flag = addressService.deleteAddress(addId);
			if (flag) {
				Sender.sendOk("删除成功", response);
			} else {
				Sender.sendError("删除失败", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Sender.sendError("服务器异常", response);
		} finally {
			return null;
		}
	}

	/**
	 * 添加或者更新一个地址信息
	 * 
	 * @return
	 * @throws IOException
	 */
	public String addOrUpdateAddressinfo() throws IOException {
		Userinfo userinfo = (Userinfo) session.get("user");

		if (userinfo == null) {
			Sender.sendOk("匿名用户", response);
			return null;
		}
		userinfo.setDocinfos(null);
		userinfo.setOrderinfos(null);
		userinfo.setAddressinfos(null);
		String contactor = request.getParameter("contactor");
		String sendAddress = request.getParameter("sendAddress");
		String callPhone = request.getParameter("callPhone");
		String secPhone = request.getParameter("secPhone");
		String addressId = request.getParameter("addressId");
		try {
			//这里应该前台保证这些参数不为空
			if (callPhone == null || secPhone == null || sendAddress == null
					|| addressId == null) {
				Sender.sendError("必要参数为空", response);
				return null;
			}
			Addressinfo address = new Addressinfo();
			address.setCallPhone(callPhone);
			address.setContactor(contactor);
			
			List<Addressinfo> list = addressService.getAddresses(userinfo.getUserId());
			if( list == null )
				address.setIsDefault(1); // 首次添加的地址缺省为默认地址
			else
				address.setIsDefault(0); // 默认为0表示不是默认地址
			address.setSecPhone(secPhone);
			address.setSendAddress(sendAddress);
			// 如果传过来有Id,表示修改
			if (!addressId.equals("none")) {
				long addId = Long.parseLong(addressId);
				address.setAddressId(addId);
			}
			// 如果当前用户登录，则取登录用户地址，如果没有登录则不会进入此页面

			address.setUserinfo(userinfo);
			boolean flag = addressService.addOrUpdateAddress(address);
			if (flag) {
				Sender.sendOk(address, response);
			} else {
				Sender.sendError("保存失败", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return null;
		}
	}

	/**
	 * 存储订单 需要传递订单信息
	 * @throws IOException 
	 */
	public String saveOrder() throws IOException {
		String jsonStr = request.getParameter("order");
		try {
			Console.LOG(getClass(), "前台传送过来的order的JSON为：" + jsonStr);
			
			JSONObject jo = JSON.parseObject(jsonStr);
			String shopName = jo.getString("shopName");
			double totalCost = jo.getDoubleValue("total");
			long addressId = jo.getLong("addressId");
			int payType = jo.getIntValue("payType");
			int sendType = jo.getIntValue("sendType");
			JSONArray ja = jo.getJSONArray("data");
			
			Orderinfo orderinfo = new Orderinfo();
			Set<Orderitem> orderitems = new HashSet<Orderitem>();
			
			//获取每一条订单条目
			for (int i = 0; i < ja.size(); i++) {
				JSONObject orderItem = JSON.parseObject(ja.get(i).toString());
				long docId = orderItem.getLongValue("docId");
				String fileName = orderItem.getString("fileName");
				int pageNumber = Integer.parseInt(orderItem.getString("pageCounts"));
				int fileCount = Integer.parseInt(orderItem.getString("printCounts"));
				String printRequire = orderItem.getString("setting");
				double filePrice = orderItem.getDoubleValue("price");
				Orderitem order = new Orderitem(orderinfo, docId, fileCount, pageNumber, filePrice, printRequire);
				orderitems.add(order);
			}
			
			Shopinfo shopinfo = shopService.search(shopName);
			Userinfo userinfo = (Userinfo) session.get("user");
			
			orderinfo.setAddressId(addressId);
			orderinfo.setOrderitems(orderitems);
			orderinfo.setPayType(payType);
			orderinfo.setSendType(sendType);
			orderinfo.setShopinfo(shopinfo);
			orderinfo.setTotalCost(totalCost);
			orderinfo.setUserinfo(userinfo);
			
			Orderstatus orderstatus = new Orderstatus();
			orderstatus.setChangeTime(new Timestamp(new Date().getTime()));
			orderstatus.setIsCurrent(1);
			orderstatus.setOrderinfo(orderinfo);
			orderstatus.setStatus(0);
			Set<Orderstatus> statusSet = new HashSet<Orderstatus>();
			statusSet.add(orderstatus);
			orderinfo.setOrderstatuses(statusSet);
			
			response.setCharacterEncoding("utf-8");
			if (jsonStr != null && !jsonStr.equals("")) {
				// 保存
				if(orderService.saveOrder(orderinfo)){
					jsonObject.setStatus("1");
					jsonObject.setMessage("");
					jsonObject.setData(null);
				}else{
					jsonObject.setStatus("0");
					jsonObject.setMessage("保存失败");
					jsonObject.setData(null);
				}
			} else {
				jsonObject.setStatus("0");
				jsonObject.setMessage("参数为空");
				jsonObject.setData(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.setStatus("0");
			jsonObject.setMessage("服务器出现异常");
		} finally {
			response.getWriter().write(JSON.toJSONString(jsonObject));
			return null;
		}
	}

	/**
	 * 修改地址状态是否为当前地址
	 * 
	 * @throws IOException
	 */
	public String setDefault() throws IOException {
		String oldId = request.getParameter("oldId");
		String newId = request.getParameter("newId");

		if ("null".equals(oldId) && newId != null) {
			// 没有默认地址，设置默认地址
			long newIdL = Long.parseLong(newId);
			boolean flag = addressService.changeTypes(-1, newIdL);
			if (flag)
				Sender.sendOk("修改成功", response);
			else
				Sender.sendError("修改失败", response);
			return null;
		}
		if (oldId == null || newId == null) {
			Sender.sendError("参数有误", response);
		} else {
			long oldIdL = Long.parseLong(oldId);
			long newIdL = Long.parseLong(newId);
			boolean flag = addressService.changeTypes(oldIdL, newIdL);
			if (flag)
				Sender.sendOk("修改成功", response);
			else
				Sender.sendError("修改失败", response);
		}
		return null;
	}

	/**
	 * 修改订单状态 需要获取新状态Id，以及原有状态Id
	 */
	public String editOrderStatus() {
		String oldStatusIdStr = request.getParameter("");
		String jsonStr = request.getParameter("jsonStr");
		try {
			if (oldStatusIdStr != null && jsonStr != null) {
				long oldStatusId = Long.parseLong(oldStatusIdStr);
				OrderstatusSend statu = JSON.parseObject(jsonStr,
						OrderstatusSend.class);
				// 调用服务层修改，待完成
				jsonObject.setMessage("订单状态修改完毕");
				jsonObject.setData(null);
				jsonStr = JSON.toJSONString(jsonObject);
				response.getWriter().write(jsonStr);
			} else {
				jsonObject.setMessage("参数有错误");
				jsonObject.setData(null);
				jsonStr = JSON.toJSONString(jsonObject);
				response.getWriter().write(jsonStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.setMessage("服务器出现异常");
			jsonObject.setData(null);
			jsonStr = JSON.toJSONString(jsonObject);
			response.getWriter().write(jsonStr);
		} finally {
			return null;
		}
	}
	
	/**
	 * 返回所有订单信息
	 * @return
	 */
	public String getAllOrder(){
		
		return null;
	}

}
