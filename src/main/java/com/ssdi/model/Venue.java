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
	private int id;
    @Column
    private String venue_name;
    @Column(name = "opening_time")
    private String openTime;
    @Column(name = "closing_time")
    private String closeTime;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVenue_name() {
		return venue_name;
	}

	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Column
    private int capacity;
    
    public int getVenue_capacity() {
		return capacity;
	}

	public void setVenue_capacity(int capacity) {
		this.capacity = capacity;
	}

	public Integer getVenueId() {
        return id;
    }

    public void setVenueId(Integer venueId) {
        this.id = venueId;
    }

    public String getVenueName() {
        return venue_name;
    }

    public void setVenueName(String venueName) {
        this.venue_name = venueName;
    }

    
    public Venue() {
    }

    public Venue(String venueName) {
        this.venue_name = venueName;
    }

	
}
