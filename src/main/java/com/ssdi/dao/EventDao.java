package com.ssdi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.Event;

@Repository("eventDao")
public interface EventDao extends JpaRepository<Event,Integer> {
	public List<Event> findByDateAndVenueId(String date, int venueId);
}
