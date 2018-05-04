package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.EventDao;
import com.ssdi.model.Event;

@Service
public class EventService {
	@Autowired
	EventDao eventDao;
	public void addEvent(Event event) {
		eventDao.save(event);
	}

}
