package com.ssdi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssdi.dao.EventDao;
import com.ssdi.dao.TemporaryEventDao;
import com.ssdi.model.Event;
import com.ssdi.model.TemporaryEvent;

public class TemporaryEventServiceTest {
	@Mock
	TemporaryEventDao temporaryEventDao;
	@Mock
	EventDao eventDao;
	@Mock
	VenueService venueService;
	private TemporaryEventService service;
	String date;int venueId;
	@Before
	public void setUp() throws ParseException {
		temporaryEventDao= mock(TemporaryEventDao.class);
		 venueService= mock(VenueService.class);
		 eventDao= mock(EventDao.class);
		 service = new TemporaryEventService();
		 service.setEventDao(eventDao);
		 service.setVenueService(venueService);
		 service.setTemporaryEventDao(temporaryEventDao);
		 Event event = new Event();
		 event.setStartAt("12:00:00");
		 event.setEndAt("13:00:00");
		 date = "2018-02-03";
		 venueId = 5;
		 List<Event> events = new ArrayList<>();
		 List<String> venueTimes = new ArrayList<>();
		 venueTimes.add("9:00:00");
		 venueTimes.add("10:00:00");
		 venueTimes.add("11:00:00");
		 venueTimes.add("12:00:00");
		 venueTimes.add("13:00:00");
		 venueTimes.add("14:00:00");
		 venueTimes.add("15:00:00");
		 events.add(event);
		 when(venueService.getVenueTimes(venueId)).thenReturn(venueTimes);
		 when(eventDao.findByDateAndVenueId(date, venueId)).thenReturn(events);
		 
		
	}
	@Test
	public void getEventTimes() throws ParseException {
		List<Integer> list = service.getEventTimeSlots(date, venueId);
		assertEquals(list.size(),6);
	}
	@Test
	public void addTempEventTest() {
		TemporaryEvent event = new TemporaryEvent();
		event.setName("tournament");
		when(temporaryEventDao.save(event)).thenReturn(event);
		assertEquals(event.getName(), service.addEvent(event).getName());
	}
}
