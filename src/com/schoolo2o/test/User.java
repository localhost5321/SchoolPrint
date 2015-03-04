package com.schoolo2o.test;

public class User {

	String userName;
	String userAge;

	public User(){
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(String userName, String userAge) {
		super();
		this.userName = userName;
		this.userAge = userAge;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
}
