package com.ssdi.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ssdi.dao.ActivityMemberDao;
import com.ssdi.dao.ActivityScheduleDao;
//import com.ssdi.dao.MemberLoginDAO;
import com.ssdi.dao.MemberLoginDao;
import com.ssdi.dao.VenueDao;
import com.ssdi.model.ActivityMember;
import com.ssdi.model.ActivityMemberPrimaryKey;
import com.ssdi.model.ActivitySchedule;
import com.ssdi.model.MemberLogin;
import com.ssdi.model.Venue;
import com.ssdi.service.RegisterForActivityService;




@RunWith(MockitoJUnitRunner.class)
public class RegisterForActivityServiceTest {
	@Mock
	MemberLoginDao memberLoginDAOMock;
	
	
	@Mock
	ActivityMemberDao activityMemberDaoMock;
	
//	@Mock
//	MemberLogin memberLogin;
	
	@Mock
	private VenueDao venueDao;
	
	@Mock
	private ActivityScheduleDao activityScheduleDao;
	
	
	@InjectMocks
	RegisterForActivityService registerForActivityService;
	
	

	@Test
	public void testFetchMemberIdForScuccess() { 
	MemberLogin memberLogin = new MemberLogin();
		memberLogin.setId(9);
		memberLogin.setPassword("xyz");
		memberLogin.setEmail("kapri@uncc.edu");
		memberLogin.setToken("93902");
		ArrayList<MemberLogin> list = new ArrayList<MemberLogin>();
		list.add(memberLogin);
		when(memberLoginDAOMock.findAll()).thenReturn(list);
		assertEquals(9, registerForActivityService.fetchMemberId("93902"));
	}
	@Test
	public void testFetchMemberIdForFailure() { 
		MemberLogin memberLogin = new MemberLogin();
		memberLogin.setId(10);
		memberLogin.setPassword("xyz");
		memberLogin.setEmail("skapri@uncc.edu");
		memberLogin.setToken("10272");
		ArrayList<MemberLogin> list = new ArrayList<MemberLogin>();
		list.add(memberLogin);
		when(memberLoginDAOMock.findAll()).thenReturn(list);
		assertNotEquals(11, registerForActivityService.fetchMemberId("10272"));
	}
	@Test
	public void testIfMemberAlreadyRegistered() {
		ActivityMemberPrimaryKey pk = new ActivityMemberPrimaryKey();
		pk.setActivityScheduleId(1);
		pk.setMemberId(10);
		ActivityMember activityMember = new ActivityMember();
		activityMember.setPk(pk);
		activityMemberDaoMock.save(activityMember);
		when(activityMemberDaoMock.exists(pk)).thenReturn(false);
		assertEquals(false, registerForActivityService.ifMemberAlreadyRegistered(1, 10));
		//assertNotEquals(, registerForActivityService.ifMemberAlreadyRegistered(1, 11));
	}
	@Test
	public void testConfirmRegistration(){
		ActivityMemberPrimaryKey pk = new ActivityMemberPrimaryKey();
		ActivityMember activityMember = new ActivityMember();
		pk.setActivityScheduleId(1);
		pk.setMemberId(11);
		activityMember.setPk(pk);
		when(activityMemberDaoMock.save(activityMember)).thenReturn(activityMember);
		activityMemberDaoMock.save(activityMember);
		when(activityMemberDaoMock.exists(pk)).thenReturn(true);
		assertEquals(true, activityMemberDaoMock.exists(pk));
	}
	@Test
	public void testIsActivityFullForSuccess() {
		ActivitySchedule activitySchedule = new ActivitySchedule();
		Venue venue = new Venue();
		activitySchedule.setId(100);
		activitySchedule.setActivity_capacity(1);
		venue.setVenueId(1);
		venue.setVenue_capacity(11);
		activitySchedule.setVenue(venue);
		when(activityScheduleDao.findOne(100)).thenReturn(activitySchedule);
		when(venueDao.findOne(activitySchedule.getVenue().getVenueId())).thenReturn(venue);
		assertEquals(false, registerForActivityService.isActivityFull(100));
	}
	@Test
	public void testIsActivityFullForFailure() {
		ActivitySchedule activitySchedule = new ActivitySchedule();
		Venue venue = new Venue();
		activitySchedule.setId(100);
		activitySchedule.setActivity_capacity(12);
		venue.setVenueId(1);
		venue.setVenue_capacity(11);
		activitySchedule.setVenue(venue);
		when(activityScheduleDao.findOne(100)).thenReturn(activitySchedule);
		when(venueDao.findOne(activitySchedule.getVenue().getVenueId())).thenReturn(venue);
		assertEquals(true, registerForActivityService.isActivityFull(100));
	}
	@Test
	public void testIncreaseActivityCount() {
		ActivitySchedule activitySchedule = new ActivitySchedule();
		activitySchedule.setActivity_capacity(10);
		when(activityScheduleDao.findOne(10)).thenReturn(activitySchedule);
		registerForActivityService.increaseActivityCount(10);
		//System.out.println("count"+activitySchedule.getActivity_capacity());
		assertEquals(11, activitySchedule.getActivity_capacity());
		
	}
	
	
	
	  
}


