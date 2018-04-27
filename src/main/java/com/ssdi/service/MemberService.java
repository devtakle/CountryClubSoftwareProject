package com.ssdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.dao.MemberDao;
import com.ssdi.model.Member;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	public Member getById(int id) {
		return memberDao.findById(id);
	}

}
