package com.ssdi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.converter.ActivityScheduleConverter;
import com.ssdi.dao.ActivityScheduleDao;
import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.model.ActivitySchedule;
@Service("actScheduleService")
public class ActivityScheduleService implements IActivityScheduleService {
	@Autowired
    ActivityScheduleDao activityScheduleDao;
	@Override
	public List<ActivityScheduleDto> getByActivityId(int activity_id) {
		List<ActivitySchedule> list = activityScheduleDao.findByActivityId(activity_id);
		List<ActivityScheduleDto> result = ActivityScheduleConverter.getDtoList(list);
		return result;
		
	}

}
