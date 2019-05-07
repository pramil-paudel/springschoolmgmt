package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="user")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity{
	
	private char username;
	private char password; 

	@OneToOne
	private Employee employee;

}
