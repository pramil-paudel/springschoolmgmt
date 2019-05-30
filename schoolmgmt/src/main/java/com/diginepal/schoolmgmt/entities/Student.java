package com.diginepal.schoolmgmt.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private String dobNepali;
	private String dobEnglish;
	private String district;
	private String hobby;
	private String rollNo;
	private String municipality;
	private String religion;
	private String temporaryAddress;
	private int wardNo;
	private String oldSchool;
	private String reasonLeave; 
	private String admissionDatenp;
	private String birthCertificate_no;
	private String issuedBy;

	@OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private Father father;

	@OneToOne( cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private Mother mother;

	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<LocalGuardian> LocalGuardian;

	
	@OneToOne
	private MotherLanguage motherLanguage;
}
