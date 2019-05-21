package com.diginepal.schoolmgmt.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="employee")
@Data
@EqualsAndHashCode(callSuper = false)
public class Employee extends BaseEntity {
	private String name;
	private String address;
	private String email;
	
	private String dob;
	private String status;
	private String gender;
	private String code;
	
	private String joindate;
 
	 @OneToOne
	 private Branch branch;

}
