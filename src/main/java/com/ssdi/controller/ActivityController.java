package com.ssdi.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.service.DayOfWeekService;
import com.ssdi.service.IActivityScheduleService;
import com.ssdi.service.IActivityService;
import com.ssdi.service.IManagerLoginService;
import com.ssdi.service.IMemberLoginService;
import com.ssdi.service.VenueService;
import com.ssdi.utilities.NotLoggedInException;
import com.ssdi.dto.ActivityDto;
import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.model.ActivitySchedule;
@CrossOrigin(origins = "*")
@RestController
public class ActivityController {
	@Autowired
	private IActivityScheduleService actScheduleService;
	@Autowired
	private IMemberLoginService memberLoginService;
	@Autowired
	private IActivityService activityService;
	@Autowired
	IManagerLoginService managerLoginService;
	@Autowired
	DayOfWeekService dayOfWeekService;
	@Autowired
	VenueService venueService;


	public void setMemberLoginService(IMemberLoginService memberLoginService) {
		this.memberLoginService = memberLoginService;
	}
	public void setActScheduleService(IActivityScheduleService actScheduleService) {
		this.actScheduleService = actScheduleService;
	}
	@RequestMapping(value="activities/{activity_id}",method = RequestMethod.GET,produces="application/json")
	public List<ActivityScheduleDto> getDetailsById(@PathVariable("activity_id") int activity_id,@RequestHeader("token") String token){
	
		if(memberLoginService.isValidToken(token)) {
			return actScheduleService.getByActivityId(activity_id);
		}
		else {
			System.out.println("null");
			return null;
		}
	}
	@RequestMapping(value="activities",method = RequestMethod.GET,produces="application/json")
	public List<ActivityDto> getAllActivities(@RequestHeader(value="token") String token) throws NotLoggedInException{
		
		if(memberLoginService.isValidToken(token)) {
			return activityService.getAllActivities();
		}
		else {
			throw new NotLoggedInException("You are not logged in");
		}
	}
	@RequestMapping(value="activities/{day}/{venue}",method = RequestMethod.GET)
	public List<Integer> getAllActivityTimeSlots(@RequestHeader(value="token") 
	String token,@PathVariable("day") int dayId,@PathVariable("venue") int venueId) throws ParseException, NotLoggedInException{
		System.out.println("entered valid token");
		if(managerLoginService.isValidToken(token)) {
			System.out.println("entered valid token");
			return actScheduleService.getActivityTimeSlots(dayId, venueId);
		}
		else {
			throw new NotLoggedInException("You are not logged in");
		}
	}
	@RequestMapping(value="addActivitySchedule/{dayId}/{venueId}/{activityId}",method = RequestMethod.POST)
	public void addActivitySchedule(@PathVariable(value="dayId") int dayId,@PathVariable(value="venueId") int venueId,
			@PathVariable(value="activityId") int actId,@RequestBody ActivitySchedule activitySchedule, @RequestHeader("token") String token) throws NotLoggedInException{
		if(managerLoginService.isValidToken(token)) {
			System.out.println(activitySchedule.getEnd_at());
			activitySchedule.setDay(dayOfWeekService.findById(dayId));
			activitySchedule.setVenue(venueService.findById(venueId));
			activitySchedule.setActivity(activityService.findById(actId));
			activitySchedule.setActivity_capacity(0);
			actScheduleService.save(activitySchedule);
		}
		else {
			throw new NotLoggedInException("You are not logged in");
		}
	}
	public IActivityService getActivityService() {
		return activityService;
	}
	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}


}
