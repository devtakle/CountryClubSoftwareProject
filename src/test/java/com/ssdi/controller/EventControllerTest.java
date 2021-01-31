package com.ssdi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ssdi.model.Member;
import com.ssdi.model.TemporaryEvent;
import com.ssdi.service.IMemberLoginService;
import com.ssdi.service.MemberService;
import com.ssdi.service.TemporaryEventService;

public class EventControllerTest {
	@Autowired 
	private ObjectMapper mapper;
	private EventController eventController;
    private MockMvc mockMvc;
    @Mock
	private MemberService memberService;
    @Mock
	private IMemberLoginService memberLoginService;
    @Mock
    TemporaryEventService tempService;
    private String token,date;
    private int venueId;
    List<Integer> slots;
    @Before
    public void setUp() throws ParseException {
    	memberService = mock(MemberService.class);
    	memberLoginService = mock(IMemberLoginService.class);
    	tempService = mock(TemporaryEventService.class);
    	eventController = new EventController();
    	mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
    	token = "123";
    	venueId = 5;
    	date = "2018-01-01";
    	slots = new ArrayList<>();
    	slots.add(13);
    	slots.add(14);
    	when(memberLoginService.isValidToken(token)).thenReturn(true);
    	when(tempService.getEventTimeSlots(date, venueId)).thenReturn(slots);
    	when(memberLoginService.findMemberId(token)).thenReturn(1);
    	when(memberService.getById(1)).thenReturn(new Member());
    	eventController.setMemberLoginService(memberLoginService);
    	eventController.setMemberService(memberService);
    	eventController.setTempService(tempService);

    }
    @Test
    public void testGetTimeSlots() throws Exception {
        mockMvc.perform(get("/tempEventAdd/"+date+"/"+venueId).header("token", token))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$", hasSize(2)));
		         
    }
    @Test
    public void addTemporaryEvent() throws Exception {
    	

    	TemporaryEvent event = new TemporaryEvent();
    	event.setName("Dev");
    	Gson gson = new Gson();
    	String json = gson.toJson(event);
    	System.out.println(json);
    	mockMvc.perform(post("/tempEventAdd").header("token", token)
       .contentType(MediaType.APPLICATION_JSON).content(json))
       .andExpect(status().isOk()).andExpect(jsonPath("$.name", is("Dev")));
    }
}
