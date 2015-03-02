package com.schoolo2o.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class Constant {
	public static String WebFilePath;
	private final static HttpServletRequest serletRequest = ServletActionContext
			.getRequest();
	private final static ServletContext servletContext = ServletActionContext
			.getServletContext();

	static {
		String webName = serletRequest.getContextPath().toString()
				.replace("/", "").trim();
		String str = servletContext.getRealPath("/");
		Constant.WebFilePath = servletContext.getRealPath("/")
				.replace("ROOT", "files").toString();
	}
}
