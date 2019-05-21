package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="housegroup")
@Data
@EqualsAndHashCode(callSuper= false)
public class Housegroup extends BaseEntity {
	
	private String name;

}
