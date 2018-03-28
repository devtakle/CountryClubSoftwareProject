package com.ssdi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ssdi.dao.VenueRepository;
import com.ssdi.model.Activity;
import com.ssdi.model.Venue;



@SpringBootApplication
public class DemoApplication {

	@Autowired
	VenueRepository venueRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	public void setupDbWithData(){
		Venue venue= new Venue("Gold", null);
		venue.setActivitys(Arrays.asList(new Activity(""), new Activity("js")));
		venue= venueRepository.save(venue);
	
}
}
