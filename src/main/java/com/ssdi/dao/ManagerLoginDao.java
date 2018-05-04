package com.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.ManagerLogin;
@Repository("managerLoginDao")
public interface ManagerLoginDao extends JpaRepository<ManagerLogin, String>{
	public boolean existsByToken(String token);
	ManagerLogin findByToken(String token);
}
