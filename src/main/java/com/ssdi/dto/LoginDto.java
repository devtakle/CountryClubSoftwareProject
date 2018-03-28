package com.ssdi.dto;

public class LoginDto {
private String authenticationMessage;
private String token;
public String getAuthenticationMessage() {
	return authenticationMessage;
}
public void setAuthenticationMessage(String authenticationMessage) {
	this.authenticationMessage = authenticationMessage;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}

}
