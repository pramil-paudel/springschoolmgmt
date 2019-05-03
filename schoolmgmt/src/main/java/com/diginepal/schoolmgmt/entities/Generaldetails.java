package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name="genraldetails")
@Data
public class Generaldetails extends BaseEntity {
	private int id;
	private String address;
	private String code;
	private String email;
	private String name;
	private int phone;
	private String title;
	
	@OneToOne
	private Academicdates academicdates;  	
}
