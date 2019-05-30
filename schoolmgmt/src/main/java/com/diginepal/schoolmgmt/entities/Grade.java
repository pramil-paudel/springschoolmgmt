package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity 
@Table (name="grade")
@Data
@EqualsAndHashCode(callSuper = false)
public class Grade extends BaseEntity{
	private String name; 
}
