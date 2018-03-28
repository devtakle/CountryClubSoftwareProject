package com.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{
}
