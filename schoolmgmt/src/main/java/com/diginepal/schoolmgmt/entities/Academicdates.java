package com.diginepal.schoolmgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="academicdates")
public class Academicdates extends BaseEntity{
	@Column (unique= true) 
	private String academicdate; 
	@Column (unique= true)
	private String academicdateen;
	public String getAcademicdate() {
		return academicdate;
	}
	public void setAcademicdate(String academicdate) {
		this.academicdate = academicdate;
	}
	public String getAcademicdateen() {
		return academicdateen;
	}
	public void setAcademicdateen(String academicdateen) {
		this.academicdateen = academicdateen;
	}
	
	
}