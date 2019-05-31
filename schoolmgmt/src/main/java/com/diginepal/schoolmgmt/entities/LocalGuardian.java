package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "localguardian")
@EqualsAndHashCode(callSuper = false)
@Data
@JsonSerialize
public class LocalGuardian extends BaseEntity {
	

	private String name;

	private String address;

	private String phone;

	private String mobile;
	
	@ManyToOne
	@JsonIgnore
	private Student student;

}
