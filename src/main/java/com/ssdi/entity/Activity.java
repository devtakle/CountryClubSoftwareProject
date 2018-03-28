package com.ssdi.entity;

import javax.persistence.*;

@Entity
public class Activity {
    @Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer activityId;
    @Column
    private String activityName;
    @ManyToOne
    private Venue venue;

    public Activity(String activityName) {
		this.activityName = activityName;
	}

	public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Activity() {
    }

    public Activity(String activityName, Venue venue) {
        this.activityName = activityName;
        this.venue = venue;
    }
}
