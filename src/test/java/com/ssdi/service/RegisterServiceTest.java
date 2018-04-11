package com.ssdi.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ssdi.dao.MemberDao;
import com.ssdi.dao.MemberLoginDao;
import com.ssdi.model.Member;
import com.ssdi.model.MemberLogin;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RegisterServiceTest {
    @Mock
    MemberLoginDao memberLoginDao;
    @Mock
    MemberDao memberDao;
    private IRegisterService regService;
    private MemberLogin one, two;
    private Member member;
    @Before
    public void setup() {
    	regService = new RegisterService();
    	memberLoginDao = mock(MemberLoginDao.class);
    	regService.setLoginRepository(memberLoginDao);
    	
    	/*   
    	 * 67, "dev@rediff.com"
    	 * */
    	one = new MemberLogin();
    	one.setId(67);
    	one.setEmail("dev@rediff.com");
    	one.setPassword("devPass");
    	/*
    	 * null object
    	 */
    	two = new MemberLogin();
    	two.setEmail(null);
    	/*
    	 * Member object with id 67 and email "dev@rediff.com"
    	 */
    	member = new Member();
    	member.setId(67);
    	member.setEmail("dev@rediff.com");
    	regService.setMemberRepository(memberDao);
    	when(memberLoginDao.save(one)).thenReturn(one);
		when(memberLoginDao.save(two)).thenReturn(null);
		when(memberDao.findById(one.getId())).thenReturn(member);
    }
	@Test
	public void testValidate() {
		Assert.assertTrue(regService.validate(one));
		Assert.assertFalse(regService.validate(two));
	}
	@Test
	public void testSave() {
		Assert.assertEquals(one,regService.save(one));
		//Assert.assertEquals(null,regService.save(two));
	}

}
