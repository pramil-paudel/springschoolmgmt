package com.diginepal.schoolmgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Father")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize
public class Father extends BaseEntity {
	

	
	private String fullName;

	private String address;
	
	private String email;
	
	private long ePhone;

	private String office;

	private double income;

	private String position;


}

