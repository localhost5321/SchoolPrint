package com.schoolo2o.utils;

import com.alibaba.fastjson.JSON;
import com.schoolo2o.pojo.MyJSON;

/**
 * 前段和服务器后端交换轻量级数据JSON的通用工具类
 * 
 * @author hengyi
 * 
 */
public class MyJSONUtils {
	/**
	 * 将对象转换为JSON字符串
	 * 
	 * @param myJSON
	 * @return
	 */
	public static String Object2JSON(MyJSON myJSON) {
		return JSON.toJSONString(myJSON);
	}

	/**
	 * 将JSON字符串转换为MyObject对象
	 * 
	 * @param str
	 * @return
	 */
	public static MyJSON JSON2Object(String str) {
		return JSON.parseObject(str, MyJSON.class);
	}
}
