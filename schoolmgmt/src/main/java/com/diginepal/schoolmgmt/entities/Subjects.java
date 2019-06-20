package com.diginepal.schoolmgmt.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="subjects")
public class Subjects extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String subjecttype;
	@Column(unique=true)
	private String code;
	
	@Column (nullable= true)
	private Double fullmarks_th;
	
	private Double fullmarks_pr;
	
	private Double passmarks_th;
	
	private Double passmarks_pr; 
	
	@JsonIgnore
	@ManyToMany(mappedBy = "subjects")
    private List<Student> students;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subjects", cascade = CascadeType.ALL)
	private Set<Marks> marks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubjecttype() {
		return subjecttype;
	}

	public void setSubjecttype(String subjecttype) {
		this.subjecttype = subjecttype;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public double getFullmarks_th() {
		return fullmarks_th;
	}

	public void setFullmarks_th(double fullmarks_th) {
		this.fullmarks_th = fullmarks_th;
	}

	

	public double getFullmarks_pr() {
		return fullmarks_pr;
	}

	public void setFullmarks_pr(double fullmarks_pr) {
		this.fullmarks_pr = fullmarks_pr;
	}

	public double getPassmarks_th() {
		return passmarks_th;
	}

	public void setPassmarks_th(double passmarks_th) {
		this.passmarks_th = passmarks_th;
	}

	public double getPassmarks_pr() {
		return passmarks_pr;
	}

	public void setPassmarks_pr(double passmarks_pr) {
		this.passmarks_pr = passmarks_pr;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setFullmarks_th(Double fullmarks_th) {
		this.fullmarks_th = fullmarks_th;
	}

	public void setFullmarks_pr(Double fullmarks_pr) {
		this.fullmarks_pr = fullmarks_pr;
	}

	public void setPassmarks_th(Double passmarks_th) {
		this.passmarks_th = passmarks_th;
	}

	public void setPassmarks_pr(Double passmarks_pr) {
		this.passmarks_pr = passmarks_pr;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Set<Marks> getMarks() {
		return marks;
	}

	public void setMarks(Set<Marks> marks) {
		this.marks = marks;
	}
	
	
	
	
}
   
    
    