package com.ssdi.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssdi.dao.MemberLoginDao;
import com.ssdi.model.MemberLogin;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MemberLoginServiceTest {
	@Mock
    MemberLoginDao memberLoginDao;
	private MemberLoginService loginService;
	private MemberLogin one, two;
	@Before
	public void setup() {
		loginService = new MemberLoginService();
    	memberLoginDao = mock(MemberLoginDao.class);
    	one = new MemberLogin();
    	one.setId(67);
    	one.setEmail("dev@rediff.com");
    	one.setPassword("devPass");
    	two = new MemberLogin();
    	two.setId(67);
    	two.setEmail("aditya@rediff.com");
    	two.setPassword("adityaPassword");
    	loginService.setLoginRepository(memberLoginDao);
    	when(memberLoginDao.findOne(one.getEmail())).thenReturn(one);
    	when(memberLoginDao.exists(one.getEmail())).thenReturn(true);
    	when(memberLoginDao.exists(two.getEmail())).thenReturn(false);
    	
	}
	@Test
	public void fetchPasswordTest() {
		Assert.assertEquals(one.getPassword(), loginService.fetchPassword(one.getEmail()));
	}
	@Test
	public void isValidUserTest() {
	   Assert.assertTrue(loginService.isValidUser(one.getEmail()));
	   Assert.assertFalse(loginService.isValidUser(two.getEmail()));
	}

}
