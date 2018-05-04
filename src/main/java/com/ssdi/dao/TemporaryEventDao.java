package com.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.TemporaryEvent;
import com.ssdi.model.Venue;

@Repository("temporaryEventDao")
public interface TemporaryEventDao extends JpaRepository<TemporaryEvent, Integer> {
	

}
