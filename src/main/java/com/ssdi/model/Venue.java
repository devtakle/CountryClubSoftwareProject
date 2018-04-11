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
