package com.bridgePhone.model;

public class Owner {
	private int id;
	private String fullname;
	private String username;
	private String password;
	private String confirmPassword;
	
	
	
	public Owner() {
		super();
	}
	
	
	
	
	public Owner(int id, String fullname, String username, String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		
	}




	public Owner(String fullname, String username, String password) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
