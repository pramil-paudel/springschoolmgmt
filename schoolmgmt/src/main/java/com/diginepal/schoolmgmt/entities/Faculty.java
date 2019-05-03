package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name= "faculty")
@Data
public class Faculty extends BaseEntity{
	private String name; 
	
	@ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;
}
