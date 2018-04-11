package com.ssdi.converter;

import java.util.ArrayList;
import java.util.List;

import com.ssdi.dto.ActivityDto;
import com.ssdi.model.Activity;

<<<<<<< HEAD
public class ActivityConverter {
	public static Activity dtoToEntity(ActivityDto activityDto) {
		Activity activity = new Activity(activityDto.getActivityId(),activityDto.getActivityName());
		return activity;
	}

	public static ActivityDto entityToDto(Activity activity) {
		return new ActivityDto(activity.getActivityId(), activity.getActivityName());
	}
	public static List<ActivityDto> getDtoList(List<Activity> list) {
=======
public class ActivityConverter
{
		public static ActivityDto entityToDto(Activity activity) 
	{
		return new ActivityDto(activity.getId(),activity.getActivity_name(),activity.getCategoryNname().getCategory_name());
	}
	public static List<ActivityDto> getDtoList(List<Activity> list) 
	{
>>>>>>> branch 'master' of git@github.com:devtakle/CountryClubSoftwareProject.git
		List<ActivityDto> result = new ArrayList<>();
		for (Activity a: list) {
			result.add(entityToDto(a));
		}
		return result;
	}
}