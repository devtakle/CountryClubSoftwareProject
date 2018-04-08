package com.ssdi.service;

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
	private MemberLogin one, two,three;
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
    	three = new MemberLogin();
    	three.setId(9);
    	three.setEmail("sl@uncc.edu");
    	three.setPassword("testPass");
    	three.setToken("92957");
    	loginService.setLoginRepository(memberLoginDao);
    	when(memberLoginDao.findOne(one.getEmail())).thenReturn(one);
    	when(memberLoginDao.exists(one.getEmail())).thenReturn(true);
    	when(memberLoginDao.exists(two.getEmail())).thenReturn(false);
    	when(memberLoginDao.existsByToken(three.getToken())).thenReturn(true);
    	when(memberLoginDao.existsByToken(one.getToken())).thenReturn(false);
    	
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
	@Test
	public void isValidTokenTest() {
		Assert.assertTrue(loginService.isValidToken(three.getToken()));
		Assert.assertFalse(loginService.isValidToken(one.getToken()));
	}

}
