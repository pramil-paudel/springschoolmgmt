package com.diginepal.schoolmgmt.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class Employee extends BaseEntity {
	private String name;
	private String address;
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String status;
	private String gender;
	private String code;
	
	@Temporal(TemporalType.DATE)
	private Date joindate;
 
	 @OneToOne
	 private Branch branch;

}
