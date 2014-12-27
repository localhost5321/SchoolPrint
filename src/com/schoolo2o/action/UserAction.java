package com.schoolo2o.action;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.service.UserService;
import com.schoolo2o.utils.MD5;

public class UserAction extends ActionSupport{
	
	private Userinfo user ;
	private UserService userService ;
	private Map<String, Object> session = ServletActionContext.getContext().getSession();
	private Logger log = Logger.getLogger(UserAction.class);
	
	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
		log.info(user.toString());
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String userLogin() throws IOException{
		Userinfo us =	this.userService.searchUser(user.getUserName());
		String MD5Psw = MD5.md5(user.getUserPwd().getBytes());
		if(us == null){
			ServletActionContext.getResponse().getWriter().write("0");
			return null;
		}else if(us.getUserPwd().equals(MD5Psw)){
			session.put("user", user);
			ServletActionContext.getResponse().getWriter().write("1");
			return null;
		}else{
			this.user = null;
			ServletActionContext.getResponse().getWriter().write("0");
			session.put("user", user);
			return  null;
		}
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	}
	public String userRegist() throws IOException{
		user.setUserPwd(MD5.md5(user.getUserPwd().getBytes()));
		user.setRegTime(new Date());
//		System.out.println(this.user);
		if(this.userService.addUser(this.user)){
			session.put("user", this.user);
			ServletActionContext.getResponse().getWriter().write("1");
			return null;
		}else{
			return ERROR;
		}
	}
	/**
	 * 验证用户的邮箱是否已经注册过
	 * @param email
	 * @return　若注册过，则返回false,否则为true
	 */
	public String verifyEmail(String email){
		if(this.userService.checkEmail(email)){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	/**
	 * 用户注册时的用户名验证
	 * @param userName　 用户名
	 * @return　没有存在的，返回SUCCESS, 若存在，返回ERROR
	 */
	public String verifyUserName(String userName){
		Userinfo user = this.userService.searchUser(userName);
		if(user == null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
