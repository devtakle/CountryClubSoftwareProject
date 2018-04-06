package com.ssdi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MemberLogin {
	
	@Column(name = "id")
	private int id;
	@Id
	@Column(name = "email")
	private String email;
	@Column(name = "pass")
	private String pass;
	@Column(name = "token")
	private String token;
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return pass;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setPassword(String password) {
		this.pass = password;
	}

}
