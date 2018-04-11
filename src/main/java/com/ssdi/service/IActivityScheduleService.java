package com.ssdi.service;

import java.util.List;

import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.model.ActivitySchedule;

public interface IActivityScheduleService {
	public List<ActivityScheduleDto> getByActivityId(int activity_id);

}
