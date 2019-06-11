package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name="examtype")
public class Examtype extends BaseEntity {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	}
