package com.diginepal.schoolmgmt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "father")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize
public class Father extends BaseEntity {
	

	
	private String fullname;

	private String address;
	
	private String email;
	
	private String ephone;

	private String office;

	private double income;

	private String position;

	@JsonIgnore
	@OneToOne
	private Student student;

}

