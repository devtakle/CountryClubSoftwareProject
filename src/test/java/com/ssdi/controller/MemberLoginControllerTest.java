package com.ssdi.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.ssdi.service.IMemberLoginService;
import com.ssdi.service.IRegisterForActivityService;
import com.ssdi.utilities.ITokenGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
public class MemberLoginControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	IMemberLoginService memberloginService;
	@Mock
	ITokenGenerator tokenGenerator;
	@InjectMocks
	private MemberLoginController memberLoginController;
	
	@Before
	public void setup() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(memberLoginController).build();
		
	}
	@Test
	public void testLogout() throws Exception {
		when(memberloginService.isValidToken("10000")).thenReturn(true);
		mockMvc.perform(get("/logout/10000")
				 )
				.andExpect(status().isOk());
		
	}
	@Test 
	public void testLoginForSucess() throws Exception{
		//memberloginService.isValidUser(email);
		when(memberloginService.isValidUser("akapri@uncc.edu")).thenReturn(true);
		//memberloginService.fetchPassword(email);
		when(memberloginService.fetchPassword("akapri@uncc.edu")).thenReturn("xyz");
		//tokenGenerator.genereateToken();
		when(tokenGenerator.genereateToken()).thenReturn("10000");
		mockMvc.perform(get("/login/akapri@uncc.edu/xyz")
				.accept(MediaType.APPLICATION_JSON) )
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.authenticationMessage",Matchers.is("correct password") ));
				
	}
	@Test
	public void testLoginForWrongPassword() throws Exception{
		//memberloginService.isValidUser(email);
		when(memberloginService.isValidUser("akapri@uncc.edu")).thenReturn(true);
		//memberloginService.fetchPassword(email);
		when(memberloginService.fetchPassword("akapri@uncc.edu")).thenReturn("xxyz");
		//tokenGenerator.genereateToken();
		when(tokenGenerator.genereateToken()).thenReturn("10000");
		mockMvc.perform(get("/login/akapri@uncc.edu/xyz")
				.accept(MediaType.APPLICATION_JSON) )
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.authenticationMessage",Matchers.is("Wrong Password Entered") ));
				
	}

}
