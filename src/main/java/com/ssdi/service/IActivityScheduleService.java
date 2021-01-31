package com.ssdi.service;

import java.text.ParseException;
import java.util.List;

import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.model.ActivitySchedule;

public interface IActivityScheduleService {
	public List<ActivityScheduleDto> getByActivityId(int activity_id);
	public boolean checkAvailability(int dayId,String startAt, String endAt);
	List<Integer> getActivityTimeSlots(int day, int venueId) throws ParseException;
	void save(ActivitySchedule activitySchedule);
	

}
