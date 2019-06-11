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


	public String getLegacyId() {
		return legacyId;
	}


	public void setLegacyId(String legacyId) {
		this.legacyId = legacyId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDobNepali() {
		return dobNepali;
	}


	public void setDobNepali(String dobNepali) {
		this.dobNepali = dobNepali;
	}


	public String getDobEnglish() {
		return dobEnglish;
	}


	public void setDobEnglish(String dobEnglish) {
		this.dobEnglish = dobEnglish;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	public String getRollNo() {
		return rollNo;
	}


	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}


	public String getMunicipality() {
		return municipality;
	}


	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}


	public String getReligion() {
		return religion;
	}


	public void setReligion(String religion) {
		this.religion = religion;
	}


	public String getTemporaryAddress() {
		return temporaryAddress;
	}


	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}


	public int getWardNo() {
		return wardNo;
	}


	public void setWardNo(int wardNo) {
		this.wardNo = wardNo;
	}


	public String getOldSchool() {
		return oldSchool;
	}


	public void setOldSchool(String oldSchool) {
		this.oldSchool = oldSchool;
	}


	public String getReasonLeave() {
		return reasonLeave;
	}


	public void setReasonLeave(String reasonLeave) {
		this.reasonLeave = reasonLeave;
	}


	public String getAdmissionDatenp() {
		return admissionDatenp;
	}


	public void setAdmissionDatenp(String admissionDatenp) {
		this.admissionDatenp = admissionDatenp;
	}


	public String getBirthCertificateNo() {
		return birthCertificateNo;
	}


	public void setBirthCertificateNo(String birthCertificateNo) {
		this.birthCertificateNo = birthCertificateNo;
	}


	public String getIssuedBy() {
		return issuedBy;
	}


	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}


	public LocalGuardian getLocalGuardian() {
		return localGuardian;
	}


	public void setLocalGuardian(LocalGuardian localGuardian) {
		this.localGuardian = localGuardian;
	}


	public Father getFather() {
		return father;
	}


	public void setFather(Father father) {
		this.father = father;
	}


	public Mother getMother() {
		return mother;
	}


	public void setMother(Mother mother) {
		this.mother = mother;
	}


	public MotherLanguage getMotherLanguage() {
		return motherLanguage;
	}


	public void setMotherLanguage(MotherLanguage motherLanguage) {
		this.motherLanguage = motherLanguage;
	}


	public Grade getGrade() {
		return grade;
	}


	public void setGrade(Grade grade) {
		this.grade = grade;
	}


	public Section getSection() {
		return section;
	}


	public void setSection(Section section) {
		this.section = section;
	}


	public List<Subjects> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}


	public Set<Marks> getMarks() {
		return marks;
	}


	public void setMarks(Set<Marks> marks) {
		this.marks = marks;
	}
	
	
}
