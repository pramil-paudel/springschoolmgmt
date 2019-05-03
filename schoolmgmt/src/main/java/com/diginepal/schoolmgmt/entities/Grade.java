package com.diginepal.schoolmgmt.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Table (name="grade")
@Data
public class Grade extends BaseEntity{
	
	private char name; 
	
	@OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
	private Set<Faculty> faculties;

}
