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
	private Integer id;
    @Column
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Activity> activitys= new LinkedList<>();

    public Integer getVenueId() {
        return id;
    }

    public void setVenueId(Integer venueId) {
        this.id = venueId;
    }

    public String getVenueName() {
        return name;
    }

    public void setVenueName(String venueName) {
        this.name = venueName;
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
        this.name = venueName;
        this.activitys = activitys;
    }
}
