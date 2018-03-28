package com.ssdi.service;

import java.util.List;

import com.ssdi.dto.VenueDto;

public interface VenueService {
    VenueDto getVenueById(Integer venueId);
    void saveVenue(VenueDto venueDto);
    List<VenueDto> getAllVenues();
}
