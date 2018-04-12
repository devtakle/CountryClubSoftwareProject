package com.ssdi.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ActivityMemberPrimaryKey implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	private int activityScheduleId;
	@NotNull
	private int memberId;
	public int getActivityScheduleId() {
		return activityScheduleId;
	}
	public void setActivityScheduleId(int activityScheduleId) {
		this.activityScheduleId = activityScheduleId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	

}
