package com.ssdi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ActivityMemberPrimaryKey implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	@Column
	private int activity_instance_id;
	@NotNull
	@Column
	private int member_id;
	public int getActivityScheduleId() {
		return activity_instance_id;
	}
	public void setActivityScheduleId(int activityScheduleId) {
		this.activity_instance_id = activityScheduleId;
	}
	public int getMemberId() {
		return member_id;
	}
	public void setMemberId(int memberId) {
		this.member_id = memberId;
	}
	

}
