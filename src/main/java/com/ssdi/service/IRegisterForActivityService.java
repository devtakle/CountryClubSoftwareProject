package com.ssdi.service;

public interface IRegisterForActivityService {

	int fetchMemberId(String token);

	boolean ifMemberAlreadyRegistered(int activityScheduleId, int memberId);

	boolean isActivityFull(int activityScheduleId);

	void confirmRegistration(int activityScheduleId, int memberId);

}
