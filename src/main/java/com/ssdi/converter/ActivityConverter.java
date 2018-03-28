package com.ssdi.converter;

import com.ssdi.dto.ActivityDto;
import com.ssdi.entity.Activity;

public class ActivityConverter {
	public static Activity dtoToEntity(ActivityDto ActivityDto) {
		Activity Activity = new Activity(ActivityDto.getActivityName(), null);
		Activity.setActivityId(ActivityDto.getActivityId());
		return Activity;
	}

	public static ActivityDto entityToDto(Activity activity) {
		return new ActivityDto(activity.getActivityId(), activity.getActivityName());
	}
}
