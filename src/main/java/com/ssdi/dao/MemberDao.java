package com.ssdi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.Member;
@Repository("memberDao")
public interface MemberDao extends JpaRepository<Member, Integer> {
	Member findById(int id);
}
