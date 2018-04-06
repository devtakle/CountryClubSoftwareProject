package com.ssdi.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ssdi.model.Activity;
import com.ssdi.model.Venue;

public class ActivityScheduleDto {
	private int id, venue_id, activity_id, day_of_week;
    private String start_at;
    private String end_at;
	public ActivityScheduleDto(int id, int venue_id, int activity_id, int day_of_week, String start_at, String end_at) {
		super();
		this.id = id;
		this.venue_id = venue_id;
		this.activity_id = activity_id;
		this.day_of_week = day_of_week;
		this.start_at = start_at;
		this.end_at = end_at;
	}


}
