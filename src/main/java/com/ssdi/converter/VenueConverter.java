package com.ssdi.converter;

import java.util.stream.Collectors;

import com.ssdi.dto.VenueDto;
import com.ssdi.model.Venue;

public class VenueConverter {
	public static Venue dtoToEntity(VenueDto venueDto) {
		Venue venue = new Venue(venueDto.getVenueName());
		venue.setVenueId(venueDto.getVenueId());
		return venue;
	}

	public static VenueDto entityToDto(Venue venue) {
		VenueDto venueDto = new VenueDto(venue.getVenueId(), venue.getVenueName(), null);
		return venueDto;
	}
}
