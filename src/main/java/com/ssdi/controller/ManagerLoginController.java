package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssdi.dto.LoginDto;
import com.ssdi.service.IManagerLoginService;
import com.ssdi.service.IMemberLoginService;
import com.ssdi.utilities.ITokenGenerator;
import com.ssdi.utilities.InvalidTokenException;
import com.ssdi.utilities.TokenGenerator;

public class ManagerLoginController {
	@Autowired
	private IManagerLoginService managerLoginService;
	



	@RequestMapping(method = RequestMethod.GET ,value = "/mgrlogin/{email}/{password}")	
	public LoginDto login(@PathVariable("email") String email,@PathVariable("password") String password)  {
		LoginDto loginDto = new LoginDto();
		Boolean isPrsesnt  = managerLoginService.isValidUser(email);
		//invalid username
		if(!isPrsesnt) {
			//authenticationMessage = "Username Name is not registered";	
			loginDto.setAuthenticationMessage("Username Name is not registered");
		}
		//valid username
		else {
			String fetchedPassword  = managerLoginService.fetchPassword(email);
			//password is not correct
			if(!(fetchedPassword.equals(password))) {
				//authenticationMessage = "Wrong Password Entered";
				loginDto.setAuthenticationMessage("Wrong Password Entered");
			}
			//correct password
			else {
				//generate token 
				ITokenGenerator tokenGenerator = new TokenGenerator();
				String token  = tokenGenerator.genereateToken();
				//insert token
				managerLoginService.saveToken(token, email);
				//return token
				loginDto.setAuthenticationMessage("correct password");
				loginDto.setToken(token);
				//return token;
			}
		}
		//return  authenticationMessage;
		return  loginDto;
	}	
	@RequestMapping(method = RequestMethod.GET ,value = "/mgrlogout/{token}")
	public void logout(@PathVariable("token") String token) throws InvalidTokenException  {
		//if valid token 
		if(managerLoginService.isValidToken(token)) {
			managerLoginService.logout(token);
		}
		//if invalid token throw exception
		else{
			throw new InvalidTokenException("You are not authorized to login");
		}
	}
}
