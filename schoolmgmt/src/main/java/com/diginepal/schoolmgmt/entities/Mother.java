package com.diginepal.schoolmgmt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Mother")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize
public class Mother extends BaseEntity{

	  
	  private String fullname;
	  private String address;
	  private String email;
	  private long telephone;
	  private String mobile;
	private String ephone;
	private String office;
	private double income;
	private String position;
	
	
	@JsonIgnore
	@OneToOne
	private Student student;
}
