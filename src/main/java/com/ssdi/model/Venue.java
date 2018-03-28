package com.ssdi.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Venue implements Serializable{

    private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;
	
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer venueId;
    @Column
    private String venueName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Activity> activitys= new LinkedList<>();

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public List<Activity> getActivitys() {
        return activitys;
    }

    public void setActivitys(List<Activity> activitys) {
        this.activitys = activitys;
    }

    public Venue() {
    }

    public Venue(String venueName, List<Activity> activitys) {
        this.venueName = venueName;
        this.activitys = activitys;
    }
}
