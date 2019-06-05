package com.bny.dto;

public class User {
	
	private String userKey;
	private String id;
	private String password;
	private String name;
	private String email;
	private String address;
	private char userType;	
	private char userClass;
	private String joinType;
	private String regDate;
		
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public char getUserType() {
		return userType;
	}
	public void setUserType(char userType) {
		this.userType = userType;
	}
	public char getUserClass() {
		return userClass;
	}
	public void setUserClass(char userClass) {
		this.userClass = userClass;
	}
	public String getJoinType() {
		return joinType;
	}
	public void setJoinType(String joinType) {
		this.joinType = joinType;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
