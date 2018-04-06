package com.ssdi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.service.IActivityScheduleService;
import com.ssdi.service.IMemberLoginService;
import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.model.ActivitySchedule;
@CrossOrigin(origins = "*")
@RestController
public class ActivityController {
	@Autowired
	private IActivityScheduleService actScheduleService;
	@Autowired
	private IMemberLoginService memberLoginService;

	public void setMemberLoginService(IMemberLoginService memberLoginService) {
		this.memberLoginService = memberLoginService;
	}
	public void setActScheduleService(IActivityScheduleService actScheduleService) {
		this.actScheduleService = actScheduleService;
	}
	@RequestMapping(value="activities/{activity_id}/{token}",method = RequestMethod.GET,produces="application/json")
	public List<ActivitySchedule> getDetailsById(@PathVariable("activity_id") int activity_id,@PathVariable("token") String token){
		if(memberLoginService.isValidToken(token)) {
			return actScheduleService.getByActivityId(activity_id);
		}
		else {
			System.out.println("null");
			return null;
		}
	
	}
	

}
