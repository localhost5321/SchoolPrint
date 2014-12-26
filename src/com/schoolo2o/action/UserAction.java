package com.schoolo2o.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.service.UserService;
import com.schoolo2o.utils.MD5;

public class UserAction extends ActionSupport{
	
	private Userinfo user ;
	private UserService userService ;
	private Map<String, Object> session = ServletActionContext.getContext().getSession();
	
	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String userLogin(){
		Userinfo us =	this.userService.searchUser(user.getUserName());
		String MD5Psw = MD5.md5(user.getUserPwd().getBytes());
		if(us == null){
			return ERROR;
		}else if(us.getUserPwd().equals(MD5Psw)){
			session.put("user", user);
			return SUCCESS;
		}else{
			this.user = null;
			session.put("user", user);
			return  ERROR;
		}
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	}
	public String userRegist(){
		user.setUserPwd(MD5.md5(user.getUserPwd().getBytes()));
		user.setRegTime(new Date());
		System.out.println(this.userService);
		if(this.userService.addUser(this.user)){
			session.put("user", this.user);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
