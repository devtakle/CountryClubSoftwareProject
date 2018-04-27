package com.ssdi.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.EventDao;
import com.ssdi.dao.TemporaryEventDao;
import com.ssdi.model.Event;
import com.ssdi.model.TemporaryEvent;

@Service
public class TemporaryEventService {
	@Autowired
	TemporaryEventDao temporaryEventDao;
	@Autowired
	EventDao eventDao;
	
	public TemporaryEvent addEvent(TemporaryEvent event) {
		return temporaryEventDao.save(event);
	}
	public List<String> getEventTimeSlots(List<String> venueTimeSlots, String date) throws ParseException{
		List<String> result = new ArrayList<>();
		List<Event> events = eventDao.findByDate(date);
		DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		for(Event event : events) {
			Date startTime = sdf.parse(event.getStartAt());
			Date endTime = sdf.parse(event.getEndAt());
			for(String time : venueTimeSlots) {
				Date availTime = sdf.parse(time);
				if(!(availTime.getHours() > startTime.getHours() && availTime.getHours() < endTime.getHours())) {
					result.add(sdf.format(availTime));
				}
			}
		}
		return result;
		
	    
		
		
	}
	
	

}
