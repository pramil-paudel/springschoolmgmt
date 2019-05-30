package com.diginepal.schoolmgmt.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table (name= "faculty")
@Data
@EqualsAndHashCode(callSuper = false)
public class Faculty extends BaseEntity{
	private String name; 
	

	
}
