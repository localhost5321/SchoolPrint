package com.schoolo2o.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.MyJSONObject;

public class BaseAction extends ActionSupport {
	protected Map<String, Object> session = ServletActionContext.getContext().getSession();
	protected MyJSONObject jsonObject=new MyJSONObject();
	protected HttpServletResponse response=ServletActionContext.getResponse();
	protected HttpServletRequest request = ServletActionContext.getRequest();
	
	
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public MyJSONObject getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(MyJSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
