package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity 
@Table(name="branch")
public class Branch extends BaseEntity{
private int code;
private String name;
private String address;
private String phone;
private String email;

@ManyToOne
@JoinColumn(name = "company_id")
private Company company;

public int getCode() {
	return code;
}

public void setCode(int code) {
	this.code = code;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Company getCompany() {
	return company;
}

public void setCompany(Company company) {
	this.company = company;
}



}
