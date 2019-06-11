package com.diginepal.schoolmgmt.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity 
@Table (name="marks", uniqueConstraints = {
	      @UniqueConstraint(columnNames = {"student_id", "exam_id", "subjects_id"})})
public class Marks extends BaseEntity {

	private long prmarks;
	private long thmarks;
	private String pal;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name = "subjects_id")
	private Subjects subjects;

	public long getPrmarks() {
		return prmarks;
	}

	public void setPrmarks(long prmarks) {
		this.prmarks = prmarks;
	}

	public long getThmarks() {
		return thmarks;
	}

	public void setThmarks(long thmarks) {
		this.thmarks = thmarks;
	}

	public String getPal() {
		return pal;
	}

	public void setPal(String pal) {
		this.pal = pal;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}
	
	
	

}
