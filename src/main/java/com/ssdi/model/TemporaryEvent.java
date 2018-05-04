package com.ssdi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TemporaryEvent {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column(name="event_date")
	private String date;
	@Column(name = "start_at")
	private String startAt; 
	@Column(name = "end_at")
	private String endAt;
	@OneToOne
    @JoinColumn(name="venue_id", referencedColumnName="id")
    private Venue venue;
	@OneToOne
    @JoinColumn(name="member_id", referencedColumnName="id")
    private Member member;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartAt() {
		return startAt;
	}
	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}
	public String getEndAt() {
		return endAt;
	}
	public void setEndAt(String endAt) {
		this.endAt = endAt;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

}
