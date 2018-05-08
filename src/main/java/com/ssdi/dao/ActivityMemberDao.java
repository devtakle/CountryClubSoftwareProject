package com.ssdi.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssdi.model.ActivityMember;
import com.ssdi.model.ActivityMemberPrimaryKey;
import com.ssdi.model.MemberLogin;


@Repository("activityMemberDao")
public interface ActivityMemberDao extends CrudRepository<ActivityMember,ActivityMemberPrimaryKey> {
public ArrayList<ActivityMember> test(int memberId);
}
