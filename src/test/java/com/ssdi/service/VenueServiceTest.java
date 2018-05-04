package com.ssdi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.ssdi.dao.VenueDao;
import com.ssdi.model.Venue;

public class VenueServiceTest {
	@Mock
	VenueDao venueDao;
	Venue venue;
	VenueService service;
	@Before
	public void setUp() {
		venue = new Venue();
		venue.setOpenTime("9:00:00");
		venue.setCloseTime("13:00:00");
		venueDao = mock(VenueDao.class);
		service = new VenueService();
		service.setVenueDao(venueDao);
		when(venueDao.findOne(1)).thenReturn(venue);
		
	
	}
	@Test
	public void getVenueTimesTest() throws ParseException {
		List<String> list = service.getVenueTimes(1);
		assertEquals(list.size(),5);
	}
	
}
