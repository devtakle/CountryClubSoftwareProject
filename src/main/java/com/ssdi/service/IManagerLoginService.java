package com.ssdi.service;

import com.ssdi.dao.ManagerLoginDao;
import com.ssdi.dao.MemberLoginDao;
import com.ssdi.utilities.InvalidTokenException;

public interface IManagerLoginService {

	boolean isValidUser(String username);

	String fetchPassword(String username);


	void saveToken(String token, String username);

	void logout(String token) ;
	
	boolean isValidToken(String token);

	void setLoginRepository(ManagerLoginDao managerLoginDao);
	

	
}
