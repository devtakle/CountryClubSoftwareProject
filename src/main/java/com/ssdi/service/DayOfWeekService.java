package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.DayOfWeekDao;
import com.ssdi.model.DayOfWeek;

@Service
public class DayOfWeekService {
	@Autowired
	DayOfWeekDao dayDao;
	public DayOfWeek findById(int id) {
		return dayDao.findOne(id);
	}
}
