package com.diginepal.schoolmgmt.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="academicdates")
@Data
@EqualsAndHashCode(callSuper = false)
public class Academicdates extends BaseEntity{
	@Column (unique= true, nullable= false) 
	@Temporal(TemporalType.DATE)
	private Date academicdate; 
	@Temporal(TemporalType.DATE)
	@Column (unique= true, nullable= false)
	private Date academicdateen;
}