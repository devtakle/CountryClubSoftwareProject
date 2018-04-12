package com.ssdi.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssdi.model.ActivityMember;
import com.ssdi.model.ActivityMemberPrimaryKey;



public interface ActivityMemberDao extends CrudRepository<ActivityMember,ActivityMemberPrimaryKey> {

}
