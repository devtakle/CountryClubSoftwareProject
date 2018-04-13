package com.ssdi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.converter.ActivityConverter;
import com.ssdi.dao.ActivityDao;
import com.ssdi.dto.ActivityDto;
import com.ssdi.model.Activity;
@Service
public class ActivityService implements IActivityService {
	@Autowired
	private ActivityDao activityDao;
	
	public List<ActivityDto> getAllActivities(){
		List<Activity> list = activityDao.findAll();
		List<ActivityDto> result  = ActivityConverter.getDtoList(list);
		return result;
	}

	public void setActivityDao(ActivityDao activityDao2) {
		activityDao = activityDao2;
		
	}

}
