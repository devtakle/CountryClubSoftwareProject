package com.ssdi.controller;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ssdi.dto.ActivityDto;
import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.service.IActivityScheduleService;
import com.ssdi.service.IActivityService;
import com.ssdi.service.IMemberLoginService;

public class ActivityControllerTest {
	private ActivityController actController;
    private MockMvc mockMvc;
    @Mock
	private IActivityScheduleService actScheduleService;
    @Mock
	private IMemberLoginService memberLoginService;
    @Mock
	private IActivityService activityService;
    private String token;
   
    @Before
    public void setUp() {
    	List<ActivityDto> list = new ArrayList<>();
    	List<ActivityScheduleDto> scheduleList = new ArrayList<>();
    	scheduleList.add(new ActivityScheduleDto(1,  "court 1", "Basketball",
    		"Monday", "14:00", "18:00"));
    	scheduleList.add(new ActivityScheduleDto(2,  "court 2", "Basketball",
        		"Monday", "17:00", "20:00"));
    	activityService = mock(IActivityService.class);
    	actScheduleService = mock(IActivityScheduleService.class);
    	memberLoginService = mock(IMemberLoginService.class);
    	actController = new ActivityController();
    	actController.setActScheduleService(actScheduleService);
    	actController.setMemberLoginService(memberLoginService);
    	actController.setActivityService(activityService);
    	mockMvc = MockMvcBuilders.standaloneSetup(actController).build();
    	list.add(new ActivityDto(1,"Badminton","Sports"));
    	list.add(new ActivityDto(2,"Basketball","Sports"));
    	when(activityService.getAllActivities()).thenReturn(list);
    	token = "92957";
    	when(memberLoginService.isValidToken(token)).thenReturn(true);	
    	when(actScheduleService.getByActivityId(1)).thenReturn(scheduleList);
    }
	@Test
	public void testGetAllActivities() throws Exception {
		mockMvc.perform(get("/activities").header("token", token)).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
	                .andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].activityName", is("Badminton")))
	                .andExpect(jsonPath("$[1].activityName", is("Basketball")))
	                .andExpect(jsonPath("$[0].activityId", is(1)))
	                .andExpect(jsonPath("$[1].activityId", is(2)));		
	}
	@Test
	public void testGetActivitiesById() throws Exception {
		mockMvc.perform(get("/activities/1").header("token", token)).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].activitiy_name", is("Basketball")))
        .andExpect(jsonPath("$[1].activitiy_name", is("Basketball")))
        .andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[1].id", is(2)))
        .andExpect(jsonPath("$[0].venue_name", is("court 1")))
        .andExpect(jsonPath("$[1].venue_name", is("court 2")));	
		
	}

}
