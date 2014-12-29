package com.schoolo2o.action;

import java.io.IOException;
import java.sql.Timestamp;
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
		//设置响应体的格式
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		Userinfo us = this.userService.searchUser(user.getUserName());
		String MD5Psw = MD5.md5(user.getUserPwd().getBytes());
		if(us == null){
			//返回一段json数据
			response.getWriter().write("{\"status\":\"0\",\"message\":\"用户名不存在\"}");
			return null;
		}else if(us.getUserPwd().equals(MD5Psw)){
			session.put("user", user);
			String userInfo = "<li><a href='javascript:void(0)' class='dropdown-toggle' data-toggle='dropdown'>欢迎你："+user.getUserName()+"<span class='caret'></span></a><ul class='dropdown-menu' role='menu'><li><a href='javascript:void(0)' data-tab='tab-chrome' onclick='exit();'>退出</a></li></ul></li>";
			response.getWriter().write("{\"status\":\"1\",\"message\":\""+userInfo+"\"}");
			return null;
		}else{
			this.user = null;
			response.getWriter().write("{\"status\":\"0\",\"message\":\"密码错误\"}");
			session.put("user", user);
			return null;
		}
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	}
	public String userRegist() throws IOException{
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		user.setUserPwd(MD5.md5(user.getUserPwd().getBytes()));
		user.setRegTime(new Timestamp(new Date().getTime()));
		user.setEmailChecked(0);
		if(this.userService.addUser(this.user)){
			session.put("user", this.user);
			String userInfo = "<li><a href='javascript:void(0)' class='dropdown-toggle' data-toggle='dropdown'>欢迎你："+user.getUserName()+"<span class='caret'></span></a><ul class='dropdown-menu' role='menu'><li><a href='javascript:void(0)' data-tab='tab-chrome' onclick='exit();'>退出</a></li></ul></li>";
			response.getWriter().write("{\"status\":\"1\",\"message\":\""+ userInfo +"\"}");
			return null;
		}else{
			response.getWriter().write("{\"status\":\"0\",\"message\":\"\"}");
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
		String userName = ServletActionContext.getRequest().getParameter("userName");
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		Userinfo user = this.userService.searchUser(userName);
		if(user == null){
			response.getWriter().write("{\"status\":\"1\",\"message\":\"\"}");
			return null;
		}else{
			response.getWriter().write("{\"status\":\"0\",\"message\":\"用户名已存在\"}");
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
