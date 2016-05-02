package com.schoolo2o.test;

import java.util.HashSet;
import java.util.Set;

public class Clazz{
	
	Set<User> users = new HashSet<User>(0);
	String clazzName;
	
	public Clazz(){
		
	}
	
	public Clazz(Set<User> users, String clazzName) {
		super();
		this.users = users;
		this.clazzName = clazzName;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	
}