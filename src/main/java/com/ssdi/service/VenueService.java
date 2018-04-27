package com.ssdi.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.VenueDao;
import com.ssdi.model.Venue;
@Service
public class VenueService implements IVenueService {
	@Autowired
	VenueDao venueDao;

	@Override
	public List<String> getVenueTimes(int venue_id) throws ParseException {
		List<String> result = new ArrayList<>();
		Venue venue = venueDao.findOne(venue_id);
		DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		Date openTime = sdf.parse(venue.getOpenTime());
		Date closeTime = sdf.parse(venue.getCloseTime());
		Date time = openTime;
		while (time.getHours() <= closeTime.getHours()) {
			if (time.getHours() == closeTime.getHours() && time.getMinutes() > closeTime.getMinutes()) {
				break;
			}
			result.add(sdf.format(time));
			time.setMinutes(time.getMinutes() + 30);
		}
		return result;
	}
}
