package com.diginepal.schoolmgmt.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity 
@Table (name="marks")
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
