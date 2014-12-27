package com.schoolo2o.test;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class TestAjax extends ActionSupport{
	
	public String execute(){
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain");
			
			response.getWriter().write("{name: guopenghua}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
