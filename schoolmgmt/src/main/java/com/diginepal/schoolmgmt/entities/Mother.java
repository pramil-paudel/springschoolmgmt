package com.diginepal.schoolmgmt.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Mother")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize
public class Mother extends BaseEntity{

	  
	  private String fullName;
	  private String address;
	  private String email;
	  private long telephone;
	  private String mobile;
	private long ePhone;
	private String office;
	private double income;
	private String position;

}
