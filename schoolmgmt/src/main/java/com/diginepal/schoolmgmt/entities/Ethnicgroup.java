package com.diginepal.schoolmgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="ethnicgroup")
@Data
@EqualsAndHashCode(callSuper= false)
public class Ethnicgroup extends BaseEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(name="ethnic_group", nullable= true)
	private String ethnicGroup;
}

