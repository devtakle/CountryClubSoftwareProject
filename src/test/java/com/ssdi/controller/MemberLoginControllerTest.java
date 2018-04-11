package com.ssdi.controller;

import static org.junit.Assert.*;
<<<<<<< HEAD
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssdi.service.IMemberLoginService;

public class MemberLoginControllerTest {
	@Mock
	private IMemberLoginService memberloginService;
	
	@Before
	public void setUp() {
		memberloginService = mock(IMemberLoginService.class);
	}
=======

import org.junit.Test;

public class MemberLoginControllerTest {
>>>>>>> branch 'master' of git@github.com:devtakle/CountryClubSoftwareProject.git

	@Test
	public void test() {
		
	}

}
