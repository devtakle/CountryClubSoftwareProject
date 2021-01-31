package com.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.Manager;
@Repository("managerDao")
public interface ManagerDao extends JpaRepository<Manager, Integer> {
	Manager findById(int id);
}
