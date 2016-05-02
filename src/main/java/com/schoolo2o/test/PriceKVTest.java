package com.schoolo2o.test;

import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.schoolo2o.pojo.PriceKV;
import com.schoolo2o.utils.Console;

public class PriceKVTest {
	public static void main(String[] args) {
		ArrayList<PriceKV> list = new ArrayList<PriceKV>();
		PriceKV p_1 = new PriceKV("单面普通", "0.1");
		PriceKV p_2 = new PriceKV("单面彩色", "1.0");
		list.add(p_1);
		list.add(p_2);
		String json =  JSON.toJSONString(list);
		ArrayList<PriceKV> new_list = (ArrayList<PriceKV>) JSON.parseArray(json, PriceKV.class);
		System.out.println(new_list.get(1).getPriceV());
		
		
	}
}
