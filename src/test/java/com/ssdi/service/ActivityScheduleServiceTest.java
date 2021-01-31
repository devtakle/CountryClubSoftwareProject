package com.ssdi.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdi.converter.ActivityConverter;
import com.ssdi.converter.ActivityScheduleConverter;
import com.ssdi.dao.ActivityScheduleDao;
import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.model.Activity;
import com.ssdi.model.ActivitySchedule;
import com.ssdi.model.DayOfWeek;
import com.ssdi.model.Venue;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ActivityScheduleServiceTest {
	@Mock
    ActivityScheduleDao activityScheduleDao;
	ActivityScheduleService service;
	List<ActivityScheduleDto> result;
	ActivityScheduleConverter as;
	@Before
	public void setup() {
		service = new ActivityScheduleService();
		activityScheduleDao = mock(ActivityScheduleDao.class);
		service.setActivityScheduleDao(activityScheduleDao);
		List<ActivitySchedule> list = new ArrayList<>();
		ActivitySchedule aS = new ActivitySchedule();
		aS.setId(5);
		Activity a = new Activity();
		Venue v = new Venue();
		a.setId(3);
		aS.setVenue(v);
		DayOfWeek dayOfWeek = new DayOfWeek();
		aS.setDay(dayOfWeek);
		aS.setActivity(a);
		list.add(aS);
		ActivityScheduleDto dto = new ActivityScheduleDto(5, "", "", "", "", "");
		result = new ArrayList<>();
		result.add(dto);  
		when(activityScheduleDao.findByActivityId(3)).thenReturn(list);
		
	}
	
	@Test
	public void testGetByActivityId() {
		List<ActivityScheduleDto> result_test = service.getByActivityId(3);
		assertEquals(5, result_test.get(0).getId());
	}
}
