package com.diginepal.schoolmgmt.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
//github.com/hackersdelima/springschoolmgmt.git
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
	private String birthCertificateNo;
	private String issuedBy;



	@OneToOne(cascade= { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private LocalGuardian localGuardian;

	@OneToOne(cascade= { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private Father father;
	
	@OneToOne(cascade= { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private Mother mother;

	
	@OneToOne
	private MotherLanguage motherLanguage;
	
	@OneToOne
	private Grade grade;
	
	@OneToOne
	private Section section;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	        name = "student_subjects", 
	        joinColumns = { @JoinColumn(name = "student_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "subjects_id") }
	    )
	    List<Subjects> subjects;

	
	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<Marks> marks;
}
