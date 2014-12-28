package com.schoolo2o.action;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
	private HttpServletResponse response = ServletActionContext.getResponse();
	
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
		response.setContentType("text/plain");  //设置响应体的格式
		Userinfo us = this.userService.searchUser(user.getUserName());
		String MD5Psw = MD5.md5(user.getUserPwd().getBytes());
		if(us == null){
			//返回一段json数据
			response.getWriter().write("{status:0,message:}");
			return null;
		}else if(us.getUserPwd().equals(MD5Psw)){
			session.put("user", user);
			response.getWriter().write("{status:'1',message:''}");
			return null;
		}else{
			this.user = null;
			response.getWriter().write("{status:'0',message:''}");
			session.put("user", user);
			return null;
		}
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	}
	public String userRegist() throws IOException{
		response.setContentType("text/plain");
		user.setUserPwd(MD5.md5(user.getUserPwd().getBytes()));
		user.setRegTime(new Date());
		if(this.userService.addUser(this.user)){
			session.put("user", this.user);
			response.getWriter().write("{status:'1',message:''}");
			return null;
		}else{
			response.getWriter().write("{status:'0',message:'注册失败'}");
			return null;
		}
	}
	/**
	 * 验证用户的邮箱是否已经注册过
	 * @param email
	 * @return　若注册过，则返回false,否则为true
	 * @throws IOException 
	 */
	public String verifyEmail(String email) throws IOException{
		if(this.userService.checkEmail(email)){
			response.getWriter().write("{status:'1',message:''}");
			return null;
		}
		else{
			response.getWriter().write("{status:'0',message:''}");
			return null;
		}
	}
	/**
	 * 用户注册时的用户名验证
	 * @param userName　 用户名
	 * @return　没有存在的，返回SUCCESS, 若存在，返回ERROR
	 * @throws IOException 
	 */
	public String verifyUserName() throws IOException{
		String userName = null;
		response.setContentType("text/plain");
		Userinfo user = this.userService.searchUser(userName);
		if(user == null){
			response.getWriter().write("{status:'1',message:''}");
			return null;
		}else{
			response.getWriter().write("{status:'0',message:'用户名已存在'}");
			return null;
		}
	}
	/**
	 * 用于退出用户登陆
	 * @return
	 */
	public String exit(){
		session.clear();
		user=null;
		return null;
	}
}
