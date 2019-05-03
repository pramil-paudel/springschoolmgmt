package com.diginepal.schoolmgmt.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity {
	@Id
	@GeneratedValue (strategy= GenerationType. IDENTITY)
	@Column(unique= true, nullable= false)
	private int id;
}
