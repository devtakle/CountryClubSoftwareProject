package com.ssdi.service;

import com.ssdi.dao.MemberDao;
import com.ssdi.dao.MemberLoginDAO;
import com.ssdi.model.MemberLogin;

public interface RegisterService {
	MemberLogin save(MemberLogin member);
	boolean validate(MemberLogin memberLogin);
	boolean exists(MemberLogin memberLogin);
	void setLoginRepository(MemberLoginDAO memberLoginDao);
	void setMemberRepository(MemberDao memberDao);

}
