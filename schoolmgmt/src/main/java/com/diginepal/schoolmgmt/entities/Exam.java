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
@Table (name="exam")
public class Exam extends BaseEntity{
	private String code;
	private String name;
	private String startdate;
	private String startdateen;
	
	@OneToOne
	private Academicdates academicdates;
	
	@OneToOne
	private Examtype examtype;  
	
	@JsonIgnore
	@OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
	private Set<Marks> marks;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getStartdateen() {
		return startdateen;
	}

	public void setStartdateen(String startdateen) {
		this.startdateen = startdateen;
	}

	public Academicdates getAcademicdates() {
		return academicdates;
	}

	public void setAcademicdates(Academicdates academicdates) {
		this.academicdates = academicdates;
	}

	public Examtype getExamtype() {
		return examtype;
	}

	public void setExamtype(Examtype examtype) {
		this.examtype = examtype;
	}

	public Set<Marks> getMarks() {
		return marks;
	}

	public void setMarks(Set<Marks> marks) {
		this.marks = marks;
	}

}
