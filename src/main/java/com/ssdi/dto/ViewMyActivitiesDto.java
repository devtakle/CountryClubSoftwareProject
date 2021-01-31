package com.ssdi.dto;

import java.util.List;

public class ViewMyActivitiesDto {
	private String message;
	private List<ActivityScheduleDto>  activityScheduleDtoList;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ActivityScheduleDto> getActivityScheduleDtoList() {
		return activityScheduleDtoList;
	}
	public void setActivityScheduleDtoList(List<ActivityScheduleDto> activityScheduleDtoList) {
		this.activityScheduleDtoList = activityScheduleDtoList;
	}
	
}
