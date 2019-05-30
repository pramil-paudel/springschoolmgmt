package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity 
@Table(name="examtype")
@Data
@EqualsAndHashCode(callSuper = false)
public class Examtype extends BaseEntity {
	private String name;
	}
