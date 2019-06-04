package com.diginepal.schoolmgmt.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="subjects")
@Data
@EqualsAndHashCode(callSuper= false)
public class Subjects extends BaseEntity implements Serializable{
	
	private String name;
	
	private String subjecttype;
	@Column(unique=true)
	private String code;
	
	@Column (nullable= true)
	private float fullmarks_th;
	
	private float fullmarks_pr;
	
	private float passmarks_th;
	
	private float passmarks_pr; 
	
	@JsonIgnore
	@ManyToMany(mappedBy = "subjects")
    private List<Student> students;
	
	
}
   
    
    