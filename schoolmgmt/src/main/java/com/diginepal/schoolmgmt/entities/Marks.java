package com.diginepal.schoolmgmt.entities;

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
@Data
@EqualsAndHashCode(callSuper = false)
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
	

}
