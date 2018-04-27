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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.model.MemberLogin;
import com.ssdi.model.TemporaryEvent;
import com.ssdi.service.MemberLoginService;
import com.ssdi.service.TemporaryEventService;
import com.ssdi.service.VenueService;
import com.ssdi.utilities.NotLoggedInException;
@CrossOrigin(origins = "*")
@RestController
public class EventController {
	@Autowired
	VenueService venueService;
	@Autowired
	TemporaryEventService tempService;
	@Autowired
	MemberLoginService memberLoginService; 

	@RequestMapping(value ="/tempEventAdd",method= RequestMethod.POST)
	public TemporaryEvent addTemporaryEvent(@RequestBody TemporaryEvent temporaryEvent, 
			@RequestHeader(value="token") String token) throws NotLoggedInException {
		if(memberLoginService.isValidToken(token)) {
		return tempService.addEvent(temporaryEvent);
		}
		else {
			throw new NotLoggedInException("You are not logged in");
		}
	}
	@RequestMapping(value ="/tempEventAdd/{date}/{venueId}",method= RequestMethod.GET)
	public List<Integer> getEventTimeSlots(@PathVariable("date")String date, 
			@PathVariable("venueId")int venueId, @RequestHeader(value="token") String token) throws ParseException, NotLoggedInException{
		if(memberLoginService.isValidToken(token)) {
			System.out.println("Entered Controller");
			List<Integer> timeSlots = tempService
					.getEventTimeSlots(venueService.getVenueTimes(venueId), date, venueId);
			return timeSlots;
			}
			else {
				throw new NotLoggedInException("You are not logged in");
			}
		
		
	}
	
	

}
