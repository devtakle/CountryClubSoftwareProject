package com.ssdi.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ssdi.model.MemberLogin;
import com.ssdi.service.IActivityService;
import com.ssdi.service.IRegisterService;

public class ActivityControllerTest {
	private ActivityController actController;
    private MockMvc mockMvc;
    @Mock
    IActivityService actService;
    private MemberLogin memberLogin1, memberLogin2, memberLogin3;
    @Before
    public void setUp() {
    	actService = mock(IActivityService.class);
    	actController = new ActivityController();
    	mockMvc = MockMvcBuilders.standaloneSetup(actController).build();
    	actController
    	when(regService.validate(memberLogin1)).thenReturn(true);
    	when(regService.validate(memberLogin2)).thenReturn(false);
    	when(regService.exists(memberLogin1)).thenReturn(true);
    	when(regService.exists(memberLogin3)).thenReturn(false);
    }
	@Test
	public void testRegisterMember() {
		
	}

}
