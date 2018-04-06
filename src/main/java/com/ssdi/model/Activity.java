package com.ssdi.model;

import javax.persistence.*;

@Entity
public class Activity {
    @Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
    @Column
    private String activity_name;

	public int getActivityId() {
        return id;
    }

    public void setActivityId(int activityId) {
        this.id = activityId;
    }

    public String getActivityName() {
        return activity_name;
    }

    public void setActivityName(String activityName) {
        this.activity_name = activityName;
    }

}
