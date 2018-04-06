package com.ssdi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.service.IActivityScheduleService;
import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.model.ActivitySchedule;
@CrossOrigin(origins = "*")
@RestController
public class ActivityController {
	@Autowired
	private IActivityScheduleService actScheduleService;
	
	public void setActScheduleService(IActivityScheduleService actScheduleService) {
		this.actScheduleService = actScheduleService;
	}
	@RequestMapping(value="activities/{activity_id}",method = RequestMethod.GET,produces="application/json")
	public List<ActivitySchedule> getDetailsById(@PathVariable("activity_id") int activity_id){
		return actScheduleService.getByActivityId(activity_id);
	
	}
	

}
