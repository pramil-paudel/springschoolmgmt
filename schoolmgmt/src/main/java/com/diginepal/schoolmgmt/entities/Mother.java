package com.diginepal.schoolmgmt.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Mother")
@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize
public class Mother extends BaseEntity{

	
	  @Column(name = "full_name")
	  
	  private String fullName;
	  
	  @Column(name = "address") 
	  private String address;
	  
	  @Column(name = "email")
	  private String email;
	  
	  @Column(name = "telephone_no") 
	  private long telephone;
	  
	  @Column(name = "mobile_no")
	  private String mobile;
	 

	@Column(name = "e_phone")
	private long ePhone;

	@Column(name = "office")
	private String office;

	@Column(name = "income")
	private double income;

	@Column(name = "position")
	private String position;

}
