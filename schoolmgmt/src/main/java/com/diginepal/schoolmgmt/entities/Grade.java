package com.diginepal.schoolmgmt.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity 
@Table (name="grade")
@Data
@EqualsAndHashCode(callSuper = false)
public class Grade extends BaseEntity{
	
	private String name; 
	
	@OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
	private Set<Faculty> faculties;

}
