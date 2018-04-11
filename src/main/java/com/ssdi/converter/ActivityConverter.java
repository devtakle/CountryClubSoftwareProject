package com.ssdi.converter;

import java.util.ArrayList;
import java.util.List;

import com.ssdi.dto.ActivityDto;
import com.ssdi.model.Activity;

public class ActivityConverter
{
		public static ActivityDto entityToDto(Activity activity) 
	{
		return new ActivityDto(activity.getId(),activity.getActivity_name());
	}
	public static List<ActivityDto> getDtoList(List<Activity> list) 
	{
		List<ActivityDto> result = new ArrayList<>();
		for (Activity a: list) {
			result.add(entityToDto(a));
		}
		return result;
	}
}