package com.ssdi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ssdi.model.ActivitySchedule;
@Repository("activityScheduleDao")
public interface ActivityScheduleDao extends JpaRepository<ActivitySchedule, Integer> {
	public List<ActivitySchedule> findByActivityId(int activity_id);
	

}
