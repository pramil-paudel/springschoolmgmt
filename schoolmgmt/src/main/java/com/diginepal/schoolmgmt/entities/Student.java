package com.diginepal.schoolmgmt.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "student")
@Data
@EqualsAndHashCode(callSuper = false)
public class Student extends BaseEntity {

	private String legacyId;
	private String name;
	private String gender;
	@Temporal(TemporalType.DATE)
	private Date dobNepali;
	@Temporal(TemporalType.DATE)
	private Date dobEnglish;
	private String district;
	private String hobby;
	private String rollNo;
	private String municipality;
	private String religion;
	private String temporaryAddress;
	private int wardNo;
	private String oldSchool;
	private String reasonLeave; 
	private Date admissionDatenp;
	private String birthCertificate_no;
	private String issuedBy;

	@OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private Father father;

	@OneToOne( cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private Mother mother;

	@OneToMany(mappedBy = "student", cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private List<LocalGuardian> localguardian;
	
	@OneToOne
	private MotherLanguage motherLanguage;
}
