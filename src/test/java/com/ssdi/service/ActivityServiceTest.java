package com.ssdi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ssdi.dao.ActivityDao;
import com.ssdi.dto.ActivityDto;
import com.ssdi.model.Activity;
import com.ssdi.model.Category;

@RunWith(SpringJUnit4ClassRunner.class)
public class ActivityServiceTest 

{


	 List<ActivityDto> activity;


	    private ActivityService actService;
	    private ActivityDao activityDao;
	    private List<Activity> list;
	    private Activity a1;
	    private Category ct;

	    @Before
	    public void init()
	    {
	    	activityDao = mock(ActivityDao.class);
	    	actService = new ActivityService();
	    	actService.setActivityDao(activityDao);
	        list = new ArrayList<>();
	        a1 = new Activity();
	        a1.setId(0);
	        a1.setActivity_name("Badminton");
	        a1.setCategoryNname(new Category());
	        activity = new ArrayList<>();
	        list.add(a1);
	        //when(ActivityConverter.getDtoList(list)).thenReturn();
	        when(activityDao.findAll()).thenReturn(list);
	        
	        }
@Test
    public void test_get_all_success()
    {
	
		assertEquals(actService.getAllActivities().get(0).getActivityName(),"Badminton");
	
	}
}
