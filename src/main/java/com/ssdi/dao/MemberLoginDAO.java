package com.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.MemberLogin;
@Repository("memberLoginDao")
public interface MemberLoginDAO extends JpaRepository<MemberLogin, String>{
	
}
