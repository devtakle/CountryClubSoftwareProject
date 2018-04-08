package com.ssdi.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ssdi.model.Activity;
import com.ssdi.model.Venue;

public class ActivityScheduleDto {
	private int id, day_of_week;
	private String start_at, venue_name, activity_name;
    private String end_at;
    public ActivityScheduleDto(int id,  String venue_name, String activity_name,
    		int day_of_week, String start_at,String end_at) {
		super();
		this.id = id;
		this.day_of_week = day_of_week;
		this.start_at = start_at;
		this.venue_name = venue_name;
		this.activity_name = activity_name;
		this.end_at = end_at;
	}
	public int getId() {
		return id;
	}
	public int getDay_of_week() {
		return day_of_week;
	}
	public String getStart_at() {
		return start_at;
	}
	public String getVenue_name() {
		return venue_name;
	}
	public String getActivitiy_name() {
		return activity_name;
	}
	public String getEnd_at() {
		return end_at;
	}
	
	
	

}
