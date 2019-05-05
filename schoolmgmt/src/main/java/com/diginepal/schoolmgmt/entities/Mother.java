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
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Mother")
@Data
@EqualsAndHashCode(callSuper = false)
public class Mother extends BaseEntity{

	@Column(name = "full_name", nullable = false)
	@NotBlank(message = "Full Name Cannot be Null")
	private String fullName;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "email", unique = true)
	@Email(message = "Please Enter Valid Email Address")
	@NotBlank(message = "Email Cannot be Empty")
	private String email;

	@ColumnDefault("0")
	@Column(name = "telephone_no", unique = true, nullable = true)
	private long telephone;

	@Column(name = "mobile_no", unique = true)
	@Pattern(regexp = "\\d{10}|\\d{9}", message = "Invalid Contact Number")
	@NotBlank(message = "Mobile Number Cannot be null")
	private String mobile;

	@Column(name = "e_phone")
	private long ePhone;

	@Column(name = "office")
	private String office;

	@Column(name = "income")
	private double income;

	@Column(name = "position")
	private String position;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mother", orphanRemoval = true)
	private List<Student> students = new ArrayList<>();
}
