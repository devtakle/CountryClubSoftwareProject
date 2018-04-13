package com.ssdi.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import com.ssdi.model.ActivityMember;
import com.ssdi.model.ActivityMemberPrimaryKey;

public class ActivityMemberModelTest {
	
	@Test
	public void testGetAndSetPk(){
		ActivityMemberPrimaryKey pk = new ActivityMemberPrimaryKey();
		pk.setActivityScheduleId(1);
		pk.setMemberId(1);
		ActivityMember activityMember = new ActivityMember();
		activityMember.setPk(pk);
		assertEquals(pk,activityMember.getPk());
		
	}
}
