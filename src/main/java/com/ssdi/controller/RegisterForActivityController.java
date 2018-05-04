package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.dto.RegisterForActivityDto;
import com.ssdi.service.IRegisterForActivityService;

@CrossOrigin(origins = "*")
@RestController
public class RegisterForActivityController {
	@Autowired
	IRegisterForActivityService registerForActivityService; 
	@RequestMapping(method = RequestMethod.GET ,value = "/registerMember/{activityScheduleId}/{token}")
	public RegisterForActivityDto registerMember(@PathVariable("activityScheduleId") int activityScheduleId,@PathVariable("token") String token) {
		System.out.println("***********activityID---> "+activityScheduleId+"token--->"+token);
		int memberId;
		RegisterForActivityDto registerForActivityDto = new RegisterForActivityDto();
		/*fetch memberId from login table*/ 
		memberId = registerForActivityService.fetchMemberId(token);
		System.out.println("*********memberID "+memberId);
		/*invalid token*/
		if(memberId == 0) {
			registerForActivityDto.setRegistrationMessage("You don't have permission to carry out this task");
			return registerForActivityDto;
		}
		//System.out.println("Inside controller value of memberId--->"+memberId);
		/*check if member already registered*/
		if(registerForActivityService.ifMemberAlreadyRegistered(activityScheduleId,memberId)) {
			System.out.println("member already registered");
			registerForActivityDto.setRegistrationMessage("You are already registered for this activity");
			return registerForActivityDto;
		}
		/*checks if space left*/
		if(registerForActivityService.isActivityFull(activityScheduleId)) {
			registerForActivityDto.setRegistrationMessage("No space left for this activity");
			return registerForActivityDto;
		}
		/*member is not already registered and activity not full*/
		registerForActivityService.confirmRegistration(activityScheduleId,memberId);
		registerForActivityDto.setRegistrationMessage("You are registered for the activity");
		return registerForActivityDto;
	}
	@RequestMapping(method = RequestMethod.GET ,value = "/hello")
	public String test() {
		return "Hello";
	}
}
