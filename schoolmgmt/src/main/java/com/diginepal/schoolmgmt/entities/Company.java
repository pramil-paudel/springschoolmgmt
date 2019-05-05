package com.diginepal.schoolmgmt.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="company")
@Data
@EqualsAndHashCode(callSuper = false)
public class Company extends BaseEntity {
	private String code;
	private String address; 
	private int phonenumber;
	private String email;
	private String vatpan;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private Set<Branch> branch;

	
	
}
