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
import com.ssdi.service.IRegisterService;

public class RegisterControllerTest {
	private RegisterController registerController;
    private MockMvc mockMvc;
    @Mock
    IRegisterService regService;
    private MemberLogin memberLogin1, memberLogin2, memberLogin3;
    @Before
    public void setUp() {
    	regService = mock(IRegisterService.class);
    	registerController = new RegisterController();
    	mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
    	registerController.setRegisterService(regService);
    	when(regService.validate(memberLogin1)).thenReturn(true);
    	when(regService.validate(memberLogin2)).thenReturn(false);
    	when(regService.exists(memberLogin1)).thenReturn(true);
    	when(regService.exists(memberLogin3)).thenReturn(false);
    }
	@Test
	public void testRegisterMember() {
		
	}

}
