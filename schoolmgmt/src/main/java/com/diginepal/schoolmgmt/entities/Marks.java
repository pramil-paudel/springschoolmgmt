package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity 
@Table (name="marks")
@Data
@EqualsAndHashCode(callSuper = false)
public class Marks extends BaseEntity {

	@OneToOne
	private Academicdates academicdates;  
	
	@OneToOne
	private Grade grade;  
	
	@OneToOne
	private Section section;  

}
