package com.ssdi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssdi.dao.MemberDao;
import com.ssdi.dao.MemberLoginDAO;
import com.ssdi.model.Member;
import com.ssdi.model.MemberLogin;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
	@Autowired
    MemberLoginDAO memberLoginDao;
	@Autowired
    MemberDao memberDao;
	
	@Override
	@Transactional
	public void save(MemberLogin memberLogin) {
		System.out.println(memberLogin.getId()+", "+memberLogin.getEmail());
		memberLoginDao.saveAndFlush(memberLogin);
		
	}

	@Override
	public boolean validate(MemberLogin memberLogin) {
		Member member = memberDao.findById(memberLogin.getId());
		if(member == null) {
			System.out.println("false");
			return false;
		}
		
		if(member.getId() == memberLogin.getId() && member.getEmail().equals(memberLogin.getEmail())) {
			System.out.println("true");
			return true;
		}
		System.out.println("false");
		return false;
	}

}
