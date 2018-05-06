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
	public TemporaryEventDao getTemporaryEventDao() {
		return temporaryEventDao;
	}
	public void setTemporaryEventDao(TemporaryEventDao temporaryEventDao) {
		this.temporaryEventDao = temporaryEventDao;
	}
	public EventDao getEventDao() {
		return eventDao;
	}
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	public VenueService getVenueService() {
		return venueService;
	}
	public void setVenueService(VenueService venueService) {
		this.venueService = venueService;
	}
	@Autowired
	VenueService venueService;
	public TemporaryEvent addEvent(TemporaryEvent event) {
		return temporaryEventDao.save(event);
	}
	public List<Integer> getEventTimeSlots( String date, int venueId) throws ParseException{
		List<Integer> result = new ArrayList<>();
		List<String> venueTimeSlots = venueService.getVenueTimes(venueId);
		List<Event> events = eventDao.findByDateAndVenueId(date, venueId);
		
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		if(events.size() == 0) {
			for(String time : venueTimeSlots) {
				Date availTime = sdf.parse(time);
					result.add(availTime.getHours());
				
			}
			return result;
		}
		for(Event event : events) {
			Date startTime = sdf.parse(event.getStartAt());
			Date endTime = sdf.parse(event.getEndAt());
			for(String time : venueTimeSlots) {
				Date availTime = sdf.parse(time);
				if(availTime.getHours() < startTime.getHours() || availTime.getHours() >= endTime.getHours()) {
					result.add(availTime.getHours());
				}
			}
		}
		return result;
	}
	
	public List<TemporaryEvent> getAll(){
		return temporaryEventDao.findAll();
	}
	public TemporaryEvent remove(int id) {
		TemporaryEvent event  = temporaryEventDao.findOne(id);
		temporaryEventDao.delete(id);
		return event;
	}
	
	

}
