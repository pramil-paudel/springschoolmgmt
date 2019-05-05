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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Localguardian")
@EqualsAndHashCode(callSuper = false)
@Data
public class LocalGuardian extends BaseEntity {
	

	@Column(name = "guradian_name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "phone_no", unique = true)
	private String phone;

	@Column(name = "mobile_no", unique = true)
	private String mobile;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "localGuardian")
	private List<Student> students = new ArrayList<>();
}
