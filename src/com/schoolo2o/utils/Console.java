package com.schoolo2o.utils;

/**
 * 测试输出用，代替syso，避免太多打印语句，最后不用输出控制台的时候注释掉这里的
 * @author 恒毅
 *
 */
public class Console {
	
	public static void LOG(Class clazz,Object info)
	{
		System.out.println(clazz.getName() + "****输出: ****" + info);
	}
	
	public static void ERR(Class clazz,Object error){
		System.err.println(clazz.getName() + "****错误: ****" + error);
	}
}
