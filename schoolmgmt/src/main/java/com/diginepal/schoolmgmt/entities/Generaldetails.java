package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table (name="generaldetails")
public class Generaldetails extends BaseEntity {
	private String address;
	private String code;
	private String email;
	private String name;
	private String phone;
	private String title;
	
	@OneToOne
	private Academicdates academicdates;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Academicdates getAcademicdates() {
		return academicdates;
	}

	public void setAcademicdates(Academicdates academicdates) {
		this.academicdates = academicdates;
	}  
}
