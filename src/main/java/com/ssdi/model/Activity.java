package com.ssdi.model;

import javax.persistence.*;

@Entity
public class Activity {
    @Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
    @Column
    private String name;
    @ManyToOne
    private int venueId;

    public Activity(String activityName) {
		this.name = activityName;
	}

	public Integer getActivityId() {
        return id;
    }

    public void setActivityId(Integer activityId) {
        this.id = activityId;
    }

    public String getActivityName() {
        return name;
    }

    public void setActivityName(String activityName) {
        this.name = activityName;
    }

    public int getVenue() {
        return venueId;
    }

    public void setVenue(int venueId) {
        this.venueId = venueId;
    }

    public Activity() {
    }

    public Activity(String activityName, int venueId) {
        this.name = activityName;
        this.venueId = venueId;
    }
}
