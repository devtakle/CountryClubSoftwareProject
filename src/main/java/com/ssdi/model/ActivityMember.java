package com.ssdi.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
//@NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(?1)")
@NamedQuery(name = "ActivityMember.test", query = "SELECT p FROM ActivityMember p WHERE p.pk.member_id = ?1")
@Table(name ="MemberActivity")
public class ActivityMember {
	@EmbeddedId
	private ActivityMemberPrimaryKey pk;

	public ActivityMemberPrimaryKey getPk() {
		return pk;
	}

	public void setPk(ActivityMemberPrimaryKey pk) {
		this.pk = pk;
	}
	
	
}
