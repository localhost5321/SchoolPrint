package com.schoolo2o.test;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.schoolo2o.utils.Console;

public class JSONObjectTest {
	
	public static void main(String[] args) {
		User u_1 = new User("张三","19");
		User u_2 = new User("lisa", "18");
		
		Set<User> users = new HashSet<User>(0);
		users.add(u_1);
		users.add(u_2);
		
		Clazz c = new Clazz(users, "clazz one");
		
		String json = JSON.toJSONString(c);
		
		JSONObject jo = JSON.parseObject(json);
		
		String clazzName = (String)jo.get("clazzName");
		JSONArray ja = jo.getJSONArray("users");
		
		
		Console.LOG(JSONObjectTest.class, "clazzName:" + clazzName
				+ "*********uName:" + ja.get(1).toString());
	}

}
