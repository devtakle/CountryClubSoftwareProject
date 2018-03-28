package com.ssdi.converter;

import java.util.stream.Collectors;

import com.ssdi.dto.VenueDto;
import com.ssdi.entity.Venue;

public class VenueConverter {
	public static Venue dtoToEntity(VenueDto venueDto) {
		Venue venue = new Venue(venueDto.getVenueName(), null);
		venue.setVenueId(venueDto.getVenueId());
		venue.setActivitys(venueDto.getActivityDtos().stream().map(ActivityConverter::dtoToEntity).collect(Collectors.toList()));
		return venue;
	}

	public static VenueDto entityToDto(Venue venue) {
		VenueDto venueDto = new VenueDto(venue.getVenueId(), venue.getVenueName(), null);
		venueDto.setActivityDtos(venue.getActivitys().stream().map(ActivityConverter::entityToDto).collect(Collectors.toList()));
		return venueDto;
	}
}
