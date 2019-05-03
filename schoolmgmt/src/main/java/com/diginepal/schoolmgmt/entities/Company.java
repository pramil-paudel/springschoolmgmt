package com.diginepal.schoolmgmt.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="company")
@Data
public class Company extends BaseEntity {
	private String code;
	private String address; 
	private int phonenumber;
	private String email;
	private String vatpan;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private Set<Branch> branch;
		
}
