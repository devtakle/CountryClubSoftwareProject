package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.ManagerLoginDao;
import com.ssdi.dao.MemberLoginDao;
import com.ssdi.model.ManagerLogin;
import com.ssdi.model.MemberLogin;

@Service
public class ManagerLoginService implements IManagerLoginService {
	@Autowired
	private ManagerLoginDao managerLoginDAO; 
	@Override
    public void setLoginRepository(ManagerLoginDao managerLoginDao) {
    	this.managerLoginDAO = managerLoginDao;
    }
	public String login(String username,String password) {
		
		return"Welcome"+" "+username+"-"+password;
	}
	/*Below function checks is username is present in table*/
	public boolean isValidUser(String username) {
		boolean isPresent = false;
		isPresent = managerLoginDAO.exists(username);
	    return isPresent;
	}
	/*Below function fetches password corresponding to username*/
	public String fetchPassword(String email) {
		String password;
		ManagerLogin managerLogin =  managerLoginDAO.findOne(email);
		password = managerLogin.getPassword();
		System.out.println("*** password is "+managerLogin.getPassword());
		return password;
	}
	
	/*Below function saves token for the logged in user*/
	public void  saveToken(String token,String email) {
		ManagerLogin managerLogin =  managerLoginDAO.findOne(email);
		managerLogin.setToken(token);
		managerLoginDAO.save(managerLogin);
	}
//	public void logout(String token){
//		ManagerLogin managerLogin = new ManagerLogin();
//		if(token.equals(managerLoginDAO.findAll().iterator().next().getToken())){
//			managerLogin = managerLoginDAO.findAll().iterator().next();
//			managerLogin.setToken("");
//			managerLoginDAO.save(managerLogin);
//			System.out.println("username-->"+managerLogin.getEmail()+" password--->"+managerLogin.getPassword()+ " token--->"+managerLogin.getToken());
//		}
//	}
	public void logout(String token){
		ManagerLogin managerLogin = new ManagerLogin();
		managerLogin = managerLoginDAO.findByToken(token);
		managerLogin.setToken("");
		managerLoginDAO.save(managerLogin);
		
	}
	@Override
	public boolean isValidToken(String token) {
		return managerLoginDAO.existsByToken(token);
	}
	
}
