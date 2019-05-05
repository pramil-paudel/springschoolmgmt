package com.diginepal.schoolmgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="subjects")
@Data
@EqualsAndHashCode(callSuper= false)
public class Subjects extends BaseEntity{
	
	private String name;
	
	private String subjecttype;
	@Column(unique=true)
	private String code;
	
	@Column (nullable= true)
	private float fullmarks_th;
	
	private float fullmarks_pr;
	
	private float passmarks_th;
	
	private float passmarks_pr; 
	
	
}
   
    
    