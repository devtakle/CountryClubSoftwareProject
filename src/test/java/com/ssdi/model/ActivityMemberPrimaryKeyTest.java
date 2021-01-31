package com.ssdi.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ssdi.model.ActivityMemberPrimaryKey;

public class ActivityMemberPrimaryKeyTest {
	@Test
	public void testGetAndSetMemberId() {
		ActivityMemberPrimaryKey pk = new ActivityMemberPrimaryKey();
		pk.setMemberId(1);
		assertEquals(1, pk.getMemberId());
	}
	@Test
	public void testGetAndActivityScheduleId() {
		ActivityMemberPrimaryKey pk = new ActivityMemberPrimaryKey();
		pk.setActivityScheduleId(1);
		assertEquals(1, pk.getActivityScheduleId());
	}
}
