package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table (name="exam")
@Data
@EqualsAndHashCode(callSuper = false)
public class Exam extends BaseEntity{
	private String code;
	private String name;
	private String startdate;
	private String startdateen;
	
	@OneToOne
	private Academicdates academicdates;
	
	@OneToOne
	private Examtype examtype;  	

}
