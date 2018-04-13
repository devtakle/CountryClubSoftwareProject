package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.ActivityMemberDao;
import com.ssdi.dao.ActivityScheduleDao;
import com.ssdi.dao.MemberLoginDao;
import com.ssdi.dao.VenueDao;
import com.ssdi.model.ActivityMember;
import com.ssdi.model.ActivityMemberPrimaryKey;
import com.ssdi.model.ActivitySchedule;
import com.ssdi.model.MemberLogin;
import com.ssdi.model.Venue;

@Service
public class RegisterForActivityService implements IRegisterForActivityService {
	@Autowired
	private MemberLoginDao memberLoginDAO;
	@Autowired
	private ActivityMemberDao activityMemberDao;
	@Autowired
	private VenueDao venueDao;
	@Autowired
	private ActivityScheduleDao activityScheduleDao;
	
	/*fetches member id corresponding to token from Login Table*/
//	public int fetchMemberId(String token) {
//		//public boolean existsByToken(String token);
//		//return memberLoginDAO.existsByToken(token);
//		System.out.println("value of token inside fecthMember--->"+token);
//		int memberId = 0;
//		while(memberLoginDAO.findAll().iterator().hasNext()) {
//			System.out.println("value of present token--->"+memberLoginDAO.findAll().iterator().next().getToken());
//			if(memberLoginDAO.findAll().iterator().next().getToken().equals(token)) {
//				memberId =  memberLoginDAO.findAll().iterator().next().getId();
//				break;
//			}
//		}
//		return memberId;
//	}
	public int fetchMemberId(String token) {
		MemberLogin memberLogin = new MemberLogin();
		if (memberLoginDAO.existsByToken(token)){
			memberLogin =  memberLoginDAO.findByToken(token);
			return memberLogin.getId();
		}
		else {
			return 0;
		}
	}
	
	/*check if user entry is already there in ActivityMember Table*/
	public boolean ifMemberAlreadyRegistered(int activityScheduleId,int memberId) {
		boolean isMemberAlreadyRegistered = false;
		ActivityMemberPrimaryKey pk = new ActivityMemberPrimaryKey();
		pk.setActivityScheduleId(activityScheduleId);
		pk.setMemberId(memberId);
		if(activityMemberDao.exists(pk)) {
			//System.out.println("inside  if ");
			isMemberAlreadyRegistered = true;
		}
		return isMemberAlreadyRegistered;
	}
	
	/*checks if space is left in activity or not*/
	public boolean isActivityFull(int activityScheduleId) {
		ActivitySchedule activitySchedule = new ActivitySchedule();
		Venue venue = new Venue();
		boolean isActivityFull = false;
		//fetch current activity capacity
		activitySchedule = activityScheduleDao.findOne(activityScheduleId);
		//fetch venue capacity
		if(activitySchedule == null) {
			System.out.println("activitySchedule is null");
		}
		System.out.println("value of ---->venue  id"+activitySchedule.getId());
		System.out.println("value of ---->venue  id"+activitySchedule.getVenue().getVenueId());
		venue = venueDao.findOne(activitySchedule.getVenue().getVenueId());
		if(venue.getVenue_capacity() <= activitySchedule.getActivity_capacity()) {
			isActivityFull = true;
		}
		return isActivityFull;
	}
	
	/*saves entry for user in the ActivityMember Table*/
	public void confirmRegistration(int activityScheduleId,int memberId) {
		ActivityMemberPrimaryKey pk = new ActivityMemberPrimaryKey();
		ActivityMember activityMember = new ActivityMember();
		pk.setActivityScheduleId(activityScheduleId);
		pk.setMemberId(memberId);
		activityMember.setPk(pk);
		activityMemberDao.save(activityMember);
		//increase current activity capacity by one in ActivitySchedule table
		increaseActivityCount(activityScheduleId);
	}
	
	/*increase current activity capacity by one in ActivitySchedule table*/
	public void increaseActivityCount(int activityScheduleId) {
		ActivitySchedule activitySchedule = new ActivitySchedule();
		activitySchedule = activityScheduleDao.findOne(activityScheduleId);
		activitySchedule.setActivity_capacity(activitySchedule.getActivity_capacity() + 1);
		activityScheduleDao.save(activitySchedule);
	}
}
