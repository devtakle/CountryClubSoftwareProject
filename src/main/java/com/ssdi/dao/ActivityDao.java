package com.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ssdi.model.Activity;


@Repository("activityDao")
public interface ActivityDao extends JpaRepository<Activity, Integer>{
	
}
