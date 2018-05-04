package com.ssdi.service;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.converter.ActivityScheduleConverter;
import com.ssdi.dao.ActivityScheduleDao;
import com.ssdi.dao.VenueDao;
import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.model.ActivitySchedule;
import com.ssdi.model.DayOfWeek;
import com.ssdi.model.Event;
import com.ssdi.model.Venue;
@Service("actScheduleService")
public class ActivityScheduleService implements IActivityScheduleService {
	@Autowired
    ActivityScheduleDao activityScheduleDao;
	ActivityScheduleConverter conv;
	@Autowired
	VenueService venueService;
	@Autowired
	DayOfWeekService dayofweekService;

	public void setConv(ActivityScheduleConverter conv) {
		this.conv = conv;
	}

	public void setActivityScheduleDao(ActivityScheduleDao activityScheduleDao) {
		this.activityScheduleDao = activityScheduleDao;
	}

	@Override
	public List<ActivityScheduleDto> getByActivityId(int activity_id) {
		conv = new ActivityScheduleConverter();
		List<ActivitySchedule> list = activityScheduleDao.findByActivityId(activity_id);
		List<ActivityScheduleDto> result = ActivityScheduleConverter.getDtoList(list);
		return result;
		
	}

	@Override
	public boolean checkAvailability(int dayId, String startAt, String endAt) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Integer> getActivityTimeSlots( int day, int venueId) throws ParseException{
		List<Integer> result = new ArrayList<>();
		List<String> venueTimeSlots = venueService.getVenueTimes(venueId);
		DayOfWeek dayWeek = dayofweekService.findById(day);
		List<ActivitySchedule> activities = activityScheduleDao.findByDayAndVenueId(dayWeek, venueId); 
		
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		for(ActivitySchedule act : activities) {
			Date startTime = sdf.parse(act.getStart_at());
			Date endTime = sdf.parse(act.getEnd_at());
			for(String time : venueTimeSlots) {
				Date availTime = sdf.parse(time);
				if(availTime.getHours() < startTime.getHours() || availTime.getHours() >= endTime.getHours()) {
					result.add(availTime.getHours());
				}
			}
		}
		return result;
	}
	@Override
	public void save(ActivitySchedule activitySchedule) {
		activityScheduleDao.save(activitySchedule);
		
	}
		
	
	

}
