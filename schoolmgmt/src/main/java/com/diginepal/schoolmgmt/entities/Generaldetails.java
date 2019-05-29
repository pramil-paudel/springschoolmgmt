package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table (name="generaldetails")
@Data
@EqualsAndHashCode(callSuper = false)
public class Generaldetails extends BaseEntity {
	private String address;
	private String code;
	private String email;
	private String name;
	private String phone;
	private String title;
	
	@OneToOne
	private Academicdates academicdates;  	
}
