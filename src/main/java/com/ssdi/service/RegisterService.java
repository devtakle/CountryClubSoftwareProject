package com.ssdi.service;

import com.ssdi.model.MemberLogin;

public interface RegisterService {
	void save(MemberLogin member);
	boolean validate(MemberLogin memberLogin);

}
