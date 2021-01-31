package com.ssdi.service;

import java.util.ArrayList;
import java.util.List;

import com.ssdi.dto.ActivityScheduleDto;
import com.ssdi.model.ActivityMember;

public interface IRegisterForActivityService {

	int fetchMemberId(String token);

	boolean ifMemberAlreadyRegistered(int activityScheduleId, int memberId);

	boolean isActivityFull(int activityScheduleId);

	void confirmRegistration(int activityScheduleId, int memberId);

	public ArrayList<ActivityMember> fetchActivities(int memberId);
	
	public List<ActivityScheduleDto> fetchActivityScheduleRecords(ArrayList<ActivityMember> list) ;

	public boolean isMemberRegistered(int memberId);
	
	public void  deregisterFromActivity(int activityScheduleId, int memberId);

}
