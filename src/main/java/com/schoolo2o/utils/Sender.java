package com.schoolo2o.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.schoolo2o.pojo.MyJSONObject;

public class Sender {
	
	/**
	 * 发送正确信息给浏览器	
	 * @param data
	 * @param response
	 * @throws IOException
	 */
	public static void sendOk(Object data,HttpServletResponse response) throws IOException{
		MyJSONObject mj=new MyJSONObject();
		mj.setStatus("1");
		mj.setMessage("");
		mj.setData(data);
		String jsonStr = JSON.toJSONString(mj);
		Console.LOG(Sender.class, jsonStr);
		response.getWriter().write(jsonStr);
	}
	/**
	 * 发送错误信息给浏览器
	 * @param message
	 * @param response
	 * @throws IOException
	 */
	public static void sendError(String message,HttpServletResponse response) throws IOException{
		MyJSONObject mj=new MyJSONObject();
		mj.setStatus("0");
		mj.setMessage(message);
		mj.setData(null);
		String jsonStr = JSON.toJSONString(mj);
		response.getWriter().write(jsonStr);
	}

}
