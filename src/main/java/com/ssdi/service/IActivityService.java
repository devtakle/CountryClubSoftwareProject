package com.ssdi.service;
import java.util.List;

import com.ssdi.dto.ActivityDto;
import com.ssdi.model.Activity;
public interface IActivityService {
	public List<ActivityDto> getAllActivities();

	Activity findById(int id);

}
