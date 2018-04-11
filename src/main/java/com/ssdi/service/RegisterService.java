package com.ssdi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssdi.dao.MemberDao;
import com.ssdi.dao.MemberLoginDao;
import com.ssdi.model.Member;
import com.ssdi.model.MemberLogin;

@Service("registerService")
public class RegisterService implements IRegisterService {
	@Autowired
    MemberLoginDao memberLoginDao;
	@Autowired
    MemberDao memberDao;
	
	@Override
	@Transactional
	public MemberLogin save(MemberLogin memberLogin) {
		System.out.println(memberLogin.getId()+", "+memberLogin.getEmail());
		return memberLoginDao.save(memberLogin);	
	}
	@Override
    public void setLoginRepository(MemberLoginDao memberLoginDao) {
    	this.memberLoginDao = memberLoginDao;
    }
	@Override
	public void setMemberRepository(MemberDao memberDao) {
    	this.memberDao = memberDao;
    }
    
	@Override
	public boolean validate(MemberLogin memberLogin) {
		
		Member member = memberDao.findById(memberLogin.getId());
		
		if(member == null) {
			System.out.println("member is null false "+memberLogin.getId());
			return false;
		}
		
		if(member.getId() == memberLogin.getId() && member.getEmail().equals(memberLogin.getEmail())) {
			System.out.println("true");
			return true;
		}
		System.out.println("false");
		return false;
	}
    
	@Override
	public boolean exists(MemberLogin memberLogin) {
		return memberLoginDao.exists(memberLogin.getEmail());
	}

}
