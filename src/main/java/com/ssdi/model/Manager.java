package com.ssdi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



import javax.persistence.Column;
@Entity
public class Manager{
@Id
@GeneratedValue
@Column(name = "id")
private int id;
@Column(name = "email")
private String email;
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
