package com.ssdi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ssdi.controller.RegisterForActivityController;
import com.ssdi.service.IRegisterForActivityService;

@RunWith(SpringJUnit4ClassRunner.class)
public class RegisterForActivityControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	IRegisterForActivityService registerForActivityService;
	@InjectMocks
	private RegisterForActivityController registerForActivityController;
	
	@Before
	public void setup() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(registerForActivityController).build();
		
	}
	
	@Test
	public void test() throws Exception{
		mockMvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello"));
	}
	@Test
	public void testRegisterMemberForAlreadyRegistered() throws Exception{
		//whenregisterForActivityService.fetchMemberId(token);
		when(registerForActivityService.fetchMemberId("57831")).thenReturn(1);
		//registerForActivityService.ifMemberAlreadyRegistered(activityScheduleId,memberId)
		when(registerForActivityService.ifMemberAlreadyRegistered(1,1)).thenReturn(true);
		mockMvc.perform(get("/registerMember/1/57831")
		.accept(MediaType.APPLICATION_JSON) )
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.registrationMessage",Matchers.is("You are already registered for this activity") ));
		
	}
	@Test
	public void testRegisterMemberForIsActivityFull() throws Exception{
		//whenregisterForActivityService.fetchMemberId(token);
		when(registerForActivityService.fetchMemberId("57831")).thenReturn(1);
		//registerForActivityService.ifMemberAlreadyRegistered(activityScheduleId,memberId)
		when(registerForActivityService.ifMemberAlreadyRegistered(1,1)).thenReturn(false);
		//registerForActivityService.isActivityFull(activityScheduleId)
		when(registerForActivityService.isActivityFull(1)).thenReturn(true);
		mockMvc.perform(get("/registerMember/1/57831")
		.accept(MediaType.APPLICATION_JSON) )
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.registrationMessage",Matchers.is("No space left for this activity") ));
		
	}
	@Test
	public void testRegisterMemberForSuccessFullRegisteration() throws Exception{
		//whenregisterForActivityService.fetchMemberId(token);
		when(registerForActivityService.fetchMemberId("57831")).thenReturn(1);
		//registerForActivityService.ifMemberAlreadyRegistered(activityScheduleId,memberId)
		when(registerForActivityService.ifMemberAlreadyRegistered(1,1)).thenReturn(false);
		//registerForActivityService.isActivityFull(activityScheduleId)
		when(registerForActivityService.isActivityFull(1)).thenReturn(false);
		mockMvc.perform(get("/registerMember/1/57831")
		.accept(MediaType.APPLICATION_JSON) )
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.registrationMessage",Matchers.is("You are registered for the activity") ));
		
	}
	@Test
	public void testRegisterMemberForInvalidUser() throws Exception{
		//whenregisterForActivityService.fetchMemberId(token);
		when(registerForActivityService.fetchMemberId("578311")).thenReturn(1);
		//registerForActivityService.ifMemberAlreadyRegistered(activityScheduleId,memberId)
		mockMvc.perform(get("/registerMember/1/57831")
		.accept(MediaType.APPLICATION_JSON) )
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.registrationMessage",Matchers.is("You don't have permission to carry out this task") ));
		
	}
}
