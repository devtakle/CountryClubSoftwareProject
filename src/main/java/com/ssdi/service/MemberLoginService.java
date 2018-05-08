package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ssdi.dao.MemberLoginDao;
import com.ssdi.model.MemberLogin;

@Service
public class MemberLoginService implements IMemberLoginService {
	@Autowired
	private MemberLoginDao memberLoginDAO; 
	@Override
    public void setLoginRepository(MemberLoginDao memberLoginDao) {
    	this.memberLoginDAO = memberLoginDao;
    }
	public String login(String username,String password) {
		
		return"Welcome"+" "+username+"-"+password;
	}
	/*Below function checks is username is present in table*/
	public boolean isValidUser(String username) {
		boolean isPresent = false;
		isPresent = memberLoginDAO.exists(username);
	    return isPresent;
	}
	/*Below function fetches password corresponding to username*/
	public String fetchPassword(String email) {
		String password;
		MemberLogin memberLogin =  memberLoginDAO.findOne(email);
		password = memberLogin.getPassword();
		System.out.println("*** password is "+memberLogin.getPassword());
		return password;
	}
	
	/*Below function saves token for the logged in user*/
	public void  saveToken(String token,String email) {
		MemberLogin memberLogin =  memberLoginDAO.findOne(email);
		memberLogin.setToken(token);
		memberLoginDAO.save(memberLogin);
	}
//	public void logout(String token){
//		MemberLogin memberLogin = new MemberLogin();
//		if(token.equals(memberLoginDAO.findAll().iterator().next().getToken())){
//			memberLogin = memberLoginDAO.findAll().iterator().next();
//			memberLogin.setToken("");
//			memberLoginDAO.save(memberLogin);
//			System.out.println("username-->"+memberLogin.getEmail()+" password--->"+memberLogin.getPassword()+ " token--->"+memberLogin.getToken());
//		}
//	}
	public void logout(String token){
		MemberLogin memberLogin = new MemberLogin();
		memberLogin = memberLoginDAO.findByToken(token);
		memberLogin.setToken("");
		memberLoginDAO.save(memberLogin);
		
	}
	@Override
	public boolean isValidToken(String token) {
		return memberLoginDAO.existsByToken(token);
	}
	@Override
	public int findMemberId(String token) {
		// TODO Auto-generated method stub
		return  memberLoginDAO.findByToken(token).getId();
	}
}
