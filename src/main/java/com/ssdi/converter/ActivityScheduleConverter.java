package com.ssdi.converter;

import java.util.ArrayList;
import java.util.List;

import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.model.ActivitySchedule;

public class ActivityScheduleConverter {

	public static ActivityScheduleDto entityToDto(ActivitySchedule actSch) {
		return new ActivityScheduleDto(actSch.getId(),actSch.getVenue().getVenueName(),actSch.getActivity().getActivity_name(), actSch.getDayOfWeek().getDay_of_week(), actSch.getStart_at(),actSch.getEnd_at());
	}
	public static List<ActivityScheduleDto> getDtoList(List<ActivitySchedule> list){
		List<ActivityScheduleDto> result = new ArrayList<>();
		for(ActivitySchedule aS: list) {
			System.out.println("Demo "+aS.getActivity().getActivity_name());
			result.add(entityToDto(aS));
		}
		return result;
	}

}
