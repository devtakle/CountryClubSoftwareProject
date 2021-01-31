package com.ssdi.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MemberLoginTest {
	MemberLogin login = new MemberLogin();
	@Test
	public void testGetSetId() {
		login.setId(1);
		assertEquals(1, login.getId());
	}
	@Test
	public void testGetSetEmail() {
		login.setEmail("akapri@uncc.edu");
		assertEquals("akapri@uncc.edu", login.getEmail());
	}
	@Test
	public void testGetSetPassword() {
		login.setPassword("xyz");
		assertEquals("xyz", login.getPassword());
		
	}
}
