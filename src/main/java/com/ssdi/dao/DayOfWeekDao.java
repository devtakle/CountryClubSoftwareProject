package com.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.DayOfWeek;


@Repository("dayDao")
public interface DayOfWeekDao extends JpaRepository<DayOfWeek,Integer>{

}
