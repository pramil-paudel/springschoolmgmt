package com.diginepal.schoolmgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="ethnicgroup")
@Data
@EqualsAndHashCode(callSuper= false)
public class Ethnicgroup extends BaseEntity {
	
	@Column(nullable= true)
	private String name;
}

