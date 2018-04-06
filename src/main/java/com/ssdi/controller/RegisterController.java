package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.model.MemberLogin;
import com.ssdi.service.IRegisterService;
import com.ssdi.utilities.InvalidIdOrEmailException;
@CrossOrigin(origins = "*")
@RestController
public class RegisterController {
	@Autowired
    private IRegisterService registerService;
	
	public void setRegisterService(IRegisterService registerService) {
		this.registerService = registerService;
	}

	@RequestMapping(value ="/register",method= RequestMethod.POST)
	public @ResponseBody MemberLogin registerMember(@RequestBody MemberLogin memberLogin) throws InvalidIdOrEmailException {
		System.out.println(memberLogin.getId()+", "+memberLogin.getEmail());
		if(registerService.exists(memberLogin)) {
			memberLogin.setId(-99);
		}
		else if(!registerService.validate(memberLogin)) {
			memberLogin.setId(-9999);
		}
		else {
			registerService.save(memberLogin);
		}
		return memberLogin;
		
	
	}
}
