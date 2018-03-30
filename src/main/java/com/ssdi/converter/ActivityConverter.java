package com.ssdi.converter;

import com.ssdi.dto.ActivityDto;
import com.ssdi.model.Activity;

public class ActivityConverter {
	public static Activity dtoToEntity(ActivityDto ActivityDto) {
		Activity activity = new Activity(ActivityDto.getActivityName(), -1);
		activity.setActivityId(ActivityDto.getActivityId());
		return activity;
	}

	public static ActivityDto entityToDto(Activity activity) {
		return new ActivityDto(activity.getActivityId(), activity.getActivityName());
	}
}
