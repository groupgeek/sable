package com.xiaohe.bean;

public class MessageCustom extends Message {

private String username;
	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "MessageCustom [username=" + username + "]";
	}
	
}
