package com.ssdi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.dto.VenueDto;
import com.ssdi.service.VenueService;
import com.ssdi.utils.Constants;

@RequestMapping("/venue")
@RestController
public class VenueController {
	@Autowired
	VenueService venueService;

	@RequestMapping(Constants.GET_USER_BY_ID)
	public VenueDto getVenueById(@PathVariable Integer venueId) {
		return venueService.getVenueById(venueId);
	}
	
	@RequestMapping(Constants.GET_ALL_USERS)
	public List<VenueDto> getAllVenues() {
		return venueService.getAllVenues();
	}
	
	@RequestMapping(value= Constants.SAVE_USER, method= RequestMethod.POST)
	public void saveVenue(@RequestBody VenueDto venueDto) {
		venueService.saveVenue(venueDto);
	}
}
