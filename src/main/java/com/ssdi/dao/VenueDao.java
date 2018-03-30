package com.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.Venue;

@Repository
public interface VenueDao extends JpaRepository<Venue, Integer>{
}
