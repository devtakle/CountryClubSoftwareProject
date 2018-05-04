package com.ssdi.service;

import java.text.ParseException;
import java.util.List;

public interface IVenueService {
	public List<String> getVenueTimes(int venue_id) throws ParseException;
}
