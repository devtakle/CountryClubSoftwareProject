package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.dto.LoginDto;
import com.ssdi.service.IMemberLoginService;
import com.ssdi.service.MemberLoginService;
import com.ssdi.utilities.ITokenGenerator;
import com.ssdi.utilities.InvalidTokenException;
import com.ssdi.utilities.TokenGenerator;
@CrossOrigin(origins = "*")
@RestController
public class MemberLoginController {
	@Autowired
	private IMemberLoginService memberloginService;
	

	public IMemberLoginService getMemberloginService() {
		return memberloginService;
	}

	public void setMemberloginService(IMemberLoginService memberloginService) {
		this.memberloginService = memberloginService;
	}

	@RequestMapping(method = RequestMethod.GET ,value = "/login/{email}/{password}")	
	public LoginDto login(@PathVariable("email") String email,@PathVariable("password") String password)  {
		LoginDto loginDto = new LoginDto();
		Boolean isPrsesnt  = memberloginService.isValidUser(email);
		//invalid username
		if(!isPrsesnt) {
			//authenticationMessage = "Username Name is not registered";	
			loginDto.setAuthenticationMessage("Username Name is not registered");
		}
		//valid username
		else {
			String fetchedPassword  = memberloginService.fetchPassword(email);
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
				memberloginService.saveToken(token, email);
				//return token
				loginDto.setAuthenticationMessage("correct password");
				loginDto.setToken(token);
				//return token;
			}
		}
		//return  authenticationMessage;
		return  loginDto;
	}	
	
	@RequestMapping(method = RequestMethod.GET ,value = "/logout/{token}")
	public void logout(@PathVariable("token") String token) throws InvalidTokenException  {
		//if valid token 
		if(memberloginService.isValidToken(token)) {
			memberloginService.logout(token);
		}
		//if invalid token throw exception
		else{
			throw new InvalidTokenException("You are not authorized to login");
		}
	}

}
